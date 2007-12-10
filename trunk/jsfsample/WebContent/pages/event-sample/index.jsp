<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
	<head>
		<title>
			Event Handling Sample
		</title>	
	</head>
	
	<body>
		<f:view>
			<h:form>
			
				<div style="border-right: #990033 1px solid;border-bottom: #990033 1px solid;border-top: #990033 1px solid;border-left: #990033 1px solid;">
					<span>Color Model</span>
					<span>
						<h:selectBooleanCheckbox
							valueChangeListener="#{resumeBean.changeColorModel}"
							immediate="true"
							onclick="submit()"
						/>
					</span>
				</div>	
			
				<div style="border-right: #990033 1px solid;border-bottom: #990033 1px solid;border-top: #990033 1px solid;border-left: #990033 1px solid;">
					<span>Foreground Color:</span>
					<span>
						<h:selectOneMenu value="#{resumeBean.fgColor}" 
										 disabled="#{!resumeBean.colorSupported}">
						
							<f:selectItems value="#{resumeBean.availableColors}"/>				 
						</h:selectOneMenu>
					</span>
				</div>	
				
				
				<div style="border-right: #dedede 1px solid;border-bottom: #dedede 1px solid;border-top: #dedede 1px solid;border-left: #dedede 1px solid;">
					<span>Background Color:</span>
					<span>
						<h:selectOneMenu value="#{resumeBean.bgColor}" 
										 disabled="#{!resumeBean.colorSupported}">
						
							<f:selectItems value="#{resumeBean.availableColors}"/>				 
						</h:selectOneMenu>
					</span>
				</div>	
				
				
				<div style="border-right: blue 1px solid;border-bottom: blue 1px solid;border-top: blue 1px solid;border-left: blue 1px solid;">
					
					<span>
						<h:commandButton value="#{resumeBean.colorSupportLabel}"
										 actionListener="#{resumeBean.toggleColorSupport}"
										 immediate="true"
										 />
					</span>
				</div>	
				
					
				
			
			
			<hr/>
			
			
				Name : <h:inputText value="#{resumeBean.name}"/>
				<br/>
				Job Title : <h:inputText value="#{resumeBean.jobTitle}"/>
				
				<h:commandButton value="Show Preview" action="#{resumeBean.showPreview}"/>
			</h:form>
			
		</f:view>
	</body>
</html>