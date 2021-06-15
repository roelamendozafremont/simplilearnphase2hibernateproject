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

import com.simplilearn.workshop.domain.CustomerBooking;
import com.simplilearn.workshop.utils.HibernateUtils;

@WebServlet("/selectcustomerbookings")
public class SelectAllCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		try {

			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();			
			Criteria criteria = session.createCriteria(CustomerBooking.class);
			criteria.add(Restrictions.ge("id", 1));
			List results = criteria.list();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Customer Bookings Table</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div align='left'>");
			out.println("<h3>Customer Booking Repository contains the following:</h3>");
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>Flight Date</th>");
			out.println("<th>First Name</th>");			
			out.println("<th>Middle Name</th>");	
			out.println("<th>Last Name</th>");	
			out.println("<th>Phone Number</th>");
			out.println("<th>Email Address</th>");
			out.println("<th>Origin Airport</th>");
			out.println("<th>Destination Airport</th>");
			out.println("<th>Age</th>");
			out.println("<th>Sex</th>");
			out.println("<th>Street</th>");			
			out.println("<th>City</th>");	
			out.println("<th>State</th>");
			out.println("<th>Country</th>");
			out.println("<th>ZipCode</th>");
			out.println("<th>Flight Code</th>");
			out.println("<th>Booking Number</th>");			
			out.println("</tr>");

			Iterator iterator = results.iterator();
			while (iterator.hasNext()) {

				CustomerBooking booking = (CustomerBooking) iterator.next();				
				out.println("<tr>");
				out.println("<td>"+ booking.getFlightDate()+"</td>");
				out.println("<td>"+ booking.getFirstName()+"</td>");
				out.println("<td>"+ booking.getMiddleName()+"</td>");
				out.println("<td>"+ booking.getLastName()+"</td>");
				out.println("<td>"+ booking.getPhoneNumber()+"</td>");
				out.println("<td>"+ booking.getEmailId()+"</td>");
				out.println("<td>"+ booking.getOrigin()+"</td>");
				out.println("<td>"+ booking.getOrigin()+"</td>");
				out.println("<td>"+ booking.getAge()+"</td>");
				out.println("<td>"+ booking.getSex()+"</td>");
				out.println("<td>"+ booking.getStreet()+"</td>");		
				out.println("<td>"+ booking.getCity()+"</td>");
				out.println("<td>"+ booking.getState()+"</td>");
				out.println("<td>"+ booking.getCountry()+"</td>");
				out.println("<td>"+ booking.getZipCode()+"</td>");
				out.println("<td>"+ booking.getFlightCode()+"</td>");
				out.println("<td>"+ booking.getBookingNumber()+"</td>");				
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
