/**
 * @(#) SimpleCaptchaTokenFactory.java 1.0 Apr 9, 2007
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

import com.merrill.examples.framework.lang.text.RandomTextGenerator;
import com.merrill.examples.framework.security.token.captcha.CaptchaToken;
import com.merrill.examples.framework.security.token.captcha.impl.SimpleCaptchaToken;
import com.merrill.examples.framework.security.token.factory.TokenFactory;

/**
 * SimpleCaptchaTokenFactory - Description
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

public class SimpleCaptchaTokenFactory implements TokenFactory {
	
	private RandomTextGenerator randomTextGenerator;
	
	
	public void setRandomTextGenerator(RandomTextGenerator randomTextGenerator) {
		this.randomTextGenerator = randomTextGenerator;
	}


	//private Random generator = new Random(Calendar.getInstance().getTimeInMillis());
	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.token.factory.TokenFactory#getToken()
	 */
	public CaptchaToken getToken() {
		
        String strToken = null;
        //int tempToken = 0;
        
        //get the next random int and convert it to a string
       /* tempToken = generator.nextInt();
        if ( tempToken < 0 ) {
            tempToken = -1 * tempToken;
        }
        strToken = Integer.toString(tempToken).substring(0, 4);*/
        strToken = this.randomTextGenerator.randomAlphaNumeric(8);
        return new SimpleCaptchaToken(strToken);
	}

}
