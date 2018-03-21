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

import com.app.post.PostService;
import com.app.update.EditJobseekerService;


@WebServlet("/apply.do")
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	private ApplyService apply= new ApplyService();
	PostService postservice=new PostService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("messages", postservice.retrieveMessage(conn));
		request.getRequestDispatcher("view/job.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int jid=Integer.parseInt(request.getParameter("jid"));
		//System.out.println(jid);
		int uid=(int)request.getSession().getAttribute("user_id");
		//System.out.println(uid);
		
		try
		{
			conn = ds.getConnection();

		}
		catch(SQLException e)
		{
			log(e.getMessage(), e);
		}
		boolean isApplied=apply.isApplied(uid,jid,conn);
		if(isApplied)
		{
			request.setAttribute("error", "User already registered");
			request.getRequestDispatcher("view/job.jsp").forward(request, response);
						
		}
		else 
		{
			response.sendRedirect("apply.do");

		}
	}

	}
