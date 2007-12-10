<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
	<head>
		<title>
			Resume Preview
		</title>	
	</head>
	<f:view>
	<BODY TEXT="<h:outputText value="#{resumeBean.fgColor}"/>"
		BGCOLOR="<h:outputText value="#{resumeBean.bgColor}"/>">
			<H1 ALIGN="CENTER">
				<h:outputText value="#{resumeBean.name}"/><BR>
				<SMALL><h:outputText value="#{resumeBean.jobTitle}"/>
				</SMALL></H1>
				Experienced <h:outputText value="#{resumeBean.jobTitle}"/>
				seeks challenging position doing something.
				<H2>Employment History</H2>
				
				
		<hr/>
		
	

    </BODY>
    </f:view>
    
    	<span>Using JSP2.0 EL</span>
		
		<div style="background-color:${resumeBean.bgColor};color:${resumeBean.fgColor}"		>
			<div>
			Name is : ${resumeBean.name}
			</div>
			
			<div>
			Title is : ${resumeBean.jobTitle}
			</div>
			
		</div>
</html>