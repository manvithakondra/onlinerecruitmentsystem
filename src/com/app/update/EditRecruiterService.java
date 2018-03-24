package com.app.update;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EditRecruiterService {

	public boolean isRecRegistered(int id, String name, String location, String industry, String email, Connection conn) {
		boolean recExists=true;
	//	System.out.println("user id: "+id);

		try {

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				Statement stmt = conn.createStatement();
				String sql = "select * from recdetails where userid='"+id+"'";
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);
				if(rs.next() && rs!=null) {
					System.out.println(rs.getString("name"));
				  recExists = true;
				}
				else
				{
					//System.out.println("sss");
					String insertSql = "insert into recdetails (name,location,industry,email,userid) values('" + name + "','" + location + "', '"+industry+"', '"+email+"','"+id+"')";					
					stmt.executeUpdate(insertSql);
					recExists=false;
					return recExists;
				}

			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recExists;
		
	}
	
private static List<UpdateRecruiter> recruiter = new ArrayList<UpdateRecruiter>();
	
	public UpdateRecruiter retrieveUpdate(Connection conn,int user_id) {
		//jobseeker.clear();
		UpdateRecruiter u=new UpdateRecruiter();

		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from recdetails where userid='"+user_id+"'";
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null) {
					
					while (rs.next()) {
						//System.out.println("retrieve");
						u.setRecid(rs.getInt("recid"));
						u.setName(rs.getString("name"));
						u.setLocation(rs.getString("location"));
						u.setIndustry(rs.getString("industry"));
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
	}	
	
}
