/**
 * @(#) AbstractLoginModule.java 1.0 Apr 11, 2007
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
package com.merrill.examples.framework.security.auth.loginmodule;

import java.io.IOException;
import java.util.Map;
import java.util.Vector;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import com.merrill.examples.framework.security.auth.credentials.UserCredentials;
import com.merrill.examples.framework.security.auth.validator.ValidationException;
import com.merrill.examples.framework.security.auth.validator.Validator;
import com.merrill.examples.framework.security.user.AbstractGroup;
import com.merrill.examples.framework.security.user.AbstractUser;

/**
 * AbstractLoginModule - Description
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

public abstract class AbstractLoginModule implements LoginModule {

	private static final String CREDENTIAL_VALIDATOR = "credentialValidator";

	protected Subject subject;

	protected CallbackHandler callBackHandler;

	protected Callback[] callBacks;

	protected Vector principals;

	protected Map<String, ? extends Object> options;

	protected boolean authenticated;

	private boolean commited;

	private Validator validator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.security.auth.spi.LoginModule#initialize(javax.security.auth.Subject,
	 *      javax.security.auth.callback.CallbackHandler, java.util.Map,
	 *      java.util.Map)
	 */
	public final void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ? extends Object> options) {
		this.subject = subject;
		this.callBackHandler = callbackHandler;
		this.options = options;
		
		/*loadCredentialsValidator((String) this.options
				.get(CREDENTIAL_VALIDATOR));*/
		initLoginModule();
		this.validator = initValidator();

	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.security.auth.spi.LoginModule#login()
	 */
	public final boolean login() throws LoginException {

		buildCallBacks();
		executeCallBacks();
		UserCredentials userCredentials = 
			prepareUserCredentials();
		try {
			authenticated = this.validator
							.validate(userCredentials);
		} catch (ValidationException e) {
			e.printStackTrace();
			throw new LoginException(e.getMessage());
		}
		
		if (authenticated) {
			buildPrincipals(userCredentials);
		} else {
			throw new FailedLoginException("Failed login procedure");
		}

		return this.authenticated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.security.auth.spi.LoginModule#logout()
	 */
	public final boolean logout() throws LoginException {

		onlogout();
		if (this.authenticated) {
			this.subject.getPrincipals().removeAll(this.principals);
		}
		this.authenticated = false;
		this.commited = false;

		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.security.auth.spi.LoginModule#abort()
	 */
	public final boolean abort() throws LoginException {

		return this.logout();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.security.auth.spi.LoginModule#commit()
	 */
	public final boolean commit() throws LoginException {
		if (this.authenticated) {
			this.subject.getPrincipals().addAll(this.principals);
			this.commited = true;
		}
		return this.commited;
	}

	protected void executeCallBacks() throws LoginException {

		try {
			this.callBackHandler.handle(this.callBacks);
		} catch (IOException e) {
			e.printStackTrace();
			throw new LoginException(e.toString());
		} catch (UnsupportedCallbackException e) {
			e.printStackTrace();
			throw new LoginException(e.toString());
		}
		

	}

	protected abstract void initLoginModule();
	
	protected abstract Validator initValidator() ;
	
	protected abstract void buildCallBacks();

	protected abstract void onlogout();

	protected abstract UserCredentials prepareUserCredentials() throws LoginException;

	protected abstract AbstractUser getUser(UserCredentials userData);

	protected abstract AbstractGroup getUserGroup(UserCredentials userData);
	
	

	private void loadCredentialsValidator(String validatorClass) {

		try {
			this.validator = (Validator) Thread.currentThread()
					.getContextClassLoader().loadClass(validatorClass)
					.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void buildPrincipals(UserCredentials userCredentials) {
		this.principals =new Vector();
		AbstractUser user = this.getUser(userCredentials);
		AbstractGroup userGroup =  this.getUserGroup(userCredentials);
		this.principals.add(user);
		this.principals.add(userGroup);
		System.out.println("User "+user.getName()+" Logged in");

	}

}
