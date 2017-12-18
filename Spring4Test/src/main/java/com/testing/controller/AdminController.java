package com.testing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.testing.model.AdminRegistration;
import com.testing.service.AdminRegistrationService;



@Controller
public class AdminController {

	@Autowired
		AdminRegistrationService registrationservice;
		
	@RequestMapping(value= {"Adminregistration"}, method=RequestMethod.GET)
	public String Adminregistrationjsp(Model model){
		System.out.println("Admin Registration Controller");
			AdminRegistration registration = new AdminRegistration();
			model.addAttribute(registration);
		return "AdminRegistration";
	}
	
	@RequestMapping(value={"add"}, method=RequestMethod.POST)
	public String adminRegistrationAdd(@Valid AdminRegistration registration,  BindingResult result,
			ModelMap model){
		System.out.println("Add functiona inside");
		
		if(result.hasErrors()){
			System.out.println("any error");
			return "AdminRegistration";
		}
		registrationservice.addAdmin(registration);
		return "login";
	}
	
	
	
	
}
