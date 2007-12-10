/**
 * @(#) TomcatUser.java 1.0 Apr 13, 2007
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

import com.merrill.examples.framework.security.user.AbstractUser;

/**
 * TomcatUser - Description
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

public class TomcatUser extends AbstractUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8490439536232987430L;
	private String userCode;
	private String sessionId;
	private String groupCode;
	

	public TomcatUser(String userCode, String sessionId, String groupCode) {
		this.userCode = userCode;
		this.sessionId = sessionId;
		this.groupCode =  groupCode;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.user.AbstractUser#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.sessionId = name;

	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.BasePrincipal#getGroupCode()
	 */
	public String getGroupCode() {
		return this.groupCode;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.BasePrincipal#getName()
	 */
	public String getName() {
		return this.sessionId;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.BasePrincipal#getUserCode()
	 */
	public String getUserCode() {
		return this.userCode;
	}

}
