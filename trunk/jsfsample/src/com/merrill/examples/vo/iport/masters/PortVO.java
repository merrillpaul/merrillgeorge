/**
 * @(#) PortVO.java 1.0 Mar 26, 2007
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
 * PortVO - Description
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
 * 1.0				Mar 26, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class PortVO extends AbstractVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7028827606988844839L;
	private String portCode;
	private String portName;
	private String portDesc;
	private String countryCode;
	private String enteredBy;
	
	private boolean shjPort;
	private int version;
	private OperationFlag operationFlag;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
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
	public String getPortCode() {
		return portCode;
	}
	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}
	public String getPortDesc() {
		return portDesc;
	}
	public void setPortDesc(String portDesc) {
		this.portDesc = portDesc;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public boolean isShjPort() {
		return shjPort;
	}
	public void setShjPort(boolean shjPort) {
		this.shjPort = shjPort;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
