package com.app.apply;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplyService {

	public boolean isApplied(int uid, int jid, Connection conn) {
		boolean apply=true;
	//	System.out.println("user id: "+id);

		try {

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				Statement stmt = conn.createStatement();
				String sql = "select * from apply where userid='" + uid + "'";
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					//System.out.println("aaa");
				  apply = true;
				}
				else
				{
					//System.out.println("sss");
					String insertSql = "insert into apply (userid,jid) values('" + uid + "','" + jid + "')";					
					stmt.executeUpdate(insertSql);
					apply=false;
					return apply;
				}

			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apply;
		
	}
	
	
}
