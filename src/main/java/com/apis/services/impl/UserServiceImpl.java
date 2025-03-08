package com.apis.services.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.apis.exceptions.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.apis.entites.User;
import com.apis.payloads.UserDto;
import com.apis.repositarys.userRepo;
import com.apis.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private userRepo UserRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto Creatuser(UserDto userDto) {
		User user= this.dtoToUser(userDto);
		User savedUser = this.UserRepo.save(user);
		return this.UserTodto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.UserRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User" ,"id" , userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User UpdatedUser = this.UserRepo.save(user);
		UserDto userDto1= this.UserTodto(UpdatedUser);
		
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.UserRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		return this.UserTodto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.UserRepo.findAll();
		
		List<UserDto> userDtos = users.stream().map(user->this.UserTodto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.UserRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		this.UserRepo.delete(user);
	}

	private User dtoToUser(UserDto userdto) {

		User user = this.modelMapper.map(userdto, User .class);
		
		
		
		
//		user.setId(userdto.getId());
//		user.setName(userdto.getName());
//		user.setEmail(userdto.getEmail());
//		user.setAbout(userdto.getAbout());
//		user.setPassword(userdto.getPassword());

		return user;

	}

	private UserDto UserTodto(User user) {

		UserDto userDto = this.modelMapper.map(user, UserDto.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
 
		return userDto;

	}

}
