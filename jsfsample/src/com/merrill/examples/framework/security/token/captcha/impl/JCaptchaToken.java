/**
 * @(#) JCaptchaToken.java 1.0 Apr 9, 2007
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
package com.merrill.examples.framework.security.token.captcha.impl;

import java.awt.image.BufferedImage;

import com.merrill.examples.framework.security.token.captcha.CaptchaToken;
import com.octo.captcha.Captcha;
import com.octo.captcha.image.ImageCaptcha;

/**
 * JCaptchaToken - Description
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

public class JCaptchaToken implements CaptchaToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6935566946623040474L;
	private Captcha captcha;
	
	
	public JCaptchaToken(Captcha captcha) {
		super();
		this.captcha = captcha;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.token.captcha.CaptchaToken#getTokenImage()
	 */
	public BufferedImage getTokenImage() {
		return ((ImageCaptcha)captcha).getImageChallenge();
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.token.Token#validateToken(java.lang.String)
	 */
	public boolean validateToken(String tokenKey) {
		return captcha.validateResponse(tokenKey).booleanValue();
	}

}
