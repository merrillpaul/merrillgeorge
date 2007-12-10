/**
 * @(#) TestBean.java 1.0 Mar 13, 2007
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
package com.merrill.examples.jsf.web.beans;

import java.util.Date;

/**
 * iCargo TestBean - Description 
 * 
 * @author A-1346
 *
 */

/**
 * <pre>
 * 
 * Revision History
 * Revision 		Date      			Author			Description
 * 1.0			Mar 13, 2007					A-1346			First draft
 * 
 * </pre>
 */
public class TestBean {
	private Date creationTime = new Date();
	private String greeting ="Hello";
	public Date getCreationTime() {
		return creationTime;
	}
	
	public String getGreeting() {
		return greeting;
	}
	
	
	public double getRandomNumber(){
		return Math.random();
	}
}
