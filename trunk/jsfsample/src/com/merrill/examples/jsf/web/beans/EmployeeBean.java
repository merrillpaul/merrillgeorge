/**
 * @(#) EmployeeBean.java 1.0 Mar 13, 2007
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
package com.merrill.examples.jsf.web.beans;

/**
 * iCargo EmployeeBean - Description 
 * 
 * @author A-1346
 *
 */

/**
 * <pre>
 * 
 * Revision History
 * Revision 		Date      			Author			Description
 * 1.0			Mar 13, 2007					A-1346			First draft
 * 
 * </pre>
 */
public class EmployeeBean {
	private NameBean name;
	private CompanyBean company;
	private Double salary;
	public EmployeeBean(NameBean name, CompanyBean company,Double salary) {
		
		this.name = name;
		
		
		this.company = company;
		this.salary = salary;
	}
	public EmployeeBean() {
		this(
				new NameBean("Merrill", "George"),
				new CompanyBean("IBS","Airline Solutions"),
				12000.00
			);
	}
	public CompanyBean getCompany() {
		return company;
	}
	
	public void setCompany(CompanyBean company) {
		this.company = company;
	}
	
	public NameBean getName() {
		return name;
	}
	
	public void setName(NameBean name) {
		this.name = name;
	}
	
	
	public String processEmployee(){
		
		if(this.company.getCompanyName()!=null && this.company.getCompanyName().equalsIgnoreCase("INFY"))
			return "goback";
		
		if(this.salary>5000)
			return "accept";
		else
			return "reject";
	}
	public Double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	
	
	
	
}
