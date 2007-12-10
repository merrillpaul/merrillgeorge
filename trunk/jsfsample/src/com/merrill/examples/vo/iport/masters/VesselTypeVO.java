/**
 * @(#) VesselTypeVO.java 1.0 Mar 20, 2007
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
package com.merrill.examples.vo.iport.masters;

import com.merrill.examples.framework.constants.OperationFlag;
import com.merrill.examples.framework.vo.AbstractVO;

/**
 * VesselTypeVO - Description
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
 * 1.0				Mar 20, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class VesselTypeVO extends AbstractVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4530470155124582828L;

	private String vesselType;
	
	private String vesselTypeDescription;
	
	private String enteredBy;
	
	private OperationFlag operationFlag;

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public OperationFlag getOperationFlag() {
		return operationFlag;
	}

	public void setOperationFlag(OperationFlag operationFlag) {
		this.operationFlag = operationFlag;
	}

	public String getVesselType() {
		return vesselType;
	}

	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}

	public String getVesselTypeDescription() {
		return vesselTypeDescription;
	}

	public void setVesselTypeDescription(String vesselTypeDescription) {
		this.vesselTypeDescription = vesselTypeDescription;
	} 

}
