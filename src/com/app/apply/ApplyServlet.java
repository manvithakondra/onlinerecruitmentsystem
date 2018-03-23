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

import com.app.post.Message;
import com.app.post.PostService;
//import com.app.update.EditJobseekerService;
import com.app.update.Update;


@WebServlet("/apply.do")
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	private ApplyService apply= new ApplyService();
	private Shortlist shortlist= new Shortlist();
	PostService postservice=new PostService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			conn = ds.getConnection();

		}
		catch(SQLException e)
		{
			log(e.getMessage(), e);
		}
		
		request.setAttribute("messages", postservice.retrieveMessage(conn));
		System.out.println("doGet");
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

			
			request.getSession().setAttribute("message", "error");
			request.getSession().setAttribute("error", "not applied");
			//request.getRequestDispatcher("view/job.jsp").forward(request, response);
			response.sendRedirect("apply.do");
			//System.out.println("if");
			//request.getRequestDispatcher("apply.do").forward(request, response);
						
		}
		else

		{
		//	System.out.println("else");
			Message m=shortlist.jobRetrieve( jid, conn);
			Update u=shortlist.userRetrieve( uid, conn);
			System.out.println(u.getPercentage());
			shortlist.compare(m, u, uid);
			request.getSession().setAttribute("msg", "success");
			request.getSession().setAttribute("success", "applied successfully");
			//request.getRequestDispatcher("apply.do").forward(request, response);
			response.sendRedirect("apply.do");


		}
		
	}

	}
