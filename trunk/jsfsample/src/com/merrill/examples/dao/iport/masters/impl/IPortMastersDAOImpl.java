/**
 * @(#) IPortMastersDAOImpl.java 1.0 Mar 20, 2007
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
package com.merrill.examples.dao.iport.masters.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.merrill.examples.business.iport.masters.domain.Port;
import com.merrill.examples.business.iport.masters.domain.VesselType;
import com.merrill.examples.dao.iport.masters.IPortMastersDAO;
import com.merrill.examples.vo.iport.masters.PortVO;
import com.merrill.examples.vo.iport.masters.VesselTypeVO;

/**
 * IPortMastersDAOImpl - Description
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

public class IPortMastersDAOImpl implements IPortMastersDAO {

	
	private EntityManager em;
	/* (non-Javadoc)
	 * @see com.merrill.examples.dao.iport.masters.IPortMastersDAO#createVesselType(com.merrill.examples.vo.iport.masters.VesselTypeVO)
	 */
	public void createVesselType(VesselTypeVO vesselTypeVO) {
		// TODO Auto-generated method stub
		VesselType vesselType = new VesselType();
		vesselType.setVesselType(vesselTypeVO.getVesselType());
		vesselType.setVesselTypeDesc(vesselTypeVO.getVesselTypeDescription());
		vesselType.setEnteredBy(vesselTypeVO.getEnteredBy());
		
		em.persist(vesselType);

	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.dao.iport.masters.IPortMastersDAO#getAllVesselTypes()
	 */
	public Collection<VesselTypeVO> getAllVesselTypes() {
		Query query = em.createNamedQuery("allVesselTypes");
		Collection<VesselType> list = query.getResultList();
		
		Collection<VesselTypeVO> result = new ArrayList<VesselTypeVO>();
		
		
		for(VesselType vesselType : list){
			
			result.add(toVO(vesselType));
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.dao.iport.masters.IPortMastersDAO#getVesselType(java.lang.String)
	 */
	public VesselTypeVO getVesselType(String vesselType) {
		VesselType tmpVesselType = em.find(VesselType.class, vesselType);
		return toVO(tmpVesselType);
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.dao.iport.masters.IPortMastersDAO#removeVesselType(com.merrill.examples.vo.iport.masters.VesselTypeVO)
	 */
	public void removeVesselType(VesselTypeVO vesselTypeVO) {
		VesselType tmpVesselType = em.find(
				VesselType.class, vesselTypeVO.getVesselType());
		
		em.remove(tmpVesselType);
		

	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.dao.iport.masters.IPortMastersDAO#updateVesselType(com.merrill.examples.vo.iport.masters.VesselTypeVO)
	 */
	public void updateVesselType(VesselTypeVO vesselTypeVO) {
		VesselType tmpVesselType = em.find(
				VesselType.class, vesselTypeVO.getVesselType());
		
		tmpVesselType.setVesselTypeDesc(vesselTypeVO.getVesselTypeDescription());
		tmpVesselType.setEnteredBy(vesselTypeVO.getEnteredBy());
		//em.persist(tmpVesselType);

	}
	
	private VesselTypeVO toVO(VesselType vesselType){
		VesselTypeVO vo = new VesselTypeVO();
		vo.setVesselType(vesselType.getVesselType());
		vo.setVesselTypeDescription(vesselType.getVesselTypeDesc());
		vo.setEnteredBy(vesselType.getEnteredBy());
		return vo;
	}
	
	private PortVO toVO(Port port){
		PortVO portVO = new PortVO();
		portVO.setPortCode(port.getPortCode());
		portVO.setPortName(port.getPortName());
		portVO.setPortDesc(port.getPortDesc());
		portVO.setCountryCode(port.getCountryCode());
		portVO.setShjPort( ( port.getSharjahPorts()!=null && port.getSharjahPorts().equals("Y") )?true:false );
		portVO.setVersion(port.getVersion());
		return portVO;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void createPort(PortVO portVO) {
		Port port = new Port();
		port.setPortCode(portVO.getPortCode());
		port.setPortName(portVO.getPortName());
		port.setPortDesc(portVO.getPortDesc());
		port.setEnteredBy(portVO.getEnteredBy());
		port.setCountryCode(portVO.getCountryCode());
		port.setSharjahPorts( (portVO.isShjPort())?"Y":"N" );
		em.persist(port);
		
	}

	public Collection<PortVO> getAllPorts() {
		Query query = em.createNamedQuery("allPorts");
		Collection<Port> list = query.getResultList();
		
		Collection<PortVO> result = new ArrayList<PortVO>();
		
		
		for(Port port: list){
			result.add(toVO(port));
		}
		
		return result;
	}

	public Collection<PortVO> getCompanyPorts() {
		Query query = em.createNamedQuery("companyPorts");
		Collection<Port> list = query.getResultList();
		
		Collection<PortVO> result = new ArrayList<PortVO>();
		
		
		for(Port port: list){
			result.add(toVO(port));
		}
		
		return result;
	}

	public PortVO getPort(String portCode) {
		Port port = em.find(Port.class, portCode);
		return toVO(port);
	}

	public Collection<PortVO> getPortsForCountry(String countryCode) {
		Query query = em.createNamedQuery("portsForCountry");
		query.setParameter("_countryCode", countryCode);
		Collection<Port> list = query.getResultList();
		
		Collection<PortVO> result = new ArrayList<PortVO>();
		
		
		for(Port port: list){
			result.add(toVO(port));
		}
		
		return result;
	}

	public void removePort(PortVO portVO) {
		Port port = em.find(Port.class, portVO.getPortCode());
		em.remove(port);
		
	}

	public void updatePort(PortVO portVO) {
		Port port = em.find(Port.class, portVO.getPortCode());
		port.setPortName(portVO.getPortName());
		port.setPortDesc(portVO.getPortDesc());
		port.setEnteredBy(portVO.getEnteredBy());
		port.setCountryCode(portVO.getCountryCode());
		port.setSharjahPorts( (portVO.isShjPort())?"Y":"N" );
		port.setVersion(portVO.getVersion());
		
	}

	public Collection<PortVO> getPortsForNameMatch(String portNameMatch) {
		
		Query query = em.createNamedQuery("portForNameMatch");
		query.setParameter("_likePortName", portNameMatch+"%");
		query.setParameter("_portName", portNameMatch);
		
		
		Collection<Port> list = query.getResultList();
		
		Collection<PortVO> result = new ArrayList<PortVO>();
		
		
		for(Port port: list){
			result.add(toVO(port));
		}
		
		return result;
	}

}
