package com.testing.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.testing.model.AdminRegistration;
@Repository
public class RecruiterDaoImpl extends AbstractDao<Integer, AdminRegistration> implements RecruiterDao {

	public List<AdminRegistration> findAllUser() {
		System.out.println("in List fetch dao");
		Criteria criteria = createEntityCriteria();
		return (List<AdminRegistration>) criteria.list();
		
	}
	
	
	public void delete(int id) {
		System.out.println("We are in delete dao");
		Query query = getSession().createSQLQuery("delete from adminregistration where admin_id = :id");
		
		query.setInteger("id", id);
		
		query.executeUpdate();
		
		
		System.out.println("successfully  delete dao");
		
	}

}
