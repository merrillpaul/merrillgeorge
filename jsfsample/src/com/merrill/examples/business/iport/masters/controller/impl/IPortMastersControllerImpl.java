/**
 * @(#) IPortMastersControllerImpl.java 1.0 Mar 20, 2007
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
package com.merrill.examples.business.iport.masters.controller.impl;

import java.util.Collection;

import com.merrill.examples.business.iport.masters.controller.IPortMastersController;
import com.merrill.examples.dao.iport.masters.IPortMastersDAO;
import com.merrill.examples.vo.iport.masters.PortVO;
import com.merrill.examples.vo.iport.masters.VesselTypeVO;

/**
 * IPortMastersControllerImpl - Description
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

public class IPortMastersControllerImpl implements IPortMastersController {

	private IPortMastersDAO dao;
	
	
	public void setDao(IPortMastersDAO dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.business.iport.masters.controller.IPortMastersController#findVesselType(java.lang.String)
	 */
	public VesselTypeVO findVesselType(String vesselType) {
		return dao.getVesselType(vesselType);
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.business.iport.masters.controller.IPortMastersController#getAllVesselTypes()
	 */
	public Collection<VesselTypeVO> getAllVesselTypes() {
		return dao.getAllVesselTypes();
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.business.iport.masters.controller.IPortMastersController#saveVesselType(com.merrill.examples.vo.iport.masters.VesselTypeVO)
	 */
	public void saveVesselType(VesselTypeVO vesselType) {
		
		switch(vesselType.getOperationFlag()){
		case INSERT : dao.createVesselType(vesselType);break;
		case DELETE : dao.removeVesselType(vesselType);break;
		case UPDATE : dao.updateVesselType(vesselType);break;
		}

	}

	public PortVO findPort(String portCode) {
		return dao.getPort(portCode);
	}

	public Collection<PortVO> getCompanyPorts() {
		return dao.getCompanyPorts();
	}

	public Collection<PortVO> getPorts(String countryCode) {
		return (countryCode==null)?dao.getAllPorts(): dao.getPortsForCountry(countryCode);
	}

	public void savePort(PortVO portVO) {
		switch(portVO.getOperationFlag()){
		case INSERT : dao.createPort(portVO);break;
		case UPDATE : dao.updatePort(portVO);break;
		case DELETE : dao.removePort(portVO);break;
		}
		
	}

	public Collection<PortVO> getPortsForNameMatch(String nameMatch) {
		return dao.getPortsForNameMatch(nameMatch);
	}

}
