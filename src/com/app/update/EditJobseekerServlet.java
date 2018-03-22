package com.app.update;

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

import com.app.post.PostService;





@WebServlet("/editjobseeker.do")
public class EditJobseekerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	Update update=new Update();
	private EditJobseekerService userRegister= new EditJobseekerService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int user_id=(int) request.getSession().getAttribute("user_id");
		try
		{
			System.out.println(user_id);
			conn = ds.getConnection();
			request.setAttribute("jobseeker", userRegister.retrieveUpdate(conn,user_id));
			request.getRequestDispatcher("view/editjobseeker.jsp").forward(request, response);

		}
		catch(SQLException e)
		{
			log(e.getMessage(), e);
		}
	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("fullname");
		String location = request.getParameter("location");
		String dateofbirth = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String percentage = request.getParameter("percentage");
		String branch = request.getParameter("branch");
		String keyskills = request.getParameter("keyskills");
		String experience = request.getParameter("experience");
		String email = request.getParameter("email");
		int id=(int)request.getSession().getAttribute("user_id");
		
		
		boolean isUserRegistered=userRegister.isUserRegistered(id,name,location,dateofbirth,gender,percentage,branch,keyskills,experience,email,conn);
		if(isUserRegistered)
		{
			request.setAttribute("error", "User already registered");
			request.getRequestDispatcher("view/editjobseeker.jsp").forward(request, response);
						
		}
		else
		{
			response.sendRedirect("editjobseeker.do");

		}
	}

}
