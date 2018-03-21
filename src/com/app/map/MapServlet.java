package com.app.map;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.app.job.company;
import com.app.registration.AboutUsService;
import com.google.gson.Gson;

/**
 * Servlet implementation class MapServlet
 */
@WebServlet("/map.do")
public class MapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/onlinerecruiter")
    private DataSource ds;
	Connection conn;   
	private static List<company> companyList = new ArrayList<company>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			conn = ds.getConnection();
			
			
			int uid=(int)request.getSession().getAttribute("user_id");
			AboutUsService service= new AboutUsService();
			List<company> comps=service.getListOfCompanys(conn);
			
			Gson gson = new Gson();
            String json = gson.toJson(comps);
            System.out.println(json);

			request.setAttribute("data", json);
		    request.getRequestDispatcher("view/mapLoc.jsp").forward(request, response);
			
		
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String description=request.getParameter("description");
	}

}
