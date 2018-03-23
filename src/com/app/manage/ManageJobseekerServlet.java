package com.app.manage;

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

import com.app.update.EditJobseekerService;
import com.app.update.Update;


@WebServlet("/managejobseeker.do")
public class ManageJobseekerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	Update update=new Update();
	private ManageJobseekerService userRegister= new ManageJobseekerService();   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			//System.out.println(user_id);
			conn = ds.getConnection();
			request.setAttribute("jobseeker", userRegister.retrieveAllUpdate(conn));
			
			request.getRequestDispatcher("view/managejobseeker.jsp").forward(request, response);

		}
		catch(SQLException e)
		{
			log(e.getMessage(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/managejobseeker.jsp").forward(request, response);
	}

}
