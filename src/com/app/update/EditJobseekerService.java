package com.app.update;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EditJobseekerService {

	public boolean isUserRegistered(int id,String name,String location,String dateofbirth, String gender, String percentage, String branch, 
			String keyskills,  String experience, String email, Connection conn) {
		boolean usernameExists=true;
	//	System.out.println("user id: "+id);

		try {

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				Statement stmt = conn.createStatement();
				String sql = "select * from jsdetails where name='" + name + "'";
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					//System.out.println("aaa");
				  usernameExists = true;
				}
				else
				{
					//System.out.println("sss");
					String insertSql = "insert into jsdetails (name,location,dateofbirth,gender,percentage,branch,keyskills,experience,email,userid) values('" + name + "','" + location + "','" + dateofbirth + "', '"+gender+"', '"+percentage+"', '"+branch+"', '"+keyskills+"' , '"+experience+"' , '"+email+"','"+id+"')";					
					stmt.executeUpdate(insertSql);
					usernameExists=false;
					return usernameExists;
				}

			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usernameExists;
		
	}
	
	
	
}
