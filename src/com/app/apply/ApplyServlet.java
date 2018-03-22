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
//import com.app.update.EditJobseekerService;


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
<<<<<<< HEAD
			request.setAttribute("message", "error");
			request.setAttribute("error", "not applied");
			request.getRequestDispatcher("view/job.jsp").forward(request, response);
=======
			request.setAttribute("msg", "error");
			request.setAttribute("error", "cannot apply");
			response.sendRedirect("apply.do");
			//request.getRequestDispatcher("apply.do").forward(request, response);
>>>>>>> branch 'master' of https://github.com/manvithakondra/onlinerecruitmentsystem.git
						
		}
		else

		{
<<<<<<< HEAD
			request.setAttribute("message", "success");
			request.setAttribute("success", "applied successfully");
=======
			request.setAttribute("msg", "success");
			request.setAttribute("success", "applied successfully");
			//request.getRequestDispatcher("apply.do").forward(request, response);
>>>>>>> branch 'master' of https://github.com/manvithakondra/onlinerecruitmentsystem.git
			response.sendRedirect("apply.do");


		}
	}

	}
