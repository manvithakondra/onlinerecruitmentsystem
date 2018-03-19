package com.app.registration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AboutUsService {
	
	public boolean isCompanyRegistered(String name,String address,String description, Connection conn) {
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
					String insertSql = "insert into company (name,address,description) values('" + name + "','" + address + "','" + description + "')";
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

}
