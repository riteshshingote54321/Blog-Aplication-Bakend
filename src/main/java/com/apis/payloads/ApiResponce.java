package com.apis.payloads;

public class ApiResponce {
	
	private String Massage;
	private boolean Success;
	
	
	
	public String getMassage() {
		return Massage;
	}
	public void setMassage(String massage) {
		Massage = massage;
	}
	public boolean isSuccess() {
		return Success;
	}
	public void setSuccess(boolean success) {
		Success = success;
	}
	public ApiResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiResponce(String massage, boolean success) {
		super();
		Massage = massage;
		Success = success;
	}
	

}
