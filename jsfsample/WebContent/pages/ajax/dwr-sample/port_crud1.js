window.onload=initScreen;

var portCache={ };

function initScreen(){
	//dwr.util.useLoadingMessage();
	if(document.getElementById('portMatcher').value.length>2){
		fillPortsTable(document.getElementById('portMatcher').value);
	}
	createAutoCompleter();
}


 function createAutoCompleter() {
          new Autocompleter.iCargo("portMatcher",  "PortUIController.getPortsForName", {afterUpdateElement: portSelected, valueSelector: portValueSelector, extraDisplayParams : portDisplayValues},3);
          new Autocompleter.iCargo("vesselTypeMatcher",  "VesselTypeUIController.getVesselTypes", {afterUpdateElement: vesselTypeSelected, valueSelector: vesselTypeValueSelector},2);
 }

 function portSelected(inputElement,selectedElement,selectedPort){

 	inputElement.value = selectedPort.portName;
 	alert("You selected "+selectedPort.portCode+" : "+selectedPort.portName);
 }
 
 function portValueSelector(port){
 	return port.portName;
 }
 
 function portDisplayValues(port){
 	return new Array(port.portCode, port.portDesc);
 }

 
 function vesselTypeSelected(inputElement,selectedElement,selectedVesselType){
 
 	inputElement.value = selectedVesselType.vesselType;
 }
 
 function vesselTypeValueSelector(vesselType){
 	return vesselType.vesselTypeDescription;
 }
 
 
 
function fillPortsTable(_matcherName){
	PortUIController.getPortsForName(_matcherName.toUpperCase(),
									function(ports){
										// Delete all the rows except for the "pattern" row
									    dwr.util.removeAllRows("portsBody", { filter:function(tr) {
									      return (tr.id != "templateRow");
									    }});
									    
									    $('recNumber').innerHTML=ports.length+ " Records  found !";
									    var eachPort, id;
									    for(var i=0;i<ports.length;i++){
									    	eachPort = ports[i];
									    	id = eachPort.portCode;
									    	dwr.util.cloneNode("templateRow", { idSuffix:id  });
								       	    dwr.util.setValue("tblportCode" + id, eachPort.portCode);
									        dwr.util.setValue("tblportName" + id, eachPort.portName);
									        dwr.util.setValue("tblportDesc" + id, eachPort.portDesc);
									        dwr.util.setValue("tblcountryCode" + id, eachPort.countryCode);
									       // dwr.util.setValue("companyPort" + id, eachPort.shjPort);
									        if(eachPort.shjPort){
									        	$("tblcompanyPort" + id).style.backgroundColor = "green"; 
									        	$("tblcompanyPort" + id).parentNode.style.backgroundColor = "green"; 
									        	$("tblisCompanyPort" + id).checked = true; 
									        }
									        else{
									        	
									        	$("tblcompanyPort" + id).style.backgroundColor = "red"; 
									        	$("tblcompanyPort" + id).parentNode.style.backgroundColor = "red"; 
									        	$("tblisCompanyPort" + id).checked = false; 
									        	}
									        $("templateRow" + id).style.display = ""; 
									        if((i%2)==0){
									        	$("templateRow" + id).style.backgroundColor="#F7F7FF";
									        }else{
									        	$("templateRow" + id).style.backgroundColor="#BDD8EB";
									        }
										    portCache[id] = eachPort;
									    }
									    
									   
									    
									}
	);
}


function getPorts(){

  if(document.getElementById('portMatcher').value.length>=2){	
	fillPortsTable(document.getElementById('portMatcher').value);
  }else{
  	alert('at least 2 chars to be entered');
  	document.getElementById('portMatcher').focus();
  }
}


function editPort(portCode){
	var port = portCache[portCode.substring(4)];
	
		
	
	dwr.util.setValues(port);
	$('operationFlag').value='U';
	$('portCode').disabled=true;
	
}

function deletePort(portCode){
	var port = portCache[portCode.substring(6)];
	 if (confirm("Are you sure you want to delete " + port.portName + "?")) {
	 	port.operationFlag='D';
	 	dwr.engine.beginBatch();
		PortUIController.savePort(port);
		getPorts();
		dwr.engine.endBatch();
		clearPort();
	 }
}

function clearPort(){
	dwr.util.setValues({ portCode:null, portName:null, portDesc:null,countryCode:null,shjPort:null,operationFlag:'I',version:null });
	$('portCode').disabled=false;
	
}


function savePort(){
	
	var port = { portCode:null, portName:null, portDesc:null,countryCode:null,shjPort:null,operationFlag:null,enteredBy:'RUDY' ,version:null}
	dwr.util.getValues(port);
	if(port.operationFlag=='I'){
		$('portMatcher').value = port.portName;
	}
	dwr.engine.beginBatch();
	PortUIController.savePort(port);
	getPorts();
	dwr.engine.endBatch();
	clearPort();
}