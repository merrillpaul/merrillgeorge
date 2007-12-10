<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
	<head>
		<title>
			COmbination Event Handling Sample
		</title>	
	</head>
	
	<body>
		<f:view>
			<h:form>
			
				<div style="border-right: #990033 1px solid;border-bottom: #990033 1px solid;border-top: #990033 1px solid;border-left: #990033 1px solid;">
					<span>Pick Color</span>
					<span>
						<h:commandButton image="../images/GrayBar.gif"
										 actionListener="#{colorBean.pickColor}"
										 action="#{colorBean.updateView}"
						/>				 
					</span>
				</div>	
			
				
			</h:form>
			
		</f:view>
	</body>
</html>