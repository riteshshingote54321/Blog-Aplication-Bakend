package com.apis.repositarys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apis.entites.User;

public interface userRepo extends JpaRepository<User, Integer>{

}
