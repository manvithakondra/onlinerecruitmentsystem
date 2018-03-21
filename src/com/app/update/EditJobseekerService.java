package com.app.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.post.Message;

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
	
private static List<Update> jobseeker = new ArrayList<Update>();
	
	public List<Update> retrieveUpdate(Connection conn) {
		jobseeker.clear();
		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from jsdetails where name =?";
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null) {
					
					while (rs.next()) {
						Update u=new Update();
						u.setJsid(rs.getInt("jsid"));
						u.setName(rs.getString("name"));
						u.setLocation(rs.getString("location"));
						u.setDateofbirth(rs.getString("dateofbirth"));
						u.setGender(rs.getString("gender"));
						u.setPercentage(rs.getString("percentage"));
						u.setBranch(rs.getString("branch"));
						u.setKeyskills(rs.getString("keyskills"));
						u.setExperience(rs.getString("experience"));
						u.setEmail(rs.getString("email"));
						jobseeker.add(u);
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(messages.size());
		return jobseeker;
	}	
	
}

