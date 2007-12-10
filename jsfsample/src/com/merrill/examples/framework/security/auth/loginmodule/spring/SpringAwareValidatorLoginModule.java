/**
 * @(#) SpringAwareValidatorLoginModule.java 1.0 Apr 13, 2007
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
package com.merrill.examples.framework.security.auth.loginmodule.spring;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.merrill.examples.framework.security.auth.provider.db.ConnectionProvider;
import com.merrill.examples.framework.security.auth.provider.db.impl.JNDIDBConnectionProvider;
import com.merrill.examples.framework.security.auth.validator.DefaultValidator;
import com.merrill.examples.framework.security.auth.validator.Validator;
import com.merrill.examples.framework.security.token.service.TokenService;

/**
 * SpringAwareValidatorLoginModule - Description
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

public abstract class SpringAwareValidatorLoginModule extends
		AbstractSpringAwareLoginModule {
	//the value of this from jaas.config option
	private static final String VALIDATOR_BEAN_NAME="validatorBeanName";

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.loginmodule.AbstractLoginModule#initValidator()
	 */
	@Override
	protected Validator initValidator() {
		/*String validatorBean = 
			(String)this.options.get(VALIDATOR_BEAN_NAME);
		Validator validator = 
			(Validator)this.springContext.getBean(validatorBean);
		*/
		
		// right now manually preparing the beans
		JNDIDBConnectionProvider connectionProvider =
			new JNDIDBConnectionProvider();
		connectionProvider.setJndiName("java:comp/env/jdbc/jpasample");
		
		
		/*RmiProxyFactoryBean rmiProxyBean = new RmiProxyFactoryBean();
		rmiProxyBean.setServiceUrl("rmi://localhost:1199/TokenService");
		rmiProxyBean.setServiceInterface(TokenService.class);
		rmiProxyBean.afterPropertiesSet();*/
		
		
		DefaultValidator validator = new DefaultValidator();
		validator.setConnectionProvider(connectionProvider);
		//validator.setTokenService((TokenService)rmiProxyBean.getObject());
		validator.setUserTableName("PRT_AUT_USR_MST");
		validator.setUserNameColumn("USR_CODE");
		validator.setUserPasswordColumn("USR_PASSWD");
		return validator;
	}
	
	
}
