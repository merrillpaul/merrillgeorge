/**
 * @(#) TokenInvalidationListener.java 1.0 Apr 9, 2007
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
package com.merrill.examples.framework.security.token.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.merrill.examples.framework.security.token.service.TokenService;

/**
 * TokenInvalidationListener - Description
 * 
 * 
 * @author a-1346
 *
 */

/**
 * <pre>
 * 
 * Revision History
 * Revision 		Date      			Author			Description
 * 1.0				Apr 9, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class TokenInvalidationListener implements HttpSessionListener {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		String sessionId = event.getSession().getId();
		
		String tokenStr = event.getSession().getServletContext().getInitParameter("TOKEN_SERVICE_NAME");
		TokenService service = (TokenService)
		(WebApplicationContextUtils
		.getWebApplicationContext(
				event.getSession().getServletContext()).getBean(tokenStr));
		
		service.removeToken(sessionId);
		

	}

}
