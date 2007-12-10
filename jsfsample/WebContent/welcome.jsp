<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<HEAD><TITLE>Welcome to JSF</TITLE>
<LINK REL="STYLESHEET"
      HREF="./css/styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">Welcome </TH></TR></TABLE>
<P>
This is the <I>welcome.faces</I> page
for the <CODE>jsf-blank</CODE> application.

<hr/>
<f:view>
 <h:form>
 	<h:commandLink id="enterLink" action="enter">
 		<h:outputText value="Enter" />
 	</h:commandLink>	
 </h:form>
</f:view>
</BODY>
<%
javax.naming.Context ctx = new javax.naming.InitialContext();


javax.sql.DataSource ds =
         (javax.sql.DataSource)ctx.lookup("java:comp/env/jdbc/jpasample");
java.sql.Connection connection =  ds.getConnection();        
System.out.println(connection.getMetaData().getDatabaseProductName()+":"+connection.getMetaData().getDatabaseProductVersion());
%>
</HTML>