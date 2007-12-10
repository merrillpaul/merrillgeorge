<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
	<head>
		<title>
			Color Picked Success
		</title>	
	</head>
	
	<body>
		<f:view>
			
				<div style="background-color:<h:outputText value="#{colorBean.bgColor}"/>;border-right: #990033 1px solid;border-bottom: #990033 1px solid;border-top: #990033 1px solid;border-left: #990033 1px solid;">
					You Picked
						"<h:outputText value="#{colorBean.bgColor}"/>"
						as color
						
				</div>	
				
				
				
			
		</f:view>
		
		<hr/>
		Using JSP2.0 EL
		<hr/>
			You picked
				"${colorBean.bgColor}"
				as  color.
			
		
	</body>
</html>