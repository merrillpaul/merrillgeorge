/**
 * @(#) VesselTypeHelperController.java 1.0 May 10, 2007
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
package com.merrill.examples.client.controller.iport.masters;

/**
 * VesselTypeHelperController - Description
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
 * 1.0				May 10, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class VesselTypeHelperController {
	private String[] vesselTypeDescription;
	private String[] enteredBy;
	private String[] operationFlag;
	/**
	 * @return the enteredBy
	 */
	public String[] getEnteredBy() {
		return enteredBy;
	}
	/**
	 * @param enteredBy the enteredBy to set
	 */
	public void setEnteredBy(String[] enteredBy) {
		this.enteredBy = enteredBy;
	}
	/**
	 * @return the operationFlag
	 */
	public String[] getOperationFlag() {
		return operationFlag;
	}
	/**
	 * @param operationFlag the operationFlag to set
	 */
	public void setOperationFlag(String[] operationFlag) {
		this.operationFlag = operationFlag;
	}
	/**
	 * @return the vesselTypeDescription
	 */
	public String[] getVesselTypeDescription() {
		return vesselTypeDescription;
	}
	/**
	 * @param vesselTypeDescription the vesselTypeDescription to set
	 */
	public void setVesselTypeDescription(String[] vesselTypeDescription) {
		this.vesselTypeDescription = vesselTypeDescription;
	}
	
	public String saveMe(){
		System.out.println("-------- Vessel Descriptions ----");
		for(String str:this.getVesselTypeDescription()){
			System.out.println(str);
		}
		System.out.println("-------- Entered By ----");
		for(String str:this.getEnteredBy()){
			System.out.println(str);
		}
		System.out.println("-------- Operation flag ----");
		for(String str:this.getOperationFlag()){
			System.out.println(str);
		}
		
		return "success";
	}

}
