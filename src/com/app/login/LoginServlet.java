package com.app.login;

import java.io.IOException;
import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.app.user.User;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/onlinerecruiter")
	private DataSource ds;
	private Connection con;
    //private Statement stmt;
    //private ResultSet rs;
	
    private LoginService userValidation =new LoginService();
    User user=new User();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.getRequestDispatcher("view/login.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	        //int user_id=(int) request.getSession().getAttribute("userid");
		    String username=request.getParameter("name");
			String password=request.getParameter("password");
	        try
	        {
	        	con=ds.getConnection();
	        	//stmt=con.createStatement();
	        	//String sql="select role from login where username='"+username+"' and password='"+password+"'";
	        	//rs=stmt.executeQuery(sql);
	        	//System.out.println(rs);
	        	boolean isUserValid=userValidation.isUserValid(username, password, user,con);
	        	//System.out.println(user.getRole());
				if(isUserValid)
	        	{
				    //System.out.println(username);
					if(user!=null)
					{
	        		 if(user.getRole().equals("js"))
	        		 {
	        			request.getSession().setAttribute("name", user.getUsername());
	        			request.getSession().setAttribute("user_id", user.getUser_id());
	        			request.getRequestDispatcher("view/jobseeker.jsp").forward(request, response);
	        		 }
	        		 else if(user.getRole().equals("adm"))
	        		 {
	        			request.getSession().setAttribute("name", user.getUsername());
	        			request.getSession().setAttribute("user_id", user.getUser_id());
	        			request.getRequestDispatcher("view/admin.jsp").forward(request, response);
	        		 }
	        		 else
	        		 {
	        			request.getSession().setAttribute("name", user.getUsername());
	        			request.getSession().setAttribute("user_id", user.getUser_id());
	        			request.getRequestDispatcher("view/recruiter.jsp").forward(request, response);
	        		 }
	        		//request.getRequestDispatcher("Views/welcome.jsp").forward(request, response);
	        	
					}
	        	}
	        	else
	        	{
	        		request.setAttribute("error", "Invalid credientials");
	        		request.getRequestDispatcher("view/login.jsp").forward(request, response);
	        	}
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
			
	}

}
