package com.app.map;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.user.User;

public class MapService {
private static List<Company> companyList = new ArrayList<Company>();
	
	public List<Company> retrieveAccountDetails(int cid,Connection conn) {
		companyList.clear();
		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from company";
				System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null) {
					
					while (rs.next()) {
						User user=new User();
						//user.setUid(rs.getInt("user_id"));
						user.setUsername(rs.getString("username"));
						user.setFullname(rs.getString("fullname"));
						user.setEmail(rs.getString("email"));
						user.setRole(rs.getString("role"));
						//userList.add(user);
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return companyList;
	}
	
	
	public int updateUser(User user, Connection conn) {
		int update=0;
		try {
			if (conn != null && !conn.isClosed()) {

				Statement stmt = conn.createStatement();
				
				String sql = "update login set fullname='"+user.getFullname()+"', email='"+user.getEmail()+"' where username="+user.getUsername();
				System.out.println(sql);
				update=stmt.executeUpdate(sql);
	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}

}