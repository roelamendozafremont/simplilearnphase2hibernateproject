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

import com.simplilearn.workshop.domain.Airline;
import com.simplilearn.workshop.utils.HibernateUtils;

@WebServlet("/selectairlines")
public class SelectAllAirlinesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		
		try {

			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();			
			Criteria criteria = session.createCriteria(Airline.class);
			criteria.add(Restrictions.ge("id", 1));
			List results = criteria.list();

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Airlines Table</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div align='left'>");
			out.println("<h3>Airline Repository contains the following:</h3>");
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>Flight Code</th>");
			out.println("<th>Airline Name</th>");
			out.println("<th>Aircraft Type</th>");
			out.println("<th>Seats Capacity</th>");			
			out.println("</tr>");

			Iterator iterator = results.iterator();
			while (iterator.hasNext()) {

				Airline airline = (Airline) iterator.next();
				out.println("<tr>");
				out.println("<td>"+ airline.getCode()+"</td>");
				out.println("<td>"+ airline.getName()+"</td>");
				out.println("<td>"+ airline.getPlaneType()+"</td>");
				out.println("<td>"+ airline.getSeatCapacity()+"</td>");				
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
