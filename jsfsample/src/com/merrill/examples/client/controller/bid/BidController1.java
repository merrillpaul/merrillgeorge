package com.merrill.examples.client.controller.bid;

import java.util.ArrayList;
import java.util.Collection;

import com.merrill.examples.client.ui.form.bid.BidForm1;

public class BidController1 {
	private BidForm1 form;
	private Collection<String> errorMessages=new ArrayList<String>();


	public BidForm1 getForm() {
		return form;
	}

	public void setForm(BidForm1 form) {
		this.form = form;
	}
	
public String doBid(){
		
		
		
		/*if(form.getBidAmount()<=0.10){
			addToErrors("Bid Amoutn must be atleast $0.10");
		}
		
		if(form.getBidDuration()<15){
			addToErrors("Bid duration must be at least 15 days");
		}
		
		if(!this.errorMessages.isEmpty()){
			return null;
		}
		else*/
			return "success";
	}
	
	/*private void addToErrors(String errorMessage){
		if(this.errorMessages==null)
			this.errorMessages = new ArrayList<String>();
		
		this.errorMessages.add(errorMessage);
	}*/

	public String getErrorMessages() {
		String message="";
		if(this.errorMessages.isEmpty())
			message="";
		else{
			message="<div style=\"color:red;font-weight:bold;font-size:10\"><ul>";
			for(String msg : this.errorMessages){
				message+="<li>";
				message+=msg;
				message+="</li>";
			}
			message+="</div>";
		}
		return message;
	}
	
}
