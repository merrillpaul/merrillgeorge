/**
 * @(#) PickColorBean.java 1.0 Mar 14, 2007
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
package com.merrill.examples.jsf.web.beans.eventexample;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * iCargo PickColorBean - Description 
 * 
 * @author A-1346
 *
 */

/**
 * <pre>
 * 
 * Revision History
 * Revision 		Date      			Author			Description
 * 1.0			Mar 14, 2007					A-1346			First draft
 * 
 * </pre>
 */
public class PickColorBean {
	private String bgColor ="WHITE";

	public String getBgColor() {
		return bgColor;
	}
	

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	
	
	public void pickColor(ActionEvent ae){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		String clientId = ae.getComponent().getClientId(facesContext);
		HttpServletRequest request = 
			(HttpServletRequest)facesContext.getExternalContext().getRequest();
		
		
		String grayLevel  = request.getParameter(clientId+".x");
		
		int grayL = 220;
		
		try {
			grayL = Integer.parseInt(grayLevel);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
		

		grayL = (256 * grayL) / 440;
		String rVal = Integer.toString(grayL, 16);
		setBgColor("#" + rVal + rVal + rVal);
	}
	
	
	public String updateView(){
		return "success";
	}
}
