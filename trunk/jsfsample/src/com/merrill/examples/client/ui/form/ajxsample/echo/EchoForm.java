package com.merrill.examples.client.ui.form.ajxsample.echo;

public class EchoForm {
	private String message;
	
	private String ajaxMessage;

	public String getAjaxMessage() {
		return ajaxMessage;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		this.ajaxMessage = this.message.toUpperCase()+"AJAX";
		
	}
}
