package com.testing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.testing.model.AdminLogin;

@Repository("adminlogindao")
public class AdminLoginDaoImpl extends AbstractDao<Integer, AdminLogin> implements AdminLoginDao {
	
		

	
	
		
	public boolean adminLogin(AdminLogin adminLogin) {
		
		String username=adminLogin.getUsername();
		String password=adminLogin.getPassword();
		
		System.out.println("In Check login");
	/*
		boolean userFound = false;
		//Query using Hibernate Query Language
	String SQL_QUERY ="from adminregistration  where admin_email=? and admin_password=?";
		
	System.out.println("SQL_QUERYSQL_QUERY"+SQL_QUERY);

		Query query = getSession().createQuery(SQL_QUERY);
		query.setParameter(0,username);
		query.setParameter(1,password);
		List list = query.list();
		System.out.println("listlistlistlistlist"+list);
		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		;
		return userFound;*/
		
		
	

		String url="jdbc:mysql://localhost:3306/tempdb";
		String user="root";
		String pass="";
		String sql=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,pass);
			sql="select * from adminregistration where admin_email=? and admin_password=?";
			PreparedStatement psmpt = conn.prepareStatement(sql);
			psmpt.setString(1, username);
			psmpt.setString(2, password);
			
			ResultSet rs=psmpt.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}

}
