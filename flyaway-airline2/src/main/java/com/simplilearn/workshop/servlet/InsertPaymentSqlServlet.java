package com.simplilearn.workshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.workshop.domain.Payment;
import com.simplilearn.workshop.utils.HibernateUtils;

@WebServlet("/insertpayment")
public class InsertPaymentSqlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Read the parameter's from request
			String firstname = request.getParameter("BFNAME");
			String middlename = request.getParameter("BMNAME");
			String lastname = request.getParameter("BLNAME");
			String cardnum = request.getParameter("BCARDNUM");
			String cardexp = request.getParameter("BCARDEXP");
			String cardcvc = request.getParameter("BCARDCVC");

			long millis = System.currentTimeMillis();
			java.util.Date date = new java.util.Date(millis);

			String fareStr = extractCookie(request,"fare");
			Float fare = Float.parseFloat(fareStr);
			String booking = extractCookie(request,"bookingnumber");

			String bstreet = request.getParameter("BSTREET");
			String bcity = request.getParameter("BCITY");
			String bstate = request.getParameter("BSTATE");
			String bcountry = request.getParameter("BCOUNTRY");
			String bzipcode = request.getParameter("BZIPCODE");

			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();

			Payment payment = new Payment(date, firstname, middlename, lastname, cardnum, cardexp, cardcvc, bstreet,
					bcity, bstate, bcountry, bzipcode, fare, booking);

			session.save(payment);
			session.getTransaction().commit();

			if (session.getStatistics().getEntityCount() > 0) {
				showCustomerBooking(request, response, cardnum, booking);
			} else {
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<h3>No Payment Record Inserted</h3>");
			}

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void showCustomerBooking(HttpServletRequest request, HttpServletResponse response, String cardNumber,
			String bookingNumber) throws ServletException, IOException {

		try {

			String date = extractCookie(request,"flightDate");
			String origin = extractCookie(request,"origin");
			String destination = extractCookie(request,"destination");
			String flight = extractCookie(request,"flight");
			String fareStr = extractCookie(request,"fare");
			String fname = extractCookie(request,"firstname");
			String mname = extractCookie(request,"middlename");
			String lname = extractCookie(request,"lastname");

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Customer Booking Ticket</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div align='left'>");
			out.println("<h3>Card Payment " + cardNumber + " Successfully Charged with hibernate</h3>");
			out.println("<h3>See Booking Details below:</h3>");
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<td>Flight Date  : </td>");
			out.println("<td>" + date + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Origin Airport  : </td>");
			out.println("<td>" + origin.toUpperCase() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Destination Airport  : </td>");
			out.println("<td>" + destination.toUpperCase() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Flight Code  : </td>");
			out.println("<td>" + flight + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Fare Price  : </td>");
			out.println("<td>" + fareStr + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Booking Number  : </td>");
			out.println("<td>" + bookingNumber + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>First Name  : </td>");
			out.println("<td>" + fname.toUpperCase() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Middle Name  : </td>");
			out.println("<td>" + mname.toUpperCase() + "'</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Last Name  : </td>");
			out.println("<td>" + lname.toUpperCase() + "</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String extractCookie(HttpServletRequest req, String myCookie) {
        for (Cookie c : req.getCookies()) {
           if (c.getName().equals(myCookie))
               return c.getValue();
           }
        return null;
    }

}
