package com.apis.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//This Class Use For Tranfer the data




public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4 , message = "Name Must be min of 4 charecter")
	private String name;
	@Email(message = "Enter Valid Email")
	private String email;
	@NotEmpty
	@Size(min = 3 , max = 8 , message = "please Enter Password 8 digit !!")
	private String password;
	@NotEmpty
	private String about;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", about="
				+ about + "]";
	}
	
	
	
	

}
