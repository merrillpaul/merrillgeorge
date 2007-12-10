/**
 * @(#) EmployeeVO.java 1.0 May 11, 2007
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
package com.merrill.examples.vo.sample.tabular;

import com.merrill.examples.framework.vo.AbstractVO;

/**
 * EmployeeVO - Description
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

public class EmployeeVO extends AbstractVO {

	public EmployeeVO(String employeeId, String employeeName, String employeeDepartment) {
		
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
	}
	public EmployeeVO() {
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -4859903561346866152L;
	
	
	private String employeeId;
	private String employeeName;
	private String employeeDepartment;
	/**
	 * @return the employeeDepartment
	 */
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	/**
	 * @param employeeDepartment the employeeDepartment to set
	 */
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str ="<Employee Id>"+this.getEmployeeId()+
				"</Employee Id>"
				+" <Employee Name>"
				+this.getEmployeeName()
				+"</Employee Name>"
				+" <Employee Dept>"
				+this.getEmployeeDepartment()
				+"</Employee Dept>"                                       			
				;
		
		return str;
	}
	
	

}
