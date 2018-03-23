package com.app.post;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import com.app.update.Update;

public class PostService {
		
	private static List<Message> messages = new ArrayList<Message>();
	
	public List<Message> retrieveMessage(Connection conn) {
		messages.clear();
		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from postjob";
			//	System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null) {
					
					while (rs.next()) {
						Message m=new Message();
						m.setjid(rs.getInt("jid"));
						m.setPercentage(rs.getDouble("percentage"));
						m.setYear(rs.getInt("year"));
						m.setDegree(rs.getString("degree"));
						m.setBranch(rs.getString("branch"));
						m.setDesignation(rs.getString("designation"));
						m.setAddress(rs.getString("address"));
						m.setEvent_Venue(rs.getString("event_venue"));
						m.setProfile(rs.getString("profile"));
						m.setSalary(rs.getInt("salary"));
						m.setEvent_Date(rs.getString("event_date"));
						messages.add(m);
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	//	System.out.println(messages.size());
		return messages;
	}

private static List<String> email = new ArrayList<String>();
	
	public String[] retrieveEmail(Connection conn) {
		//email.clear();
		String[] allEmails= new String[10];
		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from jsdetails";
			//	System.out.println(sql);
				rs = stmt.executeQuery(sql);
				
				if (rs != null) {
					int i=0;
					while (rs.next()) {
						Update u=new Update();
						//u.setEmail(rs.getString("email"));
						System.out.println(rs.getString("email"));
						allEmails[i]=rs.getString("email");
						i++;
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	//	System.out.println(messages.size());
		return allEmails;
	}

	
	public void addMessage(Message message, Connection conn) {
		//System.out.println("hi");
		try {
			if (conn != null && !conn.isClosed()) {

				Statement stmt = conn.createStatement();
				String sql = "insert into postjob(percentage,year,degree,branch,designation,address,event_venue,profile,salary,event_date) values('"+message.getPercentage()+"','"+message.getYear()+"','"+message.getDegree()+"','"+message.getBranch()+"','"+message.getDesignation()+"','"+message.getAddress()+"','"+message.getEvent_Venue()+"','"+message.getProfile()+"','"+message.getSalary()+"','"+message.getEvent_Date()+"')";
				System.out.println(sql);
				int insert = stmt.executeUpdate(sql);
				if(insert==1)
				{
					messages.add(message);
				}	
			//	System.out.println("test4");

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
