<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
 <head>
 	<title>Login</title>
 </head>
 
 <body>
 	<h:form id="loginForm">
 	
 		<table>
 			<tr>
 				<td>
 					Email Id :
 				</td>
 				
 				<td>
 					<h:inputText id="email"/>		
 				</td>
 			</tr>
 			
 			<tr>
 				<td>
 					Password:
 				</td>
 				
 				<td>
 					<h:inputSecret id="password"/>
 				</td>
 			</tr>
 			
 			<tr>
 				<td colspan="2">
 					<h:commandButton action="#{authenticationController.logon}" value="Logon"/>
 				</td>
 			</tr>
 		</table>
 	</h:form>
 </body>
</f:view>
</HTML> 					
 									