package com.avensys.leavemanagementspring.service;

import java.util.List;

import com.avensys.leavemanagementspring.entity.User;

public interface LoginPageService {
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public void save(User user);
	
	public void delete(int id);
	
}
