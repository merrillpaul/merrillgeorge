<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
 <f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validation Samples Index</title>

<LINK REL="STYLESHEET"
      HREF="${pageContext.request.contextPath}/css/styles.css"
      TYPE="text/css"/>
</head>
<body>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">Enter Bid </TH></TR></TABLE>
 

  <h:form>
  		
  	  <h:outputText value="#{bidController.errorMessages}" escape="false" ></h:outputText>	
	  <div>
	  	<span> User Id :</span>
	  	<span> <h:inputText value="#{bidForm.userId}"/></span>
	  </div>
	  
	   <div>
	  	<span> Keyword :</span>
	  	<span> <h:inputText value="#{bidForm.keyWord}"/></span>
	  </div>
	  
	   <div>
	  	<span> Bid Amount :</span>
	  	<span> <h:inputText value="#{bidForm.bidAmount}"/></span>
	  </div>
	  
	   <div>
	  	<span> Bid Duration :</span>
	  	<span> <h:inputText value="#{bidForm.bidDuration}"/></span>
	  </div>
	  
	   <div>
	  	  	<span> <h:commandButton action="#{bidController.doBid}" value="Send Bid"/></span>
	  </div>
  
  	
  
  </h:form>
 
</body>
</html>
 </f:view>