<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="ajax"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>


<head>
<title>Ajx Echo Sample</title>
</head>

<body>
<f:view>
	<h:form>
		<h:inputText size="50" value="#{echoForm.message}">
			<ajax:support event="onblur" reRender="repeater">
				
			</ajax:support>
		</h:inputText>
		
		<hr/>
		
		<h:outputText id="repeater" value="#{echoForm.ajaxMessage}"></h:outputText>
	</h:form>

</f:view>
</body>

</HTML>
