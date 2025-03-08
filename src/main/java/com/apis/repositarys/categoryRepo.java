package com.apis.repositarys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apis.entites.Categary;

public interface categoryRepo extends JpaRepository<Categary, Integer>{

}
