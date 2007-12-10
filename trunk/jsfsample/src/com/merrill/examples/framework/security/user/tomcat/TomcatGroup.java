/**
 * @(#) TomcatGroup.java 1.0 Apr 13, 2007
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
package com.merrill.examples.framework.security.user.tomcat;

import com.merrill.examples.framework.security.user.AbstractGroup;

/**
 * TomcatGroup - Description
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

public class TomcatGroup extends AbstractGroup {

	private String groupCode;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5815573301096272316L;

	public TomcatGroup(String groupCode) {
		
		this.groupCode = groupCode;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.BasePrincipal#getGroupCode()
	 */
	public String getGroupCode() {
		// TODO Auto-generated method stub
		return this.groupCode;
	}

}
