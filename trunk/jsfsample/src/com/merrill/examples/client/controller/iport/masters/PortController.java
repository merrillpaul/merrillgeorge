/**
 * @(#) PortController.java 1.0 Mar 26, 2007
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
import com.merrill.examples.vo.iport.masters.PortVO;

/**
 * PortController - Description
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
 * 1.0				Mar 26, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class PortController {
	private Delegate mastersDelegate;

	public void setMastersDelegate(Delegate mastersDelegate) {
		this.mastersDelegate = mastersDelegate;
	}
	
	public Collection<PortVO> getPorts(){
		Collection<PortVO> result = null;
		
		try {
			result = mastersDelegate.despatchRequest("getCompanyPorts");
			
		} catch (DelegateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Collection<PortVO> getPortsForName(String portNameMatch){
		Collection<PortVO> result = null;
		
		try {
			result = mastersDelegate.despatchRequest("getPortsStartingWithName",portNameMatch);
			
		} catch (DelegateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public PortVO getPort(String portCode){
		PortVO port = null;
		try {
			port = mastersDelegate.despatchRequest("findPort",portCode);
		} catch (DelegateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return port;
	}
	
	
	public void savePort(PortVO port){
		try {
			mastersDelegate.despatchRequest("savePort", port);
		} catch (DelegateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
