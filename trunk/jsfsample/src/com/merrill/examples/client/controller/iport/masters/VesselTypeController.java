/**
 * @(#) VesselTypeController.java 1.0 Mar 20, 2007
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
package com.merrill.examples.client.controller.iport.masters;

import java.util.Collection;

import com.merrill.examples.framework.client.delegate.Delegate;
import com.merrill.examples.framework.client.delegate.DelegateException;
import com.merrill.examples.vo.iport.masters.VesselTypeVO;

/**
 * VesselTypeController - Description
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

public class VesselTypeController {
	
	
	private Delegate mastersDelegate;
	
	

	public void setMastersDelegate(Delegate mastersDelegate) {
		this.mastersDelegate = mastersDelegate;
	}
	
	public Collection<VesselTypeVO> getVesselTypes() {
		
		Collection<VesselTypeVO> result=null;
		try {
			result =  mastersDelegate.despatchRequest("getAllVesselTypes");
		} catch (DelegateException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	public Collection<VesselTypeVO> getVesselTypes(String tmp) {
		System.out.println("<VESSEL TYPE UI CONTROLLER><ACTION>getVesselTypes</ACTION><PARAM>"+tmp+"</PARAM></VESSEL TYPE UI CONTROLLER>");
		Collection<VesselTypeVO> result=null;
		try {
			result =  mastersDelegate.despatchRequest("getAllVesselTypes");
		} catch (DelegateException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
}
