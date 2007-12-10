/**
 * @(#) SpringAwareLoginModule.java 1.0 Apr 13, 2007
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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.merrill.examples.framework.security.auth.loginmodule.AbstractLoginModule;

/**
 * SpringAwareLoginModule - Description
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

public abstract class AbstractSpringAwareLoginModule extends AbstractLoginModule {
	// both these 2 from jaas.config option
	private static final String SPRING_CONFIG_XML_KEY="springConfigXml";
	// whether classpath or file based spring container
	private static final String SPRING_RESOURCE_TYPE="springResourceType";
	
	
	
	protected ApplicationContext springContext;

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.loginmodule.AbstractLoginModule#initLoginModule()
	 */
	@Override
	protected final void initLoginModule() {
		
		// commented this util the classloading of spring IOC 
		// for loginmodule in tomcat is solved.
		/*String springxmlLocation = (String)this.options.get(SPRING_CONFIG_XML_KEY);
		String springResourceType = (String)this.options.get(SPRING_RESOURCE_TYPE);
		
		if(springResourceType.equalsIgnoreCase("classpath")){
			this.springContext = new ClassPathXmlApplicationContext(
					springxmlLocation);
		}else if(springResourceType.equalsIgnoreCase("file")){
			this.springContext = new FileSystemXmlApplicationContext(
					springxmlLocation
					);
		}
		else
			throw new RuntimeException("no resource types found");
		*/
		
		
		
	}
	
	
		
	
}
