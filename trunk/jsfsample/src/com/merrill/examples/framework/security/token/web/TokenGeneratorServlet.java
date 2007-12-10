/**
 * @(#) TokenGeneratorServlet.java 1.0 Apr 9, 2007
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

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.merrill.examples.framework.security.token.Token;
import com.merrill.examples.framework.security.token.captcha.CaptchaToken;
import com.merrill.examples.framework.security.token.service.TokenService;

/**
 * TokenGeneratorServlet - Description
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

public class TokenGeneratorServlet extends HttpServlet {

	private TokenService tokenService;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = 
			request.getSession(true);
		
		String sessionId = session.getId();
		
		Token token = tokenService.getToken(sessionId);
		
		if(token == null){
			tokenService.addToken(sessionId);
			token = tokenService.getToken(sessionId);
		}
		
		writeOutToken(response,token);
	}

	private void writeOutToken(HttpServletResponse response, Token token) throws IOException {
		CaptchaToken cToken =(CaptchaToken)token;
		
		BufferedImage image = cToken.getTokenImage();
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(image, "png", bos);
		byte[] imageBytes = bos.toByteArray();
		
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/png");
		response.setContentLength(imageBytes.length);
		OutputStream out = response.getOutputStream();
		out.write(imageBytes);
		out.flush();
		out.close();
		
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		final WebApplicationContext context = 
			WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
		
		String tokenStr = servletConfig.getServletContext().getInitParameter("TOKEN_SERVICE_NAME");
		this.tokenService = (TokenService) context.getBean(tokenStr);
	}

	

}
