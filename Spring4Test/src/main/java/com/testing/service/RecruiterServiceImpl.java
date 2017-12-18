package com.testing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testing.dao.RecruiterDao;
import com.testing.model.AdminRegistration;
@Service
@Transactional
public class RecruiterServiceImpl implements RecruiterService {

	@Autowired
	private RecruiterDao recruiterdao;
		
	public List<AdminRegistration> findAllUser() {
		System.out.println("to fetch the list in service");
		
		return recruiterdao.findAllUser();
	}

	public void delete(int id) {
		System.out.println("We are in delete service");
		recruiterdao.delete(id);
	}
}
