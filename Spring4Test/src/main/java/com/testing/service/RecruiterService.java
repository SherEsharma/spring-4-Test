package com.testing.service;

import java.util.List;

import com.testing.model.AdminRegistration;

public interface RecruiterService {
	List<AdminRegistration> findAllUser();
	
	public void delete(int id);
}
