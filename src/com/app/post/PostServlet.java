package com.app.post;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//import com.app.todo.Todo;


@WebServlet("/post.do")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	
	private PostService postService = new PostService();   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			conn = ds.getConnection();
			//request.setAttribute("messages", postService.retrieveMessage(conn));
			request.getRequestDispatcher("view/post.jsp").forward(request, response);
			
		}
		catch(SQLException e)
		{
			log(e.getMessage(), e);
		}
		/*finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String percentage = request.getParameter("percentage");
		String year = request.getParameter("year");
		String degree = request.getParameter("degree");
		String branch = request.getParameter("branch");
		String designation = request.getParameter("designation");
		String address = request.getParameter("address");
		String event_venue = request.getParameter("event_venue");
		String profile = request.getParameter("profile");
		String salary = request.getParameter("salary");
		String event_date = request.getParameter("event_date");
		System.out.println(percentage+" "+year+" "+degree+" "+branch+" "+designation+" "+address+" "+event_venue+" "+
		profile+" "+salary+" "+event_date+" ");
		if (percentage!=null && year!=null && degree!=null && branch!=null 
				&& designation!=null && address!=null && event_venue!=null && profile!=null 
				&& salary!=null && event_date!=null) {
			System.out.println("inside");
			   try
				{
					conn = ds.getConnection();
					Message m=new Message();
					m.setPercentage(percentage);
					m.setYear(Integer.parseInt(year));
					m.setDegree(degree);
					m.setBranch(branch);
					m.setDesignation(designation);
					m.setAddress(address);
					m.setEvent_Venue(event_venue);
					m.setProfile(profile);
					m.setSalary(Double.parseDouble(salary));
					m.setEvent_Date(event_date);
					postService.addMessage(m,conn);
					response.sendRedirect("post.do");
					
				}
				catch(SQLException e)
				{
					log(e.getMessage(), e);
				}
				finally
				{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}   
		else
		{
			request.setAttribute("error", "Confirmation password did not match");
			request.getRequestDispatcher("view/post.jsp").forward(request, response);
		}
	}

}
