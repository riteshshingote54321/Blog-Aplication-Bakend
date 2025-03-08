package com.apis.repositarys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apis.entites.Comment;

public interface commentRepo extends JpaRepository<Comment, Integer> {

}
