/**
 * @(#) UserCredentials.java 1.0 Apr 11, 2007
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
package com.merrill.examples.framework.security.auth.credentials;

import java.util.HashMap;
import java.util.Map;

/**
 * UserCredentials - Description
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
 * 1.0				Apr 11, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class UserCredentials {
	
	
	public enum Credential {
		USERNAME,
		PASSWORD,
		SESSIONID,
		LOGIN_TOKEN,
		GROUP_CODE
	}

	private Map<Credential, String> credentials;

	public UserCredentials() {
		this.credentials = new HashMap<Credential, String>();
	}
	
	public final void setCredential(Credential credential,String value){
		
		this.credentials.put(credential, value);
	}
	
	public final String getCredential(Credential credentialKey)
	{
		return this.credentials.get(credentialKey);
	}
	
}
