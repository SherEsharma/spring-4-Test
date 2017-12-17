package com.testing.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {
	
	public boolean checklogin(String username,String password){
		
		String url="jdbc:mysql://localhost:3306/trabaajoadmin";
		String user="root";
		String pass="root";
		String sql=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,pass);
			sql="select * from adminregistration where adminemail=? and adminpassword=?";
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
