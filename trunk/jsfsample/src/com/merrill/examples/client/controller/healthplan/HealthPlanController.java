/**
 * @(#) HealthPlanController.java 1.0 Mar 13, 2007
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
package com.merrill.examples.client.controller.healthplan;

import com.merrill.examples.client.ui.form.healthplan.HealthPlanRegistrationForm;

/**
 * iCargo HealthPlanController - Description 
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
public class HealthPlanController {
	
	private HealthPlanRegistrationForm healthPlanRegistrationForm;
	
	
	public HealthPlanRegistrationForm getHealthPlanRegistrationForm() {
		return healthPlanRegistrationForm;
	}
	


	public void setHealthPlanRegistrationForm(
			HealthPlanRegistrationForm healthPlanRegistrationForm) {
		this.healthPlanRegistrationForm = healthPlanRegistrationForm;
	}
	


	public String registerHealthPlan(){
		
		if( healthPlanRegistrationForm.getSecondName()== null ||
				healthPlanRegistrationForm.getSecondName().trim().length()<1	
			){
			healthPlanRegistrationForm.setSecondName("Please enter Second Name");
		}
		
		if( healthPlanRegistrationForm.getFirstName()== null ||
			healthPlanRegistrationForm.getFirstName().trim().length()<1	
		)
			return "bad-firstname";
		else if(healthPlanRegistrationForm.getAnnualSalary()==null || healthPlanRegistrationForm.getAnnualSalary()==0)
			return "bad_annual_salary";
		else if(healthPlanRegistrationForm.getAnnualSalary()<5000)
			return "rejected";
		else
			return "accepted";
	}
}
