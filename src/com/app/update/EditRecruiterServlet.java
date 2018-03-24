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

@WebServlet("/editrecruiter.do")
public class EditRecruiterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	UpdateRecruiter update=new UpdateRecruiter();
	private EditRecruiterService recRegister= new EditRecruiterService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int user_id=(int) request.getSession().getAttribute("user_id");
		try
		{
		//	System.out.println(user_id);
			conn = ds.getConnection();
			request.setAttribute("recruiter", recRegister.retrieveUpdate(conn,user_id));
			request.getRequestDispatcher("view/editrecruiter.jsp").forward(request, response);

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
		String name = request.getParameter("name");
		System.out.println(name);
		String location = request.getParameter("location");
		String industry = request.getParameter("industry");
		String email = request.getParameter("email");
		int id=(int)request.getSession().getAttribute("user_id");
		
		
		
		boolean isRecRegistered=recRegister.isRecRegistered(id,name,location,industry,email,conn);
		if(isRecRegistered)
		{
			request.setAttribute("error", "Recruiter already registered");
			request.getRequestDispatcher("view/editrecruiter.jsp").forward(request, response);
						
		}
		else
		{
			response.sendRedirect("editrecruiter.do");

		}
	}
}
