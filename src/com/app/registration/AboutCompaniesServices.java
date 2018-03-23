package com.app.registration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.job.company;

public class AboutCompaniesServices {
	public boolean isCompanyRegistered(int id,String name,String address,String description,Connection conn) {
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
					String insertSql = "insert into company (name,address,description,userid) values('" + name + "','" + address + "','" + description + "',"+id+")";
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
	
	/*public int updateCompany(company comp, Connection conn) {
		int update=0;
		try {
			if (conn != null && !conn.isClosed()) {

				Statement stmt = conn.createStatement();
				
				//String sql = "update login set fullname='"+user.getFullname()+"', email='"+user.getEmail()+"' where user_id="+user.getUser_id();
				//System.out.println(sql);
				//update=stmt.executeUpdate(sql);
	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}*/
	
	/*public company getCompanyDetails(Connection conn, int userid)
	{
		

		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from company where userid='"+ userid +"'";
				System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null) {
					
					while (rs.next()) {
						company com=new company();
						com.setCid(rs.getInt("cid"));
						com.setName(rs.getString("name"));
						com.setAddress(rs.getString("address"));
						com.setDescription(rs.getString("description"));
						
						
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return com;

	}*/
		
	public List<company> getListOfCompanys(Connection conn,int user_id)
	{
		List<company> list=new ArrayList<company>();

		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from company";
				System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null) {
					
					while (rs.next()) {
						company com=new company();
						com.setCid(rs.getInt("cid"));
						com.setName(rs.getString("name"));
						com.setAddress(rs.getString("address"));
						com.setDescription(rs.getString("description"));
						
						list.add(com);
						
			        }  
					
				}
					
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}


}
