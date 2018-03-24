package com.app.apply;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.mailnotification.SendMail;
import com.app.post.Message;
import com.app.update.UpdateJobseeker;

public class Shortlist {

	Message m=new Message();
	UpdateJobseeker u=new UpdateJobseeker();
	public Message jobRetrieve(int jid, Connection conn) {
	//	System.out.println("user id: "+id);
		
		try {

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				Statement stmt = conn.createStatement();
				String sql = "select * from postjob where jid='" + jid + "'"; 
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);
				if(rs!=null && rs.next()) {
					
				    m.setPercentage(rs.getDouble("percentage"));
				}
			}
			//conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
		//return u;
	}
	public UpdateJobseeker userRetrieve(int uid, Connection conn) {
	//	System.out.println("user id: "+uid);
		

		try {
			//System.out.println("con");
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				Statement stmt = conn.createStatement();
				//System.out.println("if");
				String sql = "select * from jsdetails where userid='" + uid + "'"; 
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);
				if(rs!=null && rs.next()) {
					
				    u.setPercentage(rs.getDouble("percentage"));
				    u.setEmail(rs.getString("email"));
				}
				//System.out.println(u.getPercentage());
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
		//return u;
	}
	public void compare(Message m, UpdateJobseeker u,int uid) {
		//System.out.println(m.getPercentage());
		//System.out.println("percentage:"+u.getPercentage());
		if(u.getPercentage()<m.getPercentage()) {
			String message =  "view/reject.html";
			SendMail.send(message,u.getEmail());
		}
		else {
			String message =  "view/accept.html";
			SendMail.send(message,u.getEmail());
		}
		
	}
	
}