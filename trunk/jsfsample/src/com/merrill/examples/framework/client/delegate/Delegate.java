/**
 * @(#) Delegate.java 1.0 Mar 20, 2007
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
package com.merrill.examples.framework.client.delegate;

import java.util.Map;

import com.merrill.examples.framework.business.BI;


/**
 * Delegate - Description
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
 * 1.0				Mar 20, 2007				a-1346			First draft
 * 
 * </pre>
 */

public interface Delegate {
	
	
	<T extends Object> T despatchRequest(String action, Object...objects ) throws DelegateException;
	
	<T extends Object> T despatchRequest(String action) throws DelegateException;
	
	void setModule(String module);
	
	void setSubModule(String subModule);
	
	
	
	//TODO implmentation
}
