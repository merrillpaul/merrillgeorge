<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
 <head>
 	<title>Login Result</title>
 </head>
 
 <body>
	<h:form>
		
		<table>
			<tr>
				<td>
					<h:commandLink id="show_health_plan_screen" action="showHealthPlanRegistration" >
						<h:outputText value="Register for Health Plan"/>						
					</h:commandLink>
				</td>
			</tr>
			
			<tr>
				<td>
					<h:commandLink id="tabularSample" action="showTabularSample" >
						<h:outputText value="Tabular Sample"/>						
					</h:commandLink>
				</td>
			</tr>
			
			
			<tr>
				<td>
					<h:commandLink action="showElTest" >
						<h:outputText value="JSF EL Test"/>						
					</h:commandLink>
				</td>
			</tr>
			
			<tr>
				<td>
					<h:commandLink action="showNestedBeanSubmitSample" >
						<h:outputText value="Nested Bean Submitting Sample"/>						
					</h:commandLink>
				</td>
			</tr>
			
			<tr>
				<td>
					<h:commandLink action="showEventsSample" >
						<h:outputText value="Event Handler Sample"/>						
					</h:commandLink>
				</td>
			</tr>
			
			<tr>
				<td>
					<h:commandLink action="showComboEventsSample" >
						<h:outputText value="Event Handler Combination ( Both Action controller and action listsner )Sample"/>						
					</h:commandLink>
				</td>
			</tr>
			
			<tr>
				<td>
					<h:commandLink action="showValidationSamples">
						<h:outputText value="Validation Samples"></h:outputText>
					</h:commandLink>
				</td>
			</tr>
			
			<tr>
				<td>
					<h:commandLink action="implicitValidationSample">
						<h:outputText value="Implicit Validation Sample"></h:outputText>
					</h:commandLink>
				</td>
			</tr>
			
			<tr>
				<td>
					<h:commandLink action="explicitValidationSample">
						<h:outputText value="Explicit Validation Sample"></h:outputText>
					</h:commandLink>
				</td>
			</tr>
			
			
			<tr>
				<td>
					<h:commandLink action="showDBSample">
						<h:outputText value="DB Sample"></h:outputText>
					</h:commandLink>
				</td>
			</tr>
			
			<tr>
				<td>
					<h:commandLink action="showAjaxSamples">
						<h:outputText value="Ajax Samples"></h:outputText>
					</h:commandLink>
				</td>
			</tr>
			
			
			<tr>
				<td>
					Session Id: ${cookie.JSESSIONID.value}
						
				</td>
			</tr>
			
		</table>
		
	</h:form>
 </body>
</f:view>
</HTML> 					
 									