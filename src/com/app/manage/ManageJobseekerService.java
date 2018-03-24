package com.app.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.update.UpdateJobseeker;

public class ManageJobseekerService {

private static List<UpdateJobseeker> jobseeker = new ArrayList<UpdateJobseeker>();
	
	/*public Update retrieveUpdate(Connection conn) {
		//jobseeker.clear();
		Update u=new Update();

		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from jsdetails";
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null ) {
					
					while (rs.next()) {
						//System.out.println("retrieve");
						u.setJsid(rs.getInt("jsid"));
						u.setName(rs.getString("name"));
						u.setLocation(rs.getString("location"));
						u.setDateofbirth(rs.getString("dateofbirth"));
						u.setGender(rs.getString("gender"));
						u.setPercentage(rs.getDouble("percentage"));
						u.setBranch(rs.getString("branch"));
						u.setKeyskills(rs.getString("keyskills"));
						u.setExperience(rs.getString("experience"));
						u.setEmail(rs.getString("email"));
						u.setUserid(rs.getInt("userid"));
						//jobseeker.add(u);
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(messages.size());
		return u;
	}*/	
	public List<UpdateJobseeker> retrieveAllUpdate(Connection conn) {
		jobseeker.clear();

		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from jsdetails";
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null ) {
					
					while (rs.next()) {
						UpdateJobseeker u=new UpdateJobseeker();
						System.out.println(rs.getString("name"));
						u.setJsid(rs.getInt("jsid"));
						u.setName(rs.getString("name"));
						u.setLocation(rs.getString("location"));
						u.setDateofbirth(rs.getString("dateofbirth"));
						u.setGender(rs.getString("gender"));
						u.setPercentage(rs.getDouble("percentage"));
						u.setBranch(rs.getString("branch"));
						u.setKeyskills(rs.getString("keyskills"));
						u.setExperience(rs.getString("experience"));
						u.setEmail(rs.getString("email"));
						u.setUserid(rs.getInt("userid"));
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