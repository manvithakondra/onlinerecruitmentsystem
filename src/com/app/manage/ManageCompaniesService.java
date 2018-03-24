package com.app.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.job.company;

public class ManageCompaniesService {

private static List<company> company = new ArrayList<company>();
	
	public List<company> retrieveAllCompanies(Connection conn) {
		company.clear();
		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from company";
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null) {
					
					while (rs.next()) {
						company com=new company();
						com.setCid(rs.getInt("cid"));
						com.setName(rs.getString("name"));
					    com.setAddress(rs.getString("address"));
						com.setDescription(rs.getString("description"));
						company.add(com);
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return company;
	}
	
}
