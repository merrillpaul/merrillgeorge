<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
 <head>
 	<title>Ajax Samples Index</title>
 </head>
 
 <body>
	<h:form>
		
		<table>
			<tr>
				<td>
					<h:commandLink id="echo" action="showEchoSample" >
						<h:outputText value="Ajax4JSF Echo Sample"/>						
					</h:commandLink>
				</td>
			</tr>
			
			<tr>
				<td>
					<h:commandLink id="dwr" action="showDWRSamples" >
						<h:outputText value="DWR Samples"/>						
					</h:commandLink>
				</td>
			</tr>
			
			
		</table>
		
	</h:form>
 </body>
</f:view>
</HTML> 					
 									