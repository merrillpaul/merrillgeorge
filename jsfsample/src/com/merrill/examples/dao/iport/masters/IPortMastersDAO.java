package com.merrill.examples.dao.iport.masters;

import java.util.Collection;

import com.merrill.examples.vo.iport.masters.PortVO;
import com.merrill.examples.vo.iport.masters.VesselTypeVO;

public interface IPortMastersDAO {
	Collection<VesselTypeVO> getAllVesselTypes();
	
	VesselTypeVO getVesselType(String vesselType);
	
	void createVesselType(VesselTypeVO vesselTypeVO);
	
	void removeVesselType(VesselTypeVO vesselTypeVO);
	
	void updateVesselType(VesselTypeVO vesselTypeVO);
	
	
	Collection<PortVO> getAllPorts();
	
	Collection<PortVO> getCompanyPorts();
	
	Collection<PortVO> getPortsForCountry(String countryCode);
	
	
	Collection<PortVO> getPortsForNameMatch(String portNameMatch);
	
	PortVO getPort(String portCode);
	
	void createPort(PortVO portVO);
	
	void updatePort(PortVO portVO);
	
	void removePort(PortVO portVO);
	
}
