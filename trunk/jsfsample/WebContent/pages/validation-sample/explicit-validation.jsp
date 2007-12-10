<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
 <f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Implicit Validation Sample</title>

<LINK REL="STYLESHEET"
      HREF="${pageContext.request.contextPath}/css/styles.css"
      TYPE="text/css"/>
</head>
<body>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">Enter Bid </TH></TR></TABLE>
 

  <h:form>
  		
  	 
	  <div>
	  	<span> User Id :</span>
	  	<span> <h:inputText value="#{bidForm1.userId}" id="userId" >
	  				<f:validateLength maximum="6" minimum="5"/>
	  		   </h:inputText>	
	  	</span>
	  	<span><h:message for="userId" styleClass="RED"></h:message></span>
	  </div>
	  
	   <div>
	  	<span> Keyword :</span>
	  	<span> 
	  	<h:inputText value="#{bidForm1.keyWord}" id="keyWord" >
	  		<f:validateLength minimum="3"/>
	  	</h:inputText>
	  	
	  	</span>
	  	<span><h:message for="keyWord" styleClass="RED"></h:message> </span>
	  </div>
	  
	   <div>
	  	<span> Bid Amount :</span>
	  	<span>
	  	 <h:inputText value="#{bidForm1.bidAmount}" id="bidAmount">
	  	 	<f:validateDoubleRange minimum="0.10"/>
	  	 
	  	 </h:inputText>
	  	 
	  	 <h:outputText value="#{bidForm1.bidAmount}">
	  	 		<f:convertNumber currencyCode="INR" currencySymbol="$"/>
	  	 </h:outputText>
	  	
	  	</span>
	  	<span><h:message for="bidAmount" styleClass="RED"></h:message> </span>
	  </div>
	  
	   <div>
	  	<span> Bid Duration :</span>
	  	<span>
	  	 <h:inputText value="#{bidForm1.bidDuration}" id="bidDuration">
	  	 	<f:validateLongRange minimum="15"/>
	  	 </h:inputText>
	  	</span>
	  	<span> <h:message for="bidDuration" styleClass="RED"></h:message> </span>
	  </div>
	  
	   <div>
	  	  	<span> <h:commandButton action="#{bidController1.doBid}" value="Send Bid"/></span>
	  </div>
  
  	
  
  </h:form>
 
</body>
</html>
 </f:view>