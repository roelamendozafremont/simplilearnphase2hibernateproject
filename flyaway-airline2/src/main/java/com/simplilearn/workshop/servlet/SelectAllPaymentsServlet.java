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

import com.simplilearn.workshop.domain.Payment;
import com.simplilearn.workshop.utils.HibernateUtils;

@WebServlet("/selectpayments")
public class SelectAllPaymentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {

			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();			
			Criteria criteria = session.createCriteria(Payment.class);
			criteria.add(Restrictions.ge("id", 1));
			List results = criteria.list();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Booking Payments Table</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div align='left'>");
			out.println("<h3>Booking Payments Repository contains the following:</h3>");
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>Bill Date</th>");
			out.println("<th>First Name</th>");			
			out.println("<th>Middle Name</th>");	
			out.println("<th>Last Name</th>");	
			out.println("<th>Card Number</th>");
			out.println("<th>Card Expiration</th>");
			out.println("<th>Street</th>");			
			out.println("<th>City</th>");	
			out.println("<th>State</th>");
			out.println("<th>Country</th>");
			out.println("<th>ZipCode</th>");
			out.println("<th>Bill Amount</th>");
			out.println("<th>Booking Number</th>");			
			out.println("</tr>");

			Iterator iterator = results.iterator();
			while (iterator.hasNext()) {

				Payment payment = (Payment) iterator.next();
				out.println("<tr>");
				out.println("<td>"+ payment.getBillDate()+"</td>");
				out.println("<td>"+ payment.getFirstName()+"</td>");
				out.println("<td>"+ payment.getMiddleName()+"</td>");
				out.println("<td>"+ payment.getLastName()+"</td>");
				out.println("<td>"+ payment.getCardNumber()+"</td>");
				out.println("<td>"+ payment.getExpirationDate()+"</td>");
				out.println("<td>"+ payment.getCvcCode()+"</td>");		
				out.println("<td>"+ payment.getStreet()+"</td>");	
				out.println("<td>"+ payment.getCity()+"</td>");
				out.println("<td>"+ payment.getState()+"</td>");
				out.println("<td>"+ payment.getCountry()+"</td>");
				out.println("<td>"+ payment.getZipCode()+"</td>");
				out.println("<td>"+ payment.getAmount()+"</td>");
				out.println("<td>"+ payment.getBookingNumber()+"</td>");				
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
