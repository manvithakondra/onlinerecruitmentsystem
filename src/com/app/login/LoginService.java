package com.app.login;

import java.sql.*;

import com.app.user.User;


public class LoginService {

	

	public boolean isUserValid(String name, String password, User user, Connection conn) {
		try {
			//System.out.println("inside");

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				String sql = "select * from login where username=? and password=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setString(2,password);
				//pstmt.setString(3,role);
				System.out.println(pstmt);
				rs = pstmt.executeQuery();

				if (rs != null && rs.next()) {
					
					user.setUsername(rs.getString("username"));
					//System.out.println(rs.getString("username"));

					user.setRole(rs.getString("role"));
					//System.out.println(rs.getString("role"));
					return true;

				}

			}

		} catch (SQLException e) {
			// log(e.getMessage(), e);
			e.printStackTrace();
		}
		return false;
	}

}
