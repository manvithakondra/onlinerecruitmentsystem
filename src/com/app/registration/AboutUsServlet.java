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

@WebServlet("/about.do")
public class AboutUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	private AboutUsService companyDetails= new AboutUsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/aboutus.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("company");
		String address = request.getParameter("address");
		String description = request.getParameter("description");
		try
		{
			conn=ds.getConnection();
			companyDetails.isCompanyRegistered(name, address, description,lat,conn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("view/aboutus.jsp").forward(request, response);

}
}