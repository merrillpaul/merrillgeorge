/**
 * @(#) AbstractValidator.java 1.0 Apr 13, 2007
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

import com.merrill.examples.framework.security.auth.credentials.UserCredentials;
import com.merrill.examples.framework.security.auth.credentials.UserCredentials.Credential;

/**
 * AbstractValidator - Description
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

public abstract class AbstractValidator implements Validator {

	protected UserCredentials userCredentials;
	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.validator.Validator#validate(com.merrill.examples.framework.security.auth.credentials.UserCredentials)
	 */
	public boolean validate(UserCredentials credentials)
			throws ValidationException {
		this.userCredentials = credentials;
		boolean isValid = false;
		if( this.userCredentials==null 
				||
			this.userCredentials.getCredential(Credential.USERNAME)==null
				||
			this.userCredentials.getCredential(Credential.PASSWORD)== null	
		){
			throw new ValidationException("User credentials username/password not provided");
		}
			
		beforeUserValidation();
		
		isValid = validateUser();
		
		afterUserValidation();
		return isValid;
		
	}
	
	protected abstract void beforeUserValidation()  throws ValidationException;
	
	protected abstract boolean validateUser() throws ValidationException;
	
	protected abstract void afterUserValidation() throws ValidationException;

	

}
