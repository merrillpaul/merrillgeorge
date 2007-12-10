/**
 * @(#) ResumeBean.java 1.0 Mar 14, 2007
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

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 * iCargo ResumeBean - Description 
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
public class ResumeBean {
	private String fgColor="BLACK";
	private String bgColor="WHITE";
	
	private String name="";
	private String jobTitle="";
	
	private boolean isUsingColorNames=true;
	
	private SelectItem[] availableColorsNames= {
			new SelectItem("BLACK"),
			new SelectItem("WHITE"),
			new SelectItem("BLUE"),
			new SelectItem("RED"),
			new SelectItem("GREEN"),
			new SelectItem("INDIGO"),
			new SelectItem("VIOLET"),
			new SelectItem("YELLOW")
	};
	
	private SelectItem[] availablColorsInRGB={
			new SelectItem("#000000"),
			new SelectItem("#ffffff"),
			new SelectItem("#dedede"),
			new SelectItem("#c6cede"),
			new SelectItem("#bebebe"),
			new SelectItem("#cccccc"),
			new SelectItem("#c4ced9"),
			new SelectItem("#638DBD")
	};
	
	private boolean isColorSupported;
	
	public boolean getColorSupported() {
		return isColorSupported;
	}
	

	
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public SelectItem[] getAvailableColors() {
		if(isUsingColorNames)
		return availableColorsNames;
		else
			return availablColorsInRGB;
	}
	
	
	public void toggleColorSupport(ActionEvent ae){
		isColorSupported = !isColorSupported;
	}
	
	public void changeColorModel(ValueChangeEvent vce){
		boolean flag = 
		((Boolean)vce.getNewValue()).booleanValue();
		
		setUsingColorNames(!flag);
	}
	
	public String showPreview(){
		
		if(isColorSupported && fgColor.equals(bgColor)){
			return "same-color";
		}
		else{
			return "success";
		}
	}
	
	
	 public String getColorSupportLabel() {
		    if (isColorSupported) {
		      return("Disable Color Customization");
		    } else {
		      return("Enable Colors Customization");
		    }
		  }




	public String getBgColor() {
		return bgColor;
	}
	




	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	




	public String getFgColor() {
		return fgColor;
	}
	




	public void setFgColor(String fgColor) {
		this.fgColor = fgColor;
	}




	public void setUsingColorNames(boolean isUsingColorNames) {
		this.isUsingColorNames = isUsingColorNames;
	}
	
	
	
	
}
