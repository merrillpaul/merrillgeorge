/**
 * @(#) AbstractGroup.java 1.0 Apr 11, 2007
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
package com.merrill.examples.framework.security.user;

import com.merrill.examples.framework.security.auth.BasePrincipal;

/**
 * AbstractGroup - Description
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

public abstract class AbstractGroup implements BasePrincipal {

	private static final String TYPE_NAME="group.principal";
	private static final String GRP_NAME="application.group";

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.BasePrincipal#getPrincipalTypeName()
	 */
	public String getPrincipalTypeName() {
		// TODO Auto-generated method stub
		return TYPE_NAME;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.BasePrincipal#getUserCode()
	 */
	public String getUserCode() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.BasePrincipal#getName()
	 */
	public String getName() {
		
		return GRP_NAME;
	}

	
	
	

}
