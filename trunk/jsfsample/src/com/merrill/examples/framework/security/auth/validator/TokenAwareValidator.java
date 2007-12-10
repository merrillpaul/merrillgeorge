/**
 * @(#) TokenAwareValidator.java 1.0 Apr 13, 2007
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
package com.merrill.examples.framework.security.auth.validator;

import com.merrill.examples.framework.security.auth.credentials.UserCredentials.Credential;
import com.merrill.examples.framework.security.token.Token;
import com.merrill.examples.framework.security.token.service.TokenService;

/**
 * TokenAwareValidator - Description
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
 * 1.0				Apr 13, 2007				a-1346			First draft
 * 
 * </pre>
 */

public abstract class TokenAwareValidator extends AbstractValidator {

	private TokenService tokenService;
	/**
	 * @param tokenService the tokenService to set
	 */
	public void setTokenService(TokenService tokenService) {
		this.tokenService = tokenService;
	}
	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.validator.AbstractValidator#beforeUserValidation()
	 */
	@Override
	protected void beforeUserValidation() throws ValidationException {
		
		String sessionId = this.userCredentials.getCredential(Credential.SESSIONID);
		String tokenKey = this.userCredentials.getCredential(Credential.LOGIN_TOKEN);
		
		if(sessionId==null)
			throw new ValidationException("Token aware validator requires sessionid in user credential");
		if(tokenKey==null)
			throw new ValidationException("Token aware validator requires the token key in user credential");
		
		
		/*Token token = this.tokenService.getToken(sessionId);
		if(!token.validateToken(tokenKey)){
			throw new ValidationException("invalid token : "+tokenKey);
		}
		
		//cleaning up
		this.tokenService.removeToken(sessionId);*/
		
		
	}
	
	
	

}
