/**
 * @(#) IPortMastersServiceRemoteTest.java 1.0 Mar 29, 2007
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
package test.com.merrill.examples.spring.remoting;


import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.merrill.examples.client.controller.iport.masters.PortController;
import com.merrill.examples.vo.iport.masters.PortVO;

/**
 * IPortMastersServiceRemoteTest - Description
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
 * 1.0				Mar 29, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class IPortMastersServiceRemoteTest {
	private PortController portController;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		portController = 
			(PortController)ctx.getBean("iportMastersPortUIController");
		
	}
	
	@Test
	public void getPorts(){
		Collection<PortVO> ports = portController.getPorts();
		int portSize = ports.size();
		System.out.println(ports);
		assertTrue(portSize > 0);
	}
	
	

}
