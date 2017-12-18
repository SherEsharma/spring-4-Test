package com.testing.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testing.model.AdminLogin;
import com.testing.model.AdminRegistration;
import com.testing.service.AdminLoginServices;

@Controller
public class AdminLoginController {
	@Autowired
	AdminLoginServices loginsservice;
	
	@RequestMapping(value ={"adminlogin"}, method=RequestMethod.GET)
	public String adminLoginjsp(){
				
		return "login";
	}
	
	@RequestMapping(value ={"logout"}, method=RequestMethod.GET)
	public String adminLogiut(){
		return "login";
	}
	
	@RequestMapping(value ={"/login"}, method=RequestMethod.POST)
	public String adminLogin(@Valid AdminLogin login,BindingResult result,ModelMap model){
		System.out.println("login controller");
		
		if(result.hasErrors()){
			System.out.println("any error in login");
			return "login";
		}
		
		if(loginsservice.adminLogin(login)){
			String email=login.getUsername();
			model.addAttribute("email", email);
			
			return "success";
		}
		
		return "login";
	}
	


}
