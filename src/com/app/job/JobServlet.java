package com.app.job;

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

@WebServlet("/job.do")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;
	
	private PostService postService = new PostService();   
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			conn = ds.getConnection();
			//System.out.println("retrieve");
			request.setAttribute("messages", postService.retrieveMessage(conn));
			request.getRequestDispatcher("view/job.jsp").forward(request, response);	
			
		}
		catch(SQLException e)
		{
			log(e.getMessage(), e);
		}
		/*finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/job.jsp").forward(request, response);
	}

}
