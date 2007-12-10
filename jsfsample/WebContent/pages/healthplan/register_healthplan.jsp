<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>


<f:view>
<f:loadBundle var="msgs" basename="resources.healthplan.label"/>
 <head>
 	<title>${msgs.title}</title>
 </head>
 
 <body>
 	<h:form>
 	
 		<table>
 			<tr>
 				<td>
 					${msgs.first_name}
 				</td>
 				
 				<td>
 					<h:inputText id="firstName" value="#{healthPlanRegistrationForm.firstName}"/>	
				</td>
 			</tr>
 			
 			<tr>
 				<td>
 					${msgs.second_name}
 				</td>
 				
 				<td>
 					<h:inputText id="secondName" value="#{healthPlanRegistrationForm.secondName}"/>
 				</td>
 			</tr>
 			
 			<tr>
 				<td>
 					SSN:
 				</td>
 				
 				<td>
 					<h:inputText id="socialSecurityNumber" value="#{healthPlanRegistrationForm.socialSecurityNumber}"/>
 				</td>
 			</tr>
 			
 			<tr>
 				<td>
 					Annual Salary:
 				</td>
 				
 				<td>
 					<h:inputText id="annualSalary" value="#{healthPlanRegistrationForm.annualSalary}"/>
 				</td>
 			</tr>
 			
 			<tr>
 				<td colspan="2">
 					<h:commandButton  action="#{healthPlanController.registerHealthPlan}" value="Register"/>
 				</td>
 			</tr>
 		</table>
 	</h:form>
 </body>
</f:view>
</HTML> 					
 									