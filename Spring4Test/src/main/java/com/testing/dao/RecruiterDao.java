package com.testing.dao;

import java.util.List;

import com.testing.model.AdminRegistration;

public interface RecruiterDao {
	List<AdminRegistration> findAllUser();
	
	public void delete(int id);
}
