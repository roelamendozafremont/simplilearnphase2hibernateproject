package com.simplilearn.workshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.simplilearn.workshop.domain.CustomerBooking;
import com.simplilearn.workshop.domain.Iterenary;
import com.simplilearn.workshop.utils.HibernateUtils;
import com.simplilearn.workshop.utils.MySQLDatabaseUtils;

@WebServlet("/selectiterenaries")
public class SelectAllIterenariesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		try {

			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();			
			Criteria criteria = session.createCriteria(Iterenary.class);
			criteria.add(Restrictions.ge("id", 1));
			List results = criteria.list();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Iterenaries Table</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div align='left'>");
			out.println("<h3>Flight Itirenaries Repository contains the following:</h3>");
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>Flight Date</th>");
			out.println("<th>Origin Airport</th>");
			out.println("<th>Destination Airport</th>");
			out.println("<th>Seats Available</th>");
			out.println("<th>Flight Code</th>");
			out.println("<th>Fare Price</th>");			
			out.println("</tr>");

			Iterator iterator = results.iterator();
			while (iterator.hasNext()) {

				Iterenary iterenary = (Iterenary) iterator.next();				
				out.println("<tr>");
				out.println("<td>"+ iterenary.getFlightDate()+"</td>");
				out.println("<td>"+ iterenary.getOrigin()+"</td>");
				out.println("<td>"+ iterenary.getDestination()+"</td>");
				out.println("<td>"+ iterenary.getSeatsAvailable()+"</td>");
				out.println("<td>"+ iterenary.getAirline()+"</td>");
				out.println("<td>"+ iterenary.getFare()+"</td>");				
				out.println("</tr>");
				
			}
			
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			session.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
