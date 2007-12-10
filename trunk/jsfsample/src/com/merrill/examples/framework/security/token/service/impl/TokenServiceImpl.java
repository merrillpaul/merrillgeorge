/**
 * @(#) TokenServiceImpl.java 1.0 Apr 9, 2007
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
package com.merrill.examples.framework.security.token.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.merrill.examples.framework.security.token.Token;
import com.merrill.examples.framework.security.token.factory.TokenFactory;
import com.merrill.examples.framework.security.token.service.TokenService;

/**
 * TokenServiceImpl - Description
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

public class TokenServiceImpl implements TokenService {

	private TokenFactory tokenFactory;
	private Map<String, Token> tokens = Collections.synchronizedMap(new HashMap<String,Token>());

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.token.service.TokenService#addToken(java.lang.String, com.merrill.examples.framework.security.token.Token)
	 */
	public void addToken(String id) {
		Token token = tokenFactory.getToken();
		this.tokens.put(id,token);

	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.token.service.TokenService#getToken(java.lang.String)
	 */
	public Token getToken(String id) {
		return this.tokens.get(id);
		
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.token.service.TokenService#removeToken(java.lang.String)
	 */
	public synchronized void removeToken(String id) {
		this.tokens.remove(id);

	}

	public void setTokenFactory(TokenFactory tokenFactory) {
		this.tokenFactory = tokenFactory;
		
	}

}
