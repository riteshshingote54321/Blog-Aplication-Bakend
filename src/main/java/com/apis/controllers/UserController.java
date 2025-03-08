package com.apis.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apis.payloads.ApiResponce;
import com.apis.payloads.UserDto;
import com.apis.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	//post - create user
	@PostMapping("/")
	public ResponseEntity<UserDto> creteUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createUserDto = this.userservice.Creatuser(userDto);
		return new ResponseEntity<>(createUserDto , HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateuser(@Valid @RequestBody UserDto userDto , @PathVariable("userId") Integer uId){
		UserDto updatedUser=this.userservice.updateUser(userDto, uId);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponce> deleteUser(@PathVariable("userId") Integer uId)
	{
		this.userservice.deleteUser(uId);
		//return new ResponseEntity(Map.of("Message" , "user deleted") , HttpStatus.OK);
		return new ResponseEntity<ApiResponce>(new ApiResponce("User Deleted Success" , true) , HttpStatus.OK);
	}
	
	
	//get All User
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return ResponseEntity.ok(this.userservice.getAllUser());
	}
	
	
	//get Siggle user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.userservice.getUserById(userId));
	}

}
