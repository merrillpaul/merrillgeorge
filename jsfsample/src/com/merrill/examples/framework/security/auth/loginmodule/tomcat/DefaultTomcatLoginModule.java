/**
 * @(#) DefaulTomcatLoginModule.java 1.0 Apr 13, 2007
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
package com.merrill.examples.framework.security.auth.loginmodule.tomcat;

import java.util.StringTokenizer;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;

import com.merrill.examples.framework.security.auth.credentials.UserCredentials;
import com.merrill.examples.framework.security.auth.credentials.UserCredentials.Credential;
import com.merrill.examples.framework.security.auth.loginmodule.spring.SpringAwareValidatorLoginModule;
import com.merrill.examples.framework.security.user.AbstractGroup;
import com.merrill.examples.framework.security.user.AbstractUser;
import com.merrill.examples.framework.security.user.tomcat.TomcatGroup;
import com.merrill.examples.framework.security.user.tomcat.TomcatUser;

/**
 * DefaulTomcatLoginModule - Description
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

public class DefaultTomcatLoginModule extends SpringAwareValidatorLoginModule {

	private static final String SEPERATOR ="!@!";
	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.loginmodule.AbstractLoginModule#buildCallBacks()
	 */
	@Override
	protected void buildCallBacks() {
		this.callBacks = new Callback[2];
		this.callBacks[0] = new NameCallback("username: ");
		this.callBacks[1] = new PasswordCallback("password: ", false);

	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.loginmodule.AbstractLoginModule#getUser(com.merrill.examples.framework.security.auth.credentials.UserCredentials)
	 */
	@Override
	protected AbstractUser getUser(UserCredentials userData) {
		
		return new TomcatUser(
				userData.getCredential(Credential.USERNAME),
				userData.getCredential(Credential.SESSIONID),
				userData.getCredential(Credential.LOGIN_TOKEN)
		);
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.loginmodule.AbstractLoginModule#getUserGroup(com.merrill.examples.framework.security.auth.credentials.UserCredentials)
	 */
	@Override
	protected AbstractGroup getUserGroup(UserCredentials userData) {
		
		return new TomcatGroup(
					userData.getCredential(Credential.GROUP_CODE)					
				);
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.loginmodule.AbstractLoginModule#onlogout()
	 */
	@Override
	protected void onlogout() {
		// do nothing.
		// initially thought of removing the token
		// after validation

	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.loginmodule.AbstractLoginModule#prepareUserCredentials()
	 */
	@Override
	protected UserCredentials prepareUserCredentials() throws LoginException{
		String name = getCallBackUserName();
		String credential = getCallBackCredentials();
		
		StringTokenizer tok = new StringTokenizer(name,SEPERATOR);
		if(tok.countTokens()!=2){
			throw new LoginException("Name should be provided in the following format : <username>!@!<sessionid>");
		}
		
		String[] inputName = new String[2];
		int i = 0;
		while(tok.hasMoreTokens()){
			inputName[i++]=tok.nextToken();
		}
		
		tok = new StringTokenizer(credential,SEPERATOR);
		if(tok.countTokens()!=2){
			throw new LoginException("password should be provided in the following format : <password>!@!<token>");
		}
		String[] inputPwd = new String[2];
		i = 0;
		while(tok.hasMoreTokens()){
			inputPwd[i++]=tok.nextToken();
		}
		
		UserCredentials userData = new UserCredentials();
		userData.setCredential(Credential.USERNAME, inputName[0]);
		userData.setCredential(Credential.SESSIONID, inputName[1]);
		userData.setCredential(Credential.PASSWORD, inputPwd[0]);
		userData.setCredential(Credential.LOGIN_TOKEN, inputPwd[1]);
		userData.setCredential(Credential.GROUP_CODE, "TSTGROUP");
		
		
		return userData;
		
	}
	
	
	protected String getCallBackUserName() throws LoginException{
		
		String name = ((NameCallback)this.callBacks[0]).getName();
		if(name == null || name.length()==0)
			throw new LoginException("username not provided");
		
		return name;
		
	}

	protected String getCallBackCredentials() throws LoginException{
		PasswordCallback credentialsCallback =((PasswordCallback) this.callBacks[1]);
		
		char[] passwordCh = credentialsCallback.getPassword();
		credentialsCallback.clearPassword();
		
		if(passwordCh == null || passwordCh.length==0)
			throw new LoginException("password not provided");
		
		String str =  new String(passwordCh);
		return str;
	}
	

}
