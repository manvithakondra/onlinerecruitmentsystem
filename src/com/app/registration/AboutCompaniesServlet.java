package com.app.registration;

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


@WebServlet("/aboutcompanies.do")
public class AboutCompaniesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	private AboutCompaniesServices companyDetails= new AboutCompaniesServices();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			conn = ds.getConnection();
			request.setAttribute("company", companyDetails.retrieveAllCompanies(conn));
		    request.getRequestDispatcher("view/aboutcompanies.jsp").forward(request, response);

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
						request.getRequestDispatcher("view/aboutcompanies.jsp").forward(request, response);
			}
		

     }

