/**
 * @(#) IPortMastersServicesImpl.java 1.0 Mar 20, 2007
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
package com.merrill.examples.services.iport.masters.impl;

import java.util.Collection;

import com.merrill.examples.business.iport.masters.IPortMastersBI;
import com.merrill.examples.business.iport.masters.controller.IPortMastersController;
import com.merrill.examples.vo.iport.masters.PortVO;
import com.merrill.examples.vo.iport.masters.VesselTypeVO;

/**
 * IPortMastersServicesImpl - Description
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

public class IPortMastersServicesImpl implements IPortMastersBI {

	private IPortMastersController controller;
	public void setController(IPortMastersController controller) {
		this.controller = controller;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.business.iport.masters.IPortMastersBI#findVesselType(java.lang.String)
	 */
	public VesselTypeVO findVesselType(String vesselType) {
		
		return controller.findVesselType(vesselType);
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.business.iport.masters.IPortMastersBI#getAllVesselTypes()
	 */
	public Collection<VesselTypeVO> getAllVesselTypes() {
		return controller.getAllVesselTypes();
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.business.iport.masters.IPortMastersBI#saveVesselType(com.merrill.examples.vo.iport.masters.VesselTypeVO)
	 */
	public void saveVesselType(VesselTypeVO vesselType) {
		controller.saveVesselType(vesselType);

	}

	public PortVO findPort(String portCode) {
		
		return controller.findPort(portCode);
	}

	public Collection<PortVO> getCompanyPorts() {
		return controller.getCompanyPorts();
	}

	public Collection<PortVO> getPorts(String countryCode) {
		return controller.getPorts(countryCode);
	}

	public void savePort(PortVO portVO) {
		controller.savePort(portVO);
		
	}

	public Collection<PortVO> getPortsStartingWithName(String portNameMatch) {
		return controller.getPortsForNameMatch(portNameMatch);
	}

}
