package com.apis.services;

import java.util.List;

import com.apis.payloads.UserDto;

public interface UserService {
	UserDto Creatuser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUser();

	void deleteUser(Integer userId);
}
