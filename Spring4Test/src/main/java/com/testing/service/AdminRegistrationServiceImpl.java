package com.testing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testing.dao.AdminRegistrationDao;
import com.testing.model.AdminLogin;
import com.testing.model.AdminRegistration;

@Service("registrationservice")
@Transactional
public class AdminRegistrationServiceImpl implements AdminRegistrationService {
	@Autowired
	private AdminRegistrationDao registrationdao;
	public void addAdmin(AdminRegistration adminRegistration) {
		System.out.println("We are in Service Method"+adminRegistration.getEmail());
		registrationdao.addAdmin(adminRegistration);
		
	}

}
