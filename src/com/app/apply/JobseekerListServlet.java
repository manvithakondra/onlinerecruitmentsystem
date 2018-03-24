package com.app.apply;

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

import com.app.manage.ManageJobseekerService;
import com.app.update.UpdateJobseeker;

/**
 * Servlet implementation class JobseekerServlet
 */
@WebServlet(name = "JobseekerListServlet", urlPatterns = { "/jobseekerlist.do" })
public class JobseekerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	UpdateJobseeker update=new UpdateJobseeker();
	private JobseekerListService jslist= new JobseekerListService();  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=(int) request.getSession().getAttribute("user_id");
		try
		{
			System.out.println(id);
			conn = ds.getConnection();
			request.setAttribute("jobseeker", jslist.retrieveAllUpdate(id,conn));
			request.getRequestDispatcher("view/jobseekerlist.jsp").forward(request, response);

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
		request.getRequestDispatcher("view/jobseekerlist.jsp").forward(request, response);
	}

}
