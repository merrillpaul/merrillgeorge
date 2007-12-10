/**
 * @(#) IPortMastersController.java 1.0 Mar 20, 2007
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
package com.merrill.examples.business.iport.masters.controller;

import java.util.Collection;

import com.merrill.examples.vo.iport.masters.PortVO;
import com.merrill.examples.vo.iport.masters.VesselTypeVO;

/**
 * IPortMastersController - Description
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

public interface IPortMastersController {
	void saveVesselType(VesselTypeVO vesselType);

	VesselTypeVO findVesselType(String vesselType);

	Collection<VesselTypeVO> getAllVesselTypes();

	void savePort(PortVO portVO);

	Collection<PortVO> getCompanyPorts();

	PortVO findPort(String portCode);

	Collection<PortVO> getPorts(String countryCode);
	
	Collection<PortVO> getPortsForNameMatch(String nameMatch);
	
	
}
