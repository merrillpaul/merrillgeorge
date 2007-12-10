/**
 * @(#) TokenService.java 1.0 Apr 9, 2007
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
package com.merrill.examples.framework.security.token.service;

import com.merrill.examples.framework.security.token.Token;
import com.merrill.examples.framework.security.token.factory.TokenFactory;

/**
 * TokenService - Description
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

public interface TokenService<T extends Token> {
	T getToken(String id);
	
	void addToken(String id);
	
	void removeToken(String id);
	
	void setTokenFactory(TokenFactory tokenFactory);
}
