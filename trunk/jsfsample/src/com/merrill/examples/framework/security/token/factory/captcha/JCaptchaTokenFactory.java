/**
 * @(#) JCaptchaTokenFactory.java 1.0 Apr 9, 2007
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
package com.merrill.examples.framework.security.token.factory.captcha;

import com.merrill.examples.framework.security.token.captcha.CaptchaToken;
import com.merrill.examples.framework.security.token.captcha.impl.JCaptchaToken;
import com.merrill.examples.framework.security.token.factory.TokenFactory;
import com.octo.captcha.Captcha;
import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.engine.image.fisheye.SimpleFishEyeEngine;
import com.octo.captcha.service.captchastore.CaptchaStore;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * JCaptchaTokenFactory - Description
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

public class JCaptchaTokenFactory implements TokenFactory {

	/**
	 * com.octo.captcha.engine.image.fisheye.SimpleFishEyeEngine
	 * com.octo.captcha.engine.image.gimpy.DefaultGimpyEngine
	 * com.octo.captcha.engine.image.gimpy.BaffleListGimpyEngine
	 * com.octo.captcha.engine.image.gimpy.FilteredGimpyEngine
	 * com.octo.captcha.engine.image.gimpy.BasicGimpyEngine
	 */
	private CaptchaEngine engine;
	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.token.factory.TokenFactory#getToken()
	 */
	public CaptchaToken getToken() {
		if(engine==null)
			throw new RuntimeException("captcha engine not provided");
		Captcha c = engine.getNextCaptcha();
		
		return new JCaptchaToken(c);
	}
	public void setEngine(CaptchaEngine engine) {
		this.engine = engine;
	}

}
