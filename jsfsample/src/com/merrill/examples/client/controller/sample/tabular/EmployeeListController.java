/**
 * @(#) EmployeeListController.java 1.0 May 11, 2007
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
package com.merrill.examples.client.controller.sample.tabular;

import java.util.ArrayList;
import java.util.Collection;

import com.merrill.examples.vo.sample.tabular.EmployeeVO;

/**
 * EmployeeListController - Description
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
 * 1.0				May 11, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class EmployeeListController {
	
	
	private EmployeeVO employee;
	
	
	
	

	/**
	 * @return the employee
	 */
	public EmployeeVO getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(EmployeeVO employee) {
		this.employee = employee;
	}

	public EmployeeListController() {
	
	}

	public EmployeeListController(String employeeId, String employeeName, String employeeDepartment) {
		setEmployee(new EmployeeVO(employeeId,employeeName,employeeDepartment));
	}

	public Collection<EmployeeListController> getEmployees(){
		Collection<EmployeeListController> list  = new ArrayList<EmployeeListController>();
		
		list.add(new EmployeeListController("A-1346","Merrill","iCargo"));
		list.add(new EmployeeListController("A-1349","George","iPort"));
		list.add(new EmployeeListController("A-1355","Paul","PU2"));
		list.add(new EmployeeListController("A-1354","Ananth","EK"));
		list.add(new EmployeeListController("A-1343","Arun","iFly"));
		list.add(new EmployeeListController("A-1362","Thomas","Umbrella"));
		list.add(new EmployeeListController("A-1389","Sharat","CTS"));
		list.add(new EmployeeListController("A-1322","Abhilash","iRes"));
		
		return list;
	}
	
	public String saveEmployeeList(){
		
		System.out.println("Employee Info Entered");
		/*for(int i=0;i<this.getEmployeeId().length;i++){
			
			System.out.println("<Employee Id>"+this.getEmployeeId()[i]+
								"</Employee Id>"
								+" <Employee Name>"
								+this.getEmployeeName()[i]
								+"</Employee Name>"
								+" <Employee Dept>"
								+this.getEmployeeDepartment()[i]
								+"</Employee Dept>"                                       			
								);
		}*/
		
		return "success";
	}

	
	
	
}
