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

import com.app.update.UpdateJobseeker;

@WebServlet("/managecompanies.do")
public class ManageCompaniesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	UpdateJobseeker update=new UpdateJobseeker();
	private ManageCompaniesService userRegister= new ManageCompaniesService(); 
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try
		{
			
			conn = ds.getConnection();
			request.setAttribute("company", userRegister.retrieveAllCompanies(conn));
		    request.getRequestDispatcher("view/managecompanies.jsp").forward(request, response);

		}
		catch(SQLException e)
		{
			log(e.getMessage(), e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/managecompanies.jsp").forward(request, response);
	}

}
