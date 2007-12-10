<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
	<head>
		<title>
			Same Color - Color Error
		</title>	
	</head>
	
	<body>
		<f:view>
			
				<div style="border-right: #990033 1px solid;border-bottom: #990033 1px solid;border-top: #990033 1px solid;border-left: #990033 1px solid;">
					You chose
						"<h:outputText value="#{resumeBean.fgColor}"/>"
						as both the foreground and background color.
						<P>
						No job,  <A HREF="index.faces">try again</A>.
				</div>	
				
				
				
			
		</f:view>
		
		<hr/>
		Using JSP2.0 EL
		<hr/>
			You chose
				"${resumeBean.fgColor}"
				as both the foreground and background color.
			<P>
				No job,  <A HREF="index.faces">try again</A>.		
		
	</body>
</html>