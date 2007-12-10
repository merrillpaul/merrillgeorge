/**
 * @(#) AuthenticationController.java 1.0 Mar 13, 2007
 * Copyright 2005 IBS Software Services (P) Ltd. All Rights Reserved.
 *  
 * This software is the proprietary information of IBS Software Services (P) Ltd.
 * Use is subject to license terms.
 *
 * Warning: This software is protected by copyright law and international treaties 
 * and conventions. Unauthorized use, distribution or reproduction of this software, 
 * or of any parts thereof, may result in prosecution and penalties." 
 *
 */
package com.merrill.examples.client.controller.security;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * iCargo AuthenticationController - Description 
 * 
 * @author A-1346
 *
 */

/**
 * <pre>
 * 
 * Revision History
 * Revision 		Date      			Author			Description
 * 1.0			Mar 13, 2007					A-1346			First draft
 * 
 * </pre>
 */
public class AuthenticationController {
	public String logon(){
		
		// getting logon parameters in the legacy way
		ExternalContext externalContext=
			FacesContext.getCurrentInstance().getExternalContext();
		
		HttpServletRequest request =
			(HttpServletRequest)externalContext.getRequest();
		
		String email = (String)request.getParameter("loginForm:email");
		String password = (String)request.getParameter("loginForm:password");
		
		
		
		
		if ((email == null) ||
			(email.trim().length() < 3) ||
		    (email.indexOf("@") == -1)) {
				return("bad-address");
		} else if ((password == null) ||
				   (password.trim().length() < 6)) {
				return("bad-password");
		} else {
			return("success");
		}
	}
}
