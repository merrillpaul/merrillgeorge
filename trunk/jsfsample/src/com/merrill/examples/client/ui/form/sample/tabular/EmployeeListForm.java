/**
 * @(#) EmployeeListForm.java 1.0 May 11, 2007
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
package com.merrill.examples.client.ui.form.sample.tabular;

/**
 * EmployeeListForm - Description
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

public class EmployeeListForm {
	private String[] employeeId;
	private String[] employeeName;
	private String[] employeeDepartment;
	/**
	 * @return the employeeDepartment
	 */
	public String[] getEmployeeDepartment() {
		return employeeDepartment;
	}
	/**
	 * @param employeeDepartment the employeeDepartment to set
	 */
	public void setEmployeeDepartment(String[] employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	/**
	 * @return the employeeId
	 */
	public String[] getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String[] employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the employeeName
	 */
	public String[] getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String[] employeeName) {
		this.employeeName = employeeName;
	}
	
	
}
