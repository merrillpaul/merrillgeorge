<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<HTML>
<HEAD><title>Accepted</title></HEAD>
<BODY>
<f:view>
<CENTER>
<TABLE BORDER=5>
<TR><TH CLASS="TITLE">Accepted!</TH></TR>
</TABLE>
<B>
Hello <h:outputText value="#{healthPlanRegistrationForm.firstName}"/>
with Social Security # <h:outputText value="#{healthPlanRegistrationForm.socialSecurityNumber}"/>

</B>
<br/>
<H2>You are accepted into our health plan.</H2>
As your salary is <h:outputText value="#{healthPlanRegistrationForm.annualSalary}"/>
Congratulations.
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