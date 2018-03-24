package com.app.apply;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.update.UpdateJobseeker;

public class JobseekerListService {

	private static List<UpdateJobseeker> jslist = new ArrayList<UpdateJobseeker>();
	
	public List<UpdateJobseeker> retrieveAllUpdate(int id,Connection conn) {
		jslist.clear();

		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from jsdetails where jid in (select jid from apply where userid='"+id+"')";
				System.out.println(sql);
				rs = stmt.executeQuery(sql);
				System.out.println("query executed");
				if (rs != null ) {
					System.out.println("if");
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
						jslist.add(u);
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(messages.size());
		return jslist;
	}	
	
}
