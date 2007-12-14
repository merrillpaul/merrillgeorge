/**
 * 
 */
package com.merrill.hibsamples.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.appfuse.dao.BaseDaoTestCase;

import com.merrill.hibsamples.domain.VehicleMake;

/**
 * @author merrill.paul
 *
 */
public class VehicleMakeDaoTest extends BaseDaoTestCase {
	private VehicleMakeDao vehicleMakeDao;

	public void setVehicleMakeDao(VehicleMakeDao vehicleMakeDao) {
		this.vehicleMakeDao = vehicleMakeDao;
	}
	
	public void testAddVehicleMakeDao() throws Exception{
		VehicleMake vm =  new VehicleMake();
		vm.setMakeName("Skoda");
		vm.setModel("Octavia TDI Rider");
		vm.setMakeNo("octy_tdi");
		
		vm = vehicleMakeDao.save(vm);
		
		assertEquals("Skoda", vm.getMakeName());
		assertNotNull(vm.getId());
	}
	
	public void testAddDuplicateMakeNoForVehicleMake(){
		VehicleMake vm =  new VehicleMake();
		vm.setMakeName("Skoda");
		vm.setModel("Octavia TDI Rider");
		vm.setMakeNo("octy_tdi");
		
		vm = vehicleMakeDao.save(vm);
		
		assertEquals("Skoda", vm.getMakeName());
		log.debug(vm.getId());
		assertNotNull(vm.getId());
		
		VehicleMake vm1 =  new VehicleMake();
		vm1.setMakeName("Skoda");
		vm1.setModel("Superb");
		vm1.setMakeNo("octy_tdi");
		Exception e =  null;
		try{
		vm1 = vehicleMakeDao.save(vm1);
		}catch(EntityExistsException eee){
			e = eee;
		}
		assertNull(vm1.getId());
		assertNotNull(e);
		
		
		
	}
	
	
	
	public void testQueryMakesByVehicleName(){
		VehicleMake vm =  new VehicleMake();
		vm.setMakeName("SKODA");
		vm.setModel("Octavia TDI Rider");
		vm.setMakeNo("octy_tdi");
		
		vm = vehicleMakeDao.save(vm);
		assertNotNull(vm.getId());
		
		
		vm =  new VehicleMake();
		vm.setMakeName("VolksWagen");
		vm.setModel("Jetta");
		vm.setMakeNo("vw_jetta");
		
		vm = vehicleMakeDao.save(vm);
		assertNotNull(vm.getId());
		
		vm =  new VehicleMake();
		vm.setMakeName("Skoda");
		vm.setModel("Octavia RS");
		vm.setMakeNo("octy_rs");
		
		vm = vehicleMakeDao.save(vm);
		assertNotNull(vm.getId());
		
		vm =  new VehicleMake();
		vm.setMakeName("Maruti");
		vm.setModel("SX4");
		vm.setMakeNo("mulsx4");
		
		
		vm = vehicleMakeDao.save(vm);
		assertNotNull(vm.getId());
		
		vm =  new VehicleMake();
		vm.setMakeName("Skoda");
		vm.setModel("Laura");
		vm.setMakeNo("octy_laura");
		
		vm = vehicleMakeDao.save(vm);
		assertNotNull(vm.getId());
		
		vm =  new VehicleMake();
		vm.setMakeName("Skoda");
		vm.setModel("Roomster");
		vm.setMakeNo("octy_rm");
		
		vm = vehicleMakeDao.save(vm);
		assertNotNull(vm.getId());
		
		vm =  new VehicleMake();
		vm.setMakeName("VolksWagen");
		vm.setModel("Tuareg");
		vm.setMakeNo("vw_tg");
		
		vm = vehicleMakeDao.save(vm);
		assertNotNull(vm.getId());
		
		
		List<VehicleMake> makes = vehicleMakeDao.findByVehicleName("skoda");
		assertNotNull(makes);
		assertEquals(4, makes.size());
		
	}
	
	
	public void testAddThenDeleteThenFind(){
		VehicleMake vm =  new VehicleMake();
		vm.setMakeName("SKODA");
		vm.setModel("Octavia TDI Rider");
		vm.setMakeNo("octy_tdi");
		
		vm = vehicleMakeDao.save(vm);
		
		assertNotNull(vm.getId());
		//log.debug(vm.getId());
		
		//log.debug("************* finding vm ********************");
		
		vm = vehicleMakeDao.get(vm.getId());
		assertEquals("SKODA", vm.getMakeName());
		
		log.debug("************* deleting vm ********************");
		vehicleMakeDao.remove(vm.getId());
		log.debug(vm.getId());
		
		log.debug("************* finding vm ********************");
		
		try {
			vm = vehicleMakeDao.get(vm.getId());
			fail("deleted make found !");
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			log.debug("exception",e);
			assertNotNull(e);
		}
		
		
		
		
		
	}
	
}
