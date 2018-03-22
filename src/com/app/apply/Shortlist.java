package com.app.apply;

import com.app.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.mailnotification.SendMail;
import com.app.post.Message;
import com.app.update.Update;

public class Shortlist {

	Message m=new Message();
	Update u=new Update();
	public Message jobRetrieve(int jid, Connection conn) {
	//	System.out.println("user id: "+id);
		
		try {

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				Statement stmt = conn.createStatement();
				String sql = "select * from postjob where jid='" + jid + "'"; 
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);
				if(rs!=null) {
					
				    m.setPercentage(rs.getDouble("percentage"));
				}
			}
		//	conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
		//return u;
	}
	public Update userRetrieve(int uid, Connection conn) {
	//	System.out.println("user id: "+id);
		

		try {

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				Statement stmt = conn.createStatement();
				String sql = "select * from jsdetails where userid='" + uid + "'"; 
				//System.out.println(sql);
				rs = stmt.executeQuery(sql);
				if(rs!=null) {
					
				    u.setPercentage(rs.getDouble("percentage"));
				}
			}
		//	conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
		//return u;
	}
	public void compare(Message m, Update u,int uid) {
		if(u.getPercentage()<m.getPercentage()) {
			String sql="delete * from apply where userid='"+uid+"'";
			String message =  "view/reject.html";
			SendMail.send(message);
		}
		else {
			String message =  "view/accept.html";
			SendMail.send(message);
		}
		
	}
	
}