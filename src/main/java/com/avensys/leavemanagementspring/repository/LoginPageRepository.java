package com.avensys.leavemanagementspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avensys.leavemanagementspring.entity.User;

public interface LoginPageRepository extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);

}
