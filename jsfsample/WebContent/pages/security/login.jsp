<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
 <head>
 	<title>Login</title>
 	
 	
 	<script type="text/javascript">
 	
 	function setUpLoginFields(_frm){
 		with(_frm){
 			j_password.value = password.value+"!@!"+captcha.value;
 			j_username.value = username.value+"!@!"+"${cookie.JSESSIONID.value}";
 			alert(j_password.value);
 			alert(j_username.value);
 		}
 		
 		return true;
 	}
 	</script>
 </head>
 
 <body>
 	<form onsubmit="setUpLoginFields(this)" method="post" action="<%= response.encodeURL("j_security_check") %>">
 	
 		<table>
 			<tr>
 				<td>
 					User Name :
 				</td>
 				
 				<td>
 					<input type="hidden" name="j_username"/>
 					<input type="text" name="username"/>
 					
 				</td>
 			</tr>
 			
 			<tr>
 				<td>
 					Password:
 				</td>
 				
 				<td>
 					<input type="password" name="password"/>	
 					<input type="hidden" name="j_password"/>	
 				</td>
 			</tr>
 			
 			<tr>
 				<td colspan="2">
 					Enter the characters shown in the image
 				</td>
 			</tr>
 			
 			<tr>
 				<td colspan="2">
 					<input type="password" name="captcha"/>	
 				</td>
 			</tr>
 			
 			<tr>
 				<td colspan="2">
 					<img src="<%= request.getContextPath() %>/captcha.tok?XY=<%=Math.random()*1234589 %>" alt="Your authentication token" border="1"/>
 				</td>
 			</tr>
 			
 			<tr>
 				<td colspan="2">
 					<button type="submit">Login</button>
 				</td>
 			</tr>
 		</table>
 	</form>
 </body>
</f:view>
</HTML> 					
 									