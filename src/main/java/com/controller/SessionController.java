package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.UserBean;

@Controller
public class SessionController {
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signup(Model model) {
		UserBean user=new UserBean();
		model.addAttribute("user",user);
		System.out.println("signup()");
		return "Signup";
	}
	
	@RequestMapping(value="saveuser",method=RequestMethod.POST)
	public String login(@ModelAttribute("user") @Valid UserBean user1,BindingResult result,Model model) {
		model.addAttribute("user",user1);
//		System.out.println(result.getErrorCount());
//		System.out.println(user1.getEmail().length());
//		System.out.println(user1.getEmail());
//		System.out.println(user1.getFirstname());
//		System.out.println(user1.getPassword());
		System.out.println(result.getAllErrors());
		if(result.hasErrors()) {
			return "Signup";
		}else {
			System.out.println("Login()");
			return "Login";
		}
	}
}
