package com.unitedremote.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitedremote.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, String> 
{}
