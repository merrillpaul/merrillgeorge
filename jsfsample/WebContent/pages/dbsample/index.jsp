<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
 <f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vessel Types</title>

<LINK REL="STYLESHEET"
      HREF="${pageContext.request.contextPath}/css/styles.css"
      TYPE="text/css"/>
</head>
<body>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">Vessel Types </TH></TR></TABLE>
 

  <h:form>
  		
  	  
  <h:dataTable border="1" value="#{iportMastersVesselTypeUIController.vesselTypes}" var="vesselType">
  
   <h:column>
  	<f:facet name="header">
  		<f:verbatim>Select</f:verbatim>
  	</f:facet>
  </h:column>
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Vessel Type</f:verbatim>
  	</f:facet>
  	<h:outputText value="#{vesselType.vesselType}"/>
  </h:column>
  
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Vessel Type Description</f:verbatim>
  	</f:facet>
  	<h:inputText id="vesselTypeDescription" value="#{vesselType.vesselTypeDescription}"/>
  </h:column>
  
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Entered By</f:verbatim>
  	</f:facet>
  	<h:inputText id="enteredBy" value="#{vesselType.enteredBy}"/>
  	<h:inputHidden id="operationFlag" value="#{vesselType.operationFlag}" />
  </h:column>
  
  
  </h:dataTable>
  
  <TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">Ports </TH></TR></TABLE>
  
  
  <h:dataTable border="1" value="#{iportMastersPortUIController.ports}" var="port">
  
   <h:column>
  	<f:facet name="header">
  		<f:verbatim>Select</f:verbatim>
  	</f:facet>
	
  
  </h:column>
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Port Name</f:verbatim>
  	</f:facet>
  	<h:outputText value="#{port.portName}"/>
  </h:column>
  
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Port Code</f:verbatim>
  	</f:facet>
  	<h:inputText   value="#{port.portCode}"/>
  </h:column>
  
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Entered By</f:verbatim>
  	</f:facet>
  	<h:inputText value="#{port.enteredBy}"/>
  	<h:inputHidden value="#{port.operationFlag}" />
  </h:column>
  
  
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Description</f:verbatim>
  	</f:facet>
  	<h:inputText value="#{port.portDesc}"/>
  </h:column>
  
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Country code</f:verbatim>
  	</f:facet>
  	<h:inputText value="#{port.countryCode}"/>
  </h:column>
  
  
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Company Port ?</f:verbatim>
  	</f:facet>
  	<h:selectBooleanCheckbox  value="#{port.shjPort}"/>
  </h:column>
  
  </h:dataTable>
  
	
  
  </h:form>
 
</body>
</html>
 </f:view>