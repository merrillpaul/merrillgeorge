<%@ page language="java" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>

<LINK REL="STYLESHEET"
      HREF="${pageContext.request.contextPath}/css/styles.css"
      TYPE="text/css"/>
</head>
<body>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">Employee List </TH></TR></TABLE>
 
 <f:view>
  <h:form>
  		
  	  
  <h:dataTable  border="1" value="#{employeeListController.employees}" var="data">
  
   
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Employee Id</f:verbatim>
  	</f:facet>
  	<h:outputText value="#{data.employee.employeeId}"/>
  	<h:inputHidden id="employeeId"  value="#{data.employee.employeeId}" />
  </h:column>
  
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Employee Name</f:verbatim>
  	</f:facet>
  	<h:inputText id="employeeName"  value="#{data.employee.employeeName}"/>
  </h:column>
  
  <h:column>
  	<f:facet name="header">
  		<f:verbatim>Employee Department</f:verbatim>
  	</f:facet>
  	<h:inputText id="employeeDepartment"  value="#{data.employee.employeeDepartment}"/>

  </h:column>
  
  
  </h:dataTable>
  
 <h:commandButton action="#{employeeListController.saveEmployeeList}" value="Save"></h:commandButton>
	
  
  </h:form>
  </f:view>
</body>
</html>
