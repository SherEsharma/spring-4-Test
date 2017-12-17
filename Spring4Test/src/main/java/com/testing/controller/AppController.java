package com.testing.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.testing.service.LoginService;

@Controller
public class AppController {

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request ,HttpServletResponse response){
		
		int i=Integer.parseInt(request.getParameter("num1"));
		int j=Integer.parseInt(request.getParameter("num2"));
		int k=i+j;
		System.out.println(k);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("display");
		view.addObject("view",k);
		
		return view;
	}
	
	//@RequestMapping("/login" , method=RequestMethod.GET)
	@RequestMapping(value ={"/login"}, method=RequestMethod.POST)
	/*public ModelAndView Checkuser(HttpServletRequest request, HttpServletResponse response){*/
	public ModelAndView Checkuser(@RequestParam("username")String username,@RequestParam("password") String password){
		
		ModelAndView model = new ModelAndView();
		
		/*String username=request.getParameter("username");
		String password=request.getParameter("password");*/
		
		if(new LoginService().checklogin(username, password)){
			model.setViewName("success");
		}
		else{
			model.setViewName("error");
		}
		
		/*if(username.equals("shubham")&&password.equals("123456")){
			model.setViewName("success");
		}
		else{
			model.setViewName("error");
		}*/
		return model;
		
		
		
	}
	
}

