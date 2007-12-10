package com.merrill.examples.business.iport.masters;

import java.util.Collection;

import com.merrill.examples.framework.business.BI;
import com.merrill.examples.vo.iport.masters.PortVO;
import com.merrill.examples.vo.iport.masters.VesselTypeVO;

public interface IPortMastersBI extends BI {
	
	void saveVesselType(VesselTypeVO vesselType);
	
	VesselTypeVO findVesselType(String vesselType);
	
	Collection<VesselTypeVO> getAllVesselTypes();
	
	void savePort(PortVO portVO);
	
	Collection<PortVO> getCompanyPorts();
	
	PortVO findPort(String portCode);
	
	Collection<PortVO> getPorts(String countryCode);
	
	Collection<PortVO> getPortsStartingWithName(String portNameMatch);
	
}
