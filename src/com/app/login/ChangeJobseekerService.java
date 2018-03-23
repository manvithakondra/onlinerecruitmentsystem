package com.app.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangeJobseekerService {

	public boolean isUserRegistered(int id, String oldpassword,String newpassword,  Connection conn) {
		boolean usernameExists=true;
		try {

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				//System.out.println(id);
				Statement stmt = conn.createStatement();
				String sql = "select * from login where userid='" + id + "'";
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);
				if(rs!=null && rs.next()) {
					//System.out.println("aaa");
				  usernameExists = true;
				  if(!rs.getString("password").equals(oldpassword)) {
					  return false;
				  }
				else
				{
					//System.out.println("sss");
					String insertSql = "update login set password='"+newpassword+"' where userid='"+id+"'";
					stmt.executeUpdate(insertSql);
					usernameExists=false;
					return usernameExists;
				}

			}
			conn.close();

		  }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return usernameExists;
		
	}
	
	
}
