package com.avensys.leavemanagementspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avensys.leavemanagementspring.entity.User;
import com.avensys.leavemanagementspring.repository.LoginPageRepository;
import com.avensys.leavemanagementspring.service.LoginPageService;

@Controller
@RequestMapping("/login")
public class LoginPageController {
	
	private LoginPageService loginPageService;
	private LoginPageRepository loginPageRepository;
	
	@Autowired
	public LoginPageController(LoginPageService loginPageService, LoginPageRepository loginPageRepository) {
		this.loginPageRepository = loginPageRepository;
		this.loginPageService = loginPageService;
	}
	
	@GetMapping("")
	public String displayLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "index";
	}
	
	@PostMapping("")
	public String loginUser(@ModelAttribute("user") User user) {
		System.out.println("loginUser");
		System.out.println(user.getEmail() + user.getPassword());
		User tempUser = loginPageRepository.findByEmail(user.getEmail());
		if(tempUser != null && tempUser.getPassword().equals(user.getPassword())) {
				return "welcome";
		}
		else {
			return "index";
		}
	}

}
