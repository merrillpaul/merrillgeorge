/**
 * 
 */
package com.merrill.hibsamples.dao.impl.jpa;

import java.util.List;

import javax.persistence.Query;

import org.appfuse.dao.jpa.GenericDaoJpa;

import com.merrill.hibsamples.dao.VehicleMakeDao;
import com.merrill.hibsamples.domain.VehicleMake;

/**
 * @author merrill.paul
 *
 */
public class VehicleMakeJpaDao extends GenericDaoJpa<VehicleMake,Long> implements VehicleMakeDao {

	public VehicleMakeJpaDao() {
		super(VehicleMake.class);
		
	}

	/* (non-Javadoc)
	 * @see com.merrill.hibsamples.dao.VehicleMakeDao#findByVehicleName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<VehicleMake> findByVehicleName(String vehicleName) {
		Query q = super.entityManager.createQuery("select vm from VehicleMake vm where vm.makeName like :makename");
		q.setParameter("makename",vehicleName);
		return q.getResultList();
	}

	

}
