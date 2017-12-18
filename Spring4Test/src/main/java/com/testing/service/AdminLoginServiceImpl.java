package com.testing.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testing.dao.AdminLoginDao;

import com.testing.model.AdminLogin;

@Service("loginsservice")
@Transactional
public class AdminLoginServiceImpl implements AdminLoginServices {
	@Autowired
	private AdminLoginDao  adminlogindao;
	
	public boolean adminLogin(AdminLogin adminLogin) {
		
		System.out.println("in login service");
		return adminlogindao.adminLogin(adminLogin);
	}
}
