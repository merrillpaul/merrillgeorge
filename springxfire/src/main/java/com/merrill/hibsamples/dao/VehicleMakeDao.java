/**
 * 
 */
package com.merrill.hibsamples.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;

import com.merrill.hibsamples.domain.VehicleMake;

/**
 * @author merrill.paul
 *
 */
public interface VehicleMakeDao extends GenericDao<VehicleMake,Long> {
	
	List<VehicleMake> findByVehicleName(String vehicleName);
}
