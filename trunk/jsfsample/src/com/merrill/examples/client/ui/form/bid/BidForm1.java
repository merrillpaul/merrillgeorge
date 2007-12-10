package com.merrill.examples.client.ui.form.bid;

public class BidForm1 {
	private String userId;
	private Double bidAmount;
	private String keyWord;
	private Integer bidDuration;
	public Double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(Double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Integer getBidDuration() {
		return bidDuration;
	}
	public void setBidDuration(Integer bidDuration) {
		this.bidDuration = bidDuration;
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
