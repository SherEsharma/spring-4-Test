package com.testing.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.testing.model.AdminRegistration;

@Repository("registrationdao")
public class AdminRegistrationDaoImpl extends AbstractDao<Integer, AdminRegistration>  implements AdminRegistrationDao {

	public void addAdmin(AdminRegistration adminRegistration) {
		System.out.println( "we are in dao method"+ adminRegistration.getFirstname());
		persist(adminRegistration);
		
	}
	
	
}
