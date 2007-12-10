package com.merrill.examples.client.ui.form.bid;



public class BidForm {
	private String userId;
	private String bidAmount;
	private String keyWord;
	private String bidDuration;
	
	private int numericBidDuration;
	private double numericBidAmount;
	
	
	
	public double getNumericBidAmount() {
		return numericBidAmount;
	}
	public int getNumericBidDuration() {
		return numericBidDuration;
	}
	public String getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(String bidAmount) {
		this.bidAmount = bidAmount;
		
		try {
			this.numericBidAmount = new Double(this.bidAmount);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
	}
	public String getBidDuration() {
		return bidDuration;
	}
	public void setBidDuration(String bidDuration) {
		this.bidDuration = bidDuration;
		
		try {
			this.numericBidDuration = new Integer(this.bidDuration);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
