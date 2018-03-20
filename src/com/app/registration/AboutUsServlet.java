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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

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
		
		int id=(int)request.getSession().getAttribute("user_id");
		
		
		try
		{
			conn=ds.getConnection();
			GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyCHhAxEqUUzSdNMb8SZibp-G0WlZvrdr_g").build();
			GeocodingResult[] results =  GeocodingApi.geocode(context,address).await();
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String lat=gson.toJson(results[0].geometry.location.lat);
				String lng=gson.toJson(results[0].geometry.location.lng);
				System.out.println("lat : "+lat);
			boolean insert=companyDetails.isCompanyRegistered(id,name, address, description,lat,lng,conn);
			if(!insert)
			{
				request.setAttribute("msg", "success");
				request.setAttribute("success", "Company details added.");
				request.getRequestDispatcher("view/aboutus.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "error");
				request.setAttribute("error", "Error in adding");
				request.getRequestDispatcher("view/aboutus.jsp").forward(request, response);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

}
}