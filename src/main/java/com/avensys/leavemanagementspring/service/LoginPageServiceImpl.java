package com.avensys.leavemanagementspring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.avensys.leavemanagementspring.entity.User;
import com.avensys.leavemanagementspring.repository.LoginPageRepository;

@Service
public class LoginPageServiceImpl implements LoginPageService{

	private LoginPageRepository loginPageRepository;
	
	@Autowired
	public LoginPageServiceImpl(LoginPageRepository loginPageRepository) {
		this.loginPageRepository = loginPageRepository;
	}
	
	@Override
	@Transactional
	public List<User> findAll() {
		return loginPageRepository.findAll();
	}

	@Override
	@Transactional
	public User findById(int id) {
		Optional<User> result = loginPageRepository.findById(id);
		User user = null;
		if(result.isPresent()) {
			user = result.get();
		}
		else {
			throw new RuntimeException();
		}
		return user;
	}

	@Override
	@Transactional
	public void save(User user) {
		loginPageRepository.save(user);
	}

	@Override
	@Transactional
	public void delete(int id) {
		loginPageRepository.deleteById(id);
	}


}
