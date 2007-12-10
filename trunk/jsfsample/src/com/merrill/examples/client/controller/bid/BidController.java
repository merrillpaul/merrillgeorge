package com.merrill.examples.client.controller.bid;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.UniqueConstraint;

import com.merrill.examples.client.ui.form.bid.BidForm;

public class BidController {
	
	private BidForm form;
	private Collection<String> errorMessages=new ArrayList<String>();

	public BidForm getForm() {
		return form;
	}

	public void setForm(BidForm form) {
		this.form = form;
	}
	
	public String doBid(){
		
		if(form.getUserId().equals("")){
			addToErrors("UserID is required");
		}
		if(form.getKeyWord().equals("")){
			addToErrors("Keyword is mandatory");
		}
		
		if(form.getNumericBidAmount()<=0.10){
			addToErrors("Bid Amoutn must be atleast $0.10");
		}
		
		if(form.getNumericBidDuration()<15){
			addToErrors("Bid duration must be at least 15 days");
		}
		
		if(!this.errorMessages.isEmpty()){
			return null;
		}
		else
			return "success";
	}
	
	
	private void addToErrors(String errorMessage){
		if(this.errorMessages==null)
			this.errorMessages = new ArrayList<String>();
		
		this.errorMessages.add(errorMessage);
	}

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
