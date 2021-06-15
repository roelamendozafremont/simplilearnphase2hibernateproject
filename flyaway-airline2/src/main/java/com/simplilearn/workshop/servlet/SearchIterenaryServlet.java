package com.simplilearn.workshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Map;

import com.simplilearn.workshop.domain.Iterenary;
import com.simplilearn.workshop.utils.HibernateUtils;
import com.simplilearn.workshop.utils.MySQLDatabaseUtils;

@WebServlet("/searchiterenary")
public class SearchIterenaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		
		try {
			
			String datestr = request.getParameter("DATE");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date1 = sdf.parse(datestr);
			//java.sql.Date date2 = new java.sql.Date(date1.getTime());
			String origin = request.getParameter("ORIGIN");
			String destination = request.getParameter("DESTINATION");
			String seatstr = request.getParameter("SEATS");

			Cookie flightTimeData = new Cookie("flightDate", datestr);
			response.addCookie(flightTimeData);
			Cookie originData = new Cookie("origin", origin);
			response.addCookie(originData);
			Cookie destinationData = new Cookie("destination", destination);
			response.addCookie(destinationData);
			
			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();			
			Criteria criteria = session.createCriteria(Iterenary.class);			
			criteria.add(Restrictions.ge("flightDate", date1));
			if (origin.trim().isEmpty()) {
				criteria.add(Restrictions.ge("origin", origin));
			} else {
				criteria.add(Restrictions.eq("origin", origin.toUpperCase()));
			}
			if (destination.trim().isEmpty()) {
				criteria.add(Restrictions.ge("destination", destination));
			} else {
				criteria.add(Restrictions.eq("destination", destination.toUpperCase()));
			}
			criteria.add(Restrictions.ge("seatsAvailable", Integer.parseInt(seatstr)));
			List results = criteria.list();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Iterenaries Table</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>simplilearn available flights with hibernate:</h3>");
			out.println("<div align='left'>");
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
				out.println("<td>"+iterenary.getFlightDate()+"</td>");
				out.println("<td>"+iterenary.getOrigin()+"</td>");
				out.println("<td>"+iterenary.getDestination()+"</td>");
				out.println("<td>"+iterenary.getSeatsAvailable()+"</td>");
				out.println("<td>"+iterenary.getAirline()+"</td>");
				out.println("<td>"+iterenary.getFare()+"</td>");				
				out.println("</tr>");
				
				Cookie flightdata = new Cookie("flight", iterenary.getAirline());
				response.addCookie(flightdata);
				Cookie fareData = new Cookie("fare", String.valueOf(iterenary.getFare()));
				response.addCookie(fareData);
			}

			out.println("</table>");
			out.println("</div>");
			out.println("</br>");
			out.println("<div align='left'>");		
			out.println("<a href='insertcustomer.html'><button>Book Now</button></a>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");		
			session.close();

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
