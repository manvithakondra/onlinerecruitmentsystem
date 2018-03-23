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
		
		int user_id=(int) request.getSession().getAttribute("user_id");		
		try
		{
			conn = ds.getConnection();
			request.setAttribute("company", companyDetails.getListOfCompanys(conn,user_id));
			request.getRequestDispatcher("view/aboutcompanies.jsp").forward(request, response);

			
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
				e.printStackTrace();
			}
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("company");
		String address = request.getParameter("address");
		String description = request.getParameter("description");
		
		int id=(int)request.getSession().getAttribute("user_id");
		
		
		try
		{
			conn=ds.getConnection();
			boolean insert=companyDetails.isCompanyRegistered(id,name, address,description,conn);
			if(!insert)
			{
				request.setAttribute("msg", "success");
				request.setAttribute("success", "Company details updated.");
				request.getRequestDispatcher("view/aboutcompanies.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "error");
				request.setAttribute("error", "Error in updating");
				request.getRequestDispatcher("view/aboutcompanies.jsp").forward(request, response);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

}
}
