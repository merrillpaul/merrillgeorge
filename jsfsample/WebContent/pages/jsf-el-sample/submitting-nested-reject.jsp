<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
 <head>
 	<title>Employee Rejected - Submitting Nested Bean Properties</title>
 </head>
 
 <body>
		<TABLE style="color:red" BORDER=5 ALIGN="CENTER">
		<TR><TH CLASS="TITLE">Employee Rejected</TH></TR>
		</TABLE>
		
		<table style="color:red">
			
			<tr>
				<td>
					Your First Name : <h:outputText value="#{employeeBean.name.firstName}"/>
				</td>
			</tr>
			
			
			<tr>
				<td>
					Your Last Name : <h:outputText value="#{employeeBean.name.lastName}"/>
				</td>
			</tr>
			
			<tr>
				<td>
					Your Company Name : <h:outputText value="#{employeeBean.company.companyName}"/>
				</td>
			</tr>
			
			<tr>
				<td>
					Your Company Business : <h:outputText value="#{employeeBean.company.business}"/>
				</td>
			</tr>
			
			<tr>
				<td>
					Your Salary: <h:outputText value="#{employeeBean.salary}"/>
				</td>
			</tr>
			
			
			
			
		</table>
		
		

 </body>
</f:view>

<hr/>
<B>Using JSP2.0 EL </B>
<br/>

<span>First Name : <B>${employeeBean.name.firstName}</B></span>
<br/>
<span>Last Name : <B>${employeeBean.name.lastName}</B></span>
<br/>
<span>Company Name : <B>${employeeBean.company.companyName}</B></span>
<br/>
<span>Company Business: <B>${employeeBean.company.business}</B></span>
<br/>
<span>Sla: <B>${employeeBean.salary}</B></span>

</HTML> 					
 									