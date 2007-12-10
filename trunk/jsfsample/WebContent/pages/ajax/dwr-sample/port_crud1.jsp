<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>


 <head>
 	<title>DWR Port CRUD Sample1</title>
 	<script type="text/JavaScript" src="${pageContext.request.contextPath}/pages/ajax/dwr-sample/prototype/prototype.js"></script>
	<script type="text/JavaScript" src="${pageContext.request.contextPath}/pages/ajax/dwr-sample/scriptaculous/scriptaculous.js"></script>
	<script type="text/JavaScript" src="${pageContext.request.contextPath}/pages/ajax/dwr-sample/scriptaculous/unittest.js"></script>
	<script type="text/JavaScript" src="${pageContext.request.contextPath}/pages/ajax/dwr-sample/hashtable/hashtable.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/engine.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/util.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/PortUIController.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/VesselTypeUIController.js"></script>
 		<script type="text/JavaScript" src="${pageContext.request.contextPath}/pages/ajax/dwr-sample/autocomplete.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/ajax/dwr-sample/port_crud1.js"></script> 	
<style type="text/css" media="screen">
    .selected {
	
	font-family: arial, helvetica, sans-serif;
	font-size: 11px;
	color: black;
	background-color: #99ccff;
	border-bottom: 1px solid #999999;
	white-space: nowrap;
	border:0;

}
   
    
  </style>
 </head>
 
 <body>
		
		<div style="height:90%">
			<h2>Ports</h2>
			<input type="text" style="width:90px" name="portMatcher" id="portMatcher"/>
			Vessel Type = <input type="text" style="width:100px" name="vesselTypeMatcher" id="vesselTypeMatcher"/>
			<br/><select id="ac4"><option>First Item</option><option>Second Item</option><option>Third Item</option></select>
			<div style="font-family: arial, helvetica, sans-serif;font-size: 11px;z-index: 21223;display:none;border:1px solid black;background-color:#77879D"  id="auto_completer_suggestions" ></div>
			<button type="button" onclick="getPorts()">Get Ports</button>
			<div style="background-color:#cccccc;font-weight:bold;font-size:14px" id="recNumber"></div>
			<div style="height:50%;position:relative;overflow:auto">
			
				<table border="1">
					<thead>
						<tr>
							<th>Code</th>
							<th>Port Name</th>
							<th>Port Description</th>
							<th>Country Code</th>
							<th>Company Port?</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					
					<tbody id="portsBody">
						<tr border="1" id="templateRow" style="display:none">
							<td><span id="tblportCode">Port Code</span></td>
							<td><span id="tblportName">Port Name</span></td>
							<td><span id="tblportDesc">Port Description</span></td>
							<td><span id="tblcountryCode">Country Code</span></td>
							<td><span style="width:10px;height:10px" id="tblcompanyPort"><input type="checkbox" id="tblisCompanyPort"/></span></td>
							<td>
								<button type="button" id="edit" onclick="editPort(this.id)">Edit</button>
								<button type="button" id="delete" onclick="deletePort(this.id)">Delete</button>
							</td>
						</tr>
					</tbody>
				</table>
				
			</div>
			
			<h2>Edit Port</h2>
			<div>
				<table>
					<tr>
						<td>Port Code</td>
						<td><input id="portCode" type="text" /></td>
					</tr>
					
					<tr>
						<td>Port Name</td>
						<td><input id="portName" type="text" /></td>
					</tr>
					
					<tr>
						<td>Port Desc</td>
						<td><input id="portDesc" type="text" /></td>
					</tr>
					
					<tr>
						<td>Country</td>
						<td><input id="countryCode" type="text" /></td>
					</tr>
					
					<tr>
						<td>Company Port ?</td>
						<td>
							<input id="shjPort" type="checkbox" />
							<input id="operationFlag" type="hidden" value="I"/>
							<input id="version" type="text" readonly="readonly"/>
						</td>
					</tr>
					
					<tr>
						<td><button type="button" id="save" onclick="savePort()">Save</button></td>
						<td><button type="button" id="clear" onclick="clearPort()">Clear</button></td>
					</tr>
					
				</table>
			</div>
		
		</div>
		
 </body>
 

</html> 					
 									