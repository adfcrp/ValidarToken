package com.example.springbootdocker.Models;

public class BodyResponse {
	
	Boolean ok;
	String message;
	String error;
	
	public BodyResponse(Boolean ok, String message, String error) {
		super();
		this.ok = ok;
		this.message = message;
		this.error = error;
	}

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public BodyResponse(Exception e) {
		super();
		this.ok = false;
		this.message = e.getMessage();
		this.error = e.toString();
	}
	
	public BodyResponse() {
		super();
	}

	@Override
	public String toString() {
		return "BodyResponse [ok=" + ok + ", message=" + message + ", error=" + error + "]";
	}

}
