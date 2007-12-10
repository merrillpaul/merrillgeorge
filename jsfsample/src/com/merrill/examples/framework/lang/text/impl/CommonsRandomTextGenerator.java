/**
 * @(#) CommonsRandomTextGenerator.java 1.0 Apr 10, 2007
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
package com.merrill.examples.framework.lang.text.impl;

import org.apache.commons.lang.RandomStringUtils;

import com.merrill.examples.framework.lang.text.RandomTextGenerator;

/**
 * CommonsRandomTextGenerator - Description
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
 * 1.0				Apr 10, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class CommonsRandomTextGenerator implements RandomTextGenerator {

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.lang.text.RandomTextGenerator#random(int)
	 */
	public String random(int count) {
		return RandomStringUtils.random(count);
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.lang.text.RandomTextGenerator#randomAlphaNumeric(int)
	 */
	public String randomAlphaNumeric(int count) {
		
		return RandomStringUtils.randomAlphanumeric(count);
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.lang.text.RandomTextGenerator#randomAlphabetic(int)
	 */
	public String randomAlphabetic(int count) {
		return RandomStringUtils.randomAlphabetic(count);
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.lang.text.RandomTextGenerator#randomAscii(int)
	 */
	public String randomAscii(int count) {
		return RandomStringUtils.randomAscii(count);
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.lang.text.RandomTextGenerator#randomNumeric(int)
	 */
	public String randomNumeric(int count) {
		return RandomStringUtils.randomNumeric(count);
	}

}
