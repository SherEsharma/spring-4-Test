package com.testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testing.model.AdminRegistration;
import com.testing.service.RecruiterService;

@Controller
public class RecruiterController {

	
	@Autowired
	private RecruiterService recruiterservice;
	
	@RequestMapping(value = {"/",  "/ViewUser" },method=RequestMethod.GET)
	public String listuser(ModelMap model){
		//User user = new User();
		
		List<AdminRegistration> user= recruiterservice.findAllUser();
		
		model.addAttribute("user", user);
		//System.out.println("size size"+user.size());
		return "userlist";
	}
	
	
	@RequestMapping(value = { "/delete-{id}-user" }, method = RequestMethod.GET)
	public String deleteuser(@PathVariable int id) {
		System.out.println("In delete list");
		//service.deleteEmployeeBySsn(ssn);
		recruiterservice.delete(id);
		return "userlist";
	}
	
}
