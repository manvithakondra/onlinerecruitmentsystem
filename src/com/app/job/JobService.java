package com.app.job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.job.company;

public class JobService {
private static List<company> companyList = new ArrayList<company>();
	
	public List<company> retrieveAccountDetails(int cid,String name,String address,String description,Connection conn) {
		companyList.clear();
		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from company where cid='"+ cid +"'";
				System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null) {
					
					while (rs.next()) {
						company com=new company();
						com.setCid(rs.getInt("cid"));
						com.setName(rs.getString("name"));
						com.setAddress(rs.getString("address"));
						com.setDescription(rs.getString("description"));
						
						companyList.add(com);
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return companyList;
	}
	
	
	public int updateCompany(company com, Connection conn) {
		int update=0;
		try {
			if (conn != null && !conn.isClosed()) {

				Statement stmt = conn.createStatement();
				
				String sql = "update company set name='"+com.getName()+"', address='"+com.getAddress()+"' where description="+com.getDescription();
				System.out.println(sql);
				update=stmt.executeUpdate(sql);
	
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}

}
