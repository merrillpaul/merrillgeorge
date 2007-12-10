<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
 <head>
 	<title>JSF EL Test - Accessing Bean Properties</title>
 </head>
 
 <body>

		
		<table>
			<tr>
				<td>
					Creation time : <h:outputText value="#{testBean.creationTime}"/>
				</td>
			</tr>
			
			
			<tr>
				<td>
					Greeting : <h:outputText value="#{testBean.greeting}"/>
				</td>
			</tr>
			
			<tr>
				<td>
					Random Number : <h:outputText value="#{testBean.randomNumber}"/>
				</td>
			</tr>
			
		</table>
		<hr/>
		<B> Using JSP2.0 EL </B>
		<ul>
			<li> Creation Time : ${testBean.creationTime}</li>
			<li> Greeting : 	${testBean.greeting}</li>
			<li> Rnd No : ${testBean.randomNumber}</li>
		</ul>	
		

 </body>
</f:view>
</HTML> 					
 									