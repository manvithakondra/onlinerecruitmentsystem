package com.app.login;

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

//import com.app.registration.RegistrationService;


@WebServlet("/changejobseeker.do")
public class ChangeJobseekerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	private ChangeJobseekerService userRegister= new ChangeJobseekerService();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("view/changejobseeker.jsp").forward(request, response);	
	 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=(int)request.getSession().getAttribute("user_id");
		String oldpassword = request.getParameter("oldpassword");
		//System.out.println("old:"+oldpassword);
		String newpassword = request.getParameter("newpassword");
		//System.out.println("new:"+newpassword);
		String confirm_password = request.getParameter("confirmpassword");
		//System.out.println("confirm:"+confirm_password);
		if (newpassword!=null && confirm_password!=null) {
			   // check if they are equal:
			   if (newpassword.equals(confirm_password)) {
				   try
					{
						conn = ds.getConnection();

					}
					catch(SQLException e)
					{
						log(e.getMessage(), e);
					}
					boolean isUserRegistered=userRegister.isUserRegistered(id,oldpassword,newpassword,conn);
					if(isUserRegistered)
					{
						request.setAttribute("error", "Password can't be changed");
						request.getRequestDispatcher("view/changejobseeker.jsp").forward(request, response);
									
					}
					else
					{
						response.sendRedirect("changejobseeker.do");

					}
			 
			 }
			   }
				   
			 else
			 {
				  request.setAttribute("error", "Confirmation password did not match");
				   request.getRequestDispatcher("view/changejobseeker.jsp").forward(request, response);
		}
		//request.getRequestDispatcher("view/changejobseeker.jsp").forward(request, response);
	}

}
