package com.simplilearn.workshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.simplilearn.workshop.domain.Airport;
import com.simplilearn.workshop.utils.HibernateUtils;

@WebServlet("/selectairports")
public class SelectAllPlacesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		
		try {

			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();			
			Criteria criteria = session.createCriteria(Airport.class);
			criteria.add(Restrictions.ge("id", 1));
			List results = criteria.list();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Places Table</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div align='left'>");
			out.println("<h3>Airport Repository contains the following:</h3>");
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>Airport Code</th>");
			out.println("<th>Airport Name</th>");			
			out.println("<th>Street</th>");
			out.println("<th>City</th>");
			out.println("<th>State</th>");
			out.println("<th>Country</th>");
			out.println("<th>ZipCode</th>");			
			out.println("</tr>");

			Iterator iterator = results.iterator();
			while (iterator.hasNext()) {

				Airport airport = (Airport) iterator.next();
				out.println("<tr>");
				out.println("<td>"+ airport.getCode()+"</td>");
				out.println("<td>"+ airport.getName()+"</td>");
				out.println("<td>"+ airport.getStreet()+"</td>");				
				out.println("<td>"+ airport.getCity()+"</td>");
				out.println("<td>"+ airport.getState()+"</td>");
				out.println("<td>"+ airport.getCountry()+"</td>");		
				out.println("<td>"+ airport.getZipCode()+"</td>");						
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
