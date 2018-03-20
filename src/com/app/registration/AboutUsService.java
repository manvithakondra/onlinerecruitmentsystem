package com.app.registration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.job.company;

public class AboutUsService {
	
	public boolean isCompanyRegistered(int id,String name,String address,String description,String lat,String lng,Connection conn) {
		boolean companyExists=true;
		try {

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				Statement stmt = conn.createStatement();
				String sql = "select * from company where name='" + name + "'";
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					//System.out.println("aaa");
				  companyExists = true;
				}
				else
				{
					//System.out.println("sss");
					String insertSql = "insert into company (name,address,description,lat,lng,userid) values('" + name + "','" + address + "','" + description + "','" + lat + "','" + lng + "')";
					stmt.executeUpdate(insertSql);
					companyExists=false;
					return companyExists;
				}

			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companyExists;
		
	}
	
	public company getCompanyDetails(Connection conn, int userid)
	{
		company com=new company();

		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from company where userid='"+ userid +"'";
				System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null) {
					
					while (rs.next()) {
						com.setCid(rs.getInt("cid"));
						com.setName(rs.getString("name"));
						com.setAddress(rs.getString("address"));
						com.setDescription(rs.getString("description"));
						com.setLat(rs.getString("lat"));
						com.setLng(rs.getString("lng"));

						
			        }  
					
				}
					
			}
			return com;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return com;

	}


}
