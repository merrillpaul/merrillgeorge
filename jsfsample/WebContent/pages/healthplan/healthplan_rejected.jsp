<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<HTML>
<HEAD><title>Rejected</title></HEAD>
<BODY>
<f:view>
<CENTER>
<TABLE BORDER=5>
<TR><TH style="color:red" CLASS="TITLE">Rejected!</TH></TR>
</TABLE>
<H2 style="color:red">
<B>
Hello <h:outputText value="#{healthPlanRegistrationForm.firstName}"/>
with Social Security # <h:outputText value="#{healthPlanRegistrationForm.socialSecurityNumber}"/>

</B>

You are rejected from our health plan.</H2>
As your salary <h:outputText value="#{healthPlanRegistrationForm.annualSalary}"/> is less than 5000
Sorry.
</CENTER>
</f:view>

<hr/>
<B>Using JSP2.0 EL </B>
<br/>
First Name : <B>${healthPlanRegistrationForm.firstName}</B>
<br/>
Second Name : <B>${healthPlanRegistrationForm.secondName}</B>
<br/>
SSN # : <B>${healthPlanRegistrationForm.socialSecurityNumber}</B>
<br/>
Annual Sal : <B>${healthPlanRegistrationForm.annualSalary}</B>


</BODY></HTML>