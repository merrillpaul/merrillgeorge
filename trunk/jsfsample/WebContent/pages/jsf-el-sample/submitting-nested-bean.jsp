<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
 <head>
 	<title>JSF EL Test - Submitting Nested Bean Properties</title>
 </head>
 
 <body>

		<h:form>
		<table>
			<tr>
				<td>
					First Name : <h:inputText value="#{employeeBean.name.firstName}"/>
				</td>
			</tr>
			
			
			<tr>
				<td>
					Last Name : <h:inputText value="#{employeeBean.name.lastName}"/>
				</td>
			</tr>
			
			<tr>
				<td>
					Company Name : <h:inputText value="#{employeeBean.company.companyName}"/>
				</td>
			</tr>
			
			<tr>
				<td>
					Company Business : <h:inputText value="#{employeeBean.company.business}"/>
				</td>
			</tr>
			
			<tr>
				<td>
					Emp Salary: <h:inputText value="#{employeeBean.salary}"/>
				</td>
			</tr>
			
			
			<tr>
				<td>
					<h:commandButton value="Process Employee" action="#{employeeBean.processEmployee}" />
				</td>
			</tr>
			
		</table>
		</h:form>
		

 </body>
</f:view>
</HTML> 					
 									