/*
 * This autocompleter should be constructed with a given populator function.
 * The populator function should call the setChoices(choices) method on this autocompleter
 * where 'choices' is the array of choices to be displayed in the autocomplete div.
 */

/*
examples

function createAutoCompleter() {
          new Autocompleter.DWR(
          "portMatcher", 							// id of the target field 
          "PortUIController.getPortsForName", 		// the dwr ajax call whhich gets the list of objects 
          { 									    // option set
            afterUpdateElement: portSelected, 		// call back on selection of an item
            valueSelector: portValueSelector,		// based on what the comparison should happen
            extraDisplayParams : portDisplayValues  // any other extra values to be shown. if not provided only the valueSelector  is shown
          }
          ,3										// mimimum number of characters to be entered in the field before a query occurs
          );

 }
 
 
 
function portSelected(inputElement,selectedElement,selectedPort){
 	inputElement.value = selectedPort.portCode;
}
 
function portValueSelector(port){
 	return port.portName;
}
 
function portDisplayValues(port){
 	return new Array(port.portCode, port.portDesc);
} 
*/

Autocompleter.iCargo = Class.create();
Autocompleter.iCargo.prototype = Object.extend(new Autocompleter.Base(), {
  initialize: function(element, populator, options,minimumTokenLength) {
    this.baseInitialize(element, "auto_completer_suggestions", options);
    this.options.array = new Array(0);
    this.populator = populator;
    this.choicesCache = new Hashtable();
    this.minTokenLength = minimumTokenLength==null ? 3: minimumTokenLength;
    this.options.minChars = this.minTokenLength;
	this.options.frequency = 0.5;
	
    
  },
  populateAutoComplete: function(token,instance){
    if(token.length>=this.minTokenLength){
  	eval(this.populator+"(token,function(_arr){instance.setChoices(_arr)})");
  	}
  },
  // called by the autocompleter on an event.
  getUpdatedChoices: function() {
    //this.populator(this, this.getToken()); // this is the populator specified in the constructor.
    if(this.choicesCache.get(this.getToken().toUpperCase())==null){
    	
    	this.populateAutoComplete(this.getToken().toUpperCase(),this);
    }else{
    	
    	this.setChoices(this.choicesCache.get(this.getToken().toUpperCase()));
    }
  },

  // should be called by the populator (specified in the constructor)
  setChoices: function(array) {
    this.options.array = array;
   
    if(this.choicesCache.get(this.getToken().toUpperCase())==null){
    	
    	var tmpArr = new Array(0);
    	var elementObj=null;
    	for (var i = 0; i < this.options.array.length &&
          tmpArr.length < this.options.choices ; i++) {
          	elementObj = this.options.array[i];
          	tmpArr.push(elementObj);
        
         } 
    	this.choicesCache.put(this.getToken().toUpperCase(),tmpArr);
    }
    this.updateChoices(this.options.selector(this));
  },

  onHover: function(event) { 
    var element = Event.findElement(event, 'TR');
    if(this.index != element.autocompleteIndex) 
    {
        this.index = element.autocompleteIndex;
        this.render();
    }
    Event.stop(event);
  },
  onClick: function(event) {  /* to override*/
    var element = Event.findElement(event, 'TR');
    this.index = element.autocompleteIndex;
    this.selectEntry();
    this.hide();
  },
  getEntry: function(index) { /* to override*/

    return this.update.firstChild.firstChild.childNodes[index];
  },
  
  updateChoices: function(choices) { /* to override*/
  
    if(!this.changed && this.hasFocus) {
   	  
      this.update.innerHTML = choices;
      
      Element.cleanWhitespace(this.update);
      Element.cleanWhitespace(this.update.firstChild);
      Element.cleanWhitespace(this.update.firstChild.firstChild);
     
    
      

      if(this.update.firstChild && this.update.firstChild.firstChild && this.update.firstChild.firstChild.childNodes) {
        this.entryCount = 
          this.update.firstChild.firstChild.childNodes.length;
        for (var i = 0; i < this.entryCount; i++) {
       
          var entry = this.getEntry(i);
          entry.autocompleteIndex = i;
          this.addObservers(entry);
        }
      } else { 
        this.entryCount = 0;
      }

      this.stopIndicator();

      this.index = 0;
      this.render();
    }
  },
  setOptions: function(options) {
    this.options = Object.extend({
      choices: 10,
      partialSearch: true,
      partialChars: 2,
      ignoreCase: true,
      fullSearch: false,
      updateElement : function (selectedElement,instance){
      	var value = '';
	    if (instance.options.select) {
	      var nodes = document.getElementsByClassName(instance.options.select, selectedElement) || [];
	      if(nodes.length>0) value = Element.collectTextNodes(nodes[0],instance.options.select);
	    } else
	      value = Element.collectTextNodesIgnoreClass(selectedElement, 'informal');
	    
	    var lastTokenPos = instance.findLastToken();
	    if (lastTokenPos != -1) {
	      var newValue = instance.element.value.substr(0, lastTokenPos + 1);
	      var whitespace = instance.element.value.substr(lastTokenPos + 1).match(/^\s+/);
	      if (whitespace)
	        newValue += whitespace[0];
	      instance.element.value = newValue + value;
	    } else {
	      instance.element.value = value;
	    }
	    instance.element.focus();
	    var obj = instance.options.array[instance.index];
	   if (instance.options.afterUpdateElement)
	      instance.options.afterUpdateElement(instance.element, selectedElement,obj);
      },
      selector: function(instance) {
        var ret       = []; // Beginning matches
        var partial   = []; // Inside matches
        var entry     = instance.getToken();
        var count     = 0;
       
		
        for (var i = 0; i < instance.options.array.length &&
          ret.length < instance.options.choices ; i++) {
		   var extraValStr="";
          var elementObj = instance.options.array[i];
          var elem = (instance.options.valueSelector(elementObj));
          
          if(instance.options.extraDisplayParams){
          	var extraVals = instance.options.extraDisplayParams(elementObj);
          	for(var rt=0;rt<extraVals.length;rt++){
          		var tmp="<label style='color:maroon'>-NA-</label>";
          		if(extraVals[rt]!=null)
          		tmp = extraVals[rt];
          		extraValStr+="<td style='white-space: nowrap;margin-left:5px;margin-right:5px'>";
          		
          		extraValStr+=tmp;
          		extraValStr+="<span style='width:5px'>&nbsp;</span></td>";
          	}
          }
          
          var foundPos = instance.options.ignoreCase ?
            elem.toLowerCase().indexOf(entry.toLowerCase()) :
            elem.indexOf(entry);

          while (foundPos != -1) {
            if (foundPos == 0 && elem.length != entry.length) {
              /*ret.push("<li  style='white-space: nowrap;margin-left:5px;margin-right:3px'><span><strong>" + elem.substr(0, entry.length) + "</strong>" +
                elem.substr(entry.length) + "</span></li>");*/
                ret.push("<tr ><td style='white-space: nowrap;margin-left:5px;margin-right:8px'><span style='width:5px'>&nbsp;</span><strong>" + elem.substr(0, entry.length) + "</strong>" +
                elem.substr(entry.length) + "<span style='width:5px'>&nbsp;</span></td>"+extraValStr+"</tr>");
              break;
            } else if (entry.length >= instance.options.partialChars &&
              instance.options.partialSearch && foundPos != -1) {
              if (instance.options.fullSearch || /\s/.test(elem.substr(foundPos-1,1))) {
               /* partial.push("<li style='white-space: nowrap;margin-left:5px;margin-right:3px'><span>" + elem.substr(0, foundPos) + "<strong>" +
                  elem.substr(foundPos, entry.length) + "</strong>" + elem.substr(
                  foundPos + entry.length) + "</span></li>");*/
                  partial.push("<tr ><td style='white-space: nowrap;margin-left:5px;margin-right:8px'><span style='width:5px'>&nbsp;</span>" + elem.substr(0, foundPos) + "<strong>" +
                  elem.substr(foundPos, entry.length) + "</strong>" + elem.substr(
                  foundPos + entry.length) + "<span style='width:5px'>&nbsp;</span></td>"+extraValStr+"</tr>");
                  
                break;
              }
            }

            foundPos = instance.options.ignoreCase ?
              elem.toLowerCase().indexOf(entry.toLowerCase(), foundPos + 1) :
              elem.indexOf(entry, foundPos + 1);

          }
        }
        if (partial.length)
          ret = ret.concat(partial.slice(0, instance.options.choices - ret.length))
        //return "<ul style='list-style-type: none;margin-left:12px'>" + ret.join('') + "</ul>";
        return "<table cellpadding='0' cellspacing='0' style='font-family: arial, helvetica, sans-serif;font-size: 11px;z-index:21228'>" + ret.join('') + "</table>";
      }
    }, options || {});
  }
});