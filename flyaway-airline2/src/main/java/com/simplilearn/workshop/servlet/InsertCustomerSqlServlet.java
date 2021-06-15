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

import com.simplilearn.workshop.domain.CustomerBooking;
import com.simplilearn.workshop.utils.HibernateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/insertcustomer")
public class InsertCustomerSqlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Read the parameter's from request
			String firstname = request.getParameter("FNAME");
			String middlename = request.getParameter("MNAME");
			String lastname = request.getParameter("LNAME");
			String phone = request.getParameter("PHONE");
			String email = request.getParameter("EMAIL");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date1 = sdf.parse(extractCookie(request, "flightDate"));
			String origin = extractCookie(request, "origin");
			String destination = extractCookie(request, "destination");
			String flight = extractCookie(request, "flight");
			String fareStr = extractCookie(request, "fare");

			Integer age = Integer.parseInt(request.getParameter("AGE"));
			String sex = request.getParameter("SEX");
			String street = request.getParameter("STREET");
			String city = request.getParameter("CITY");
			String state = request.getParameter("STATE");
			String country = request.getParameter("COUNTRY");
			String zipcode = request.getParameter("ZIPCODE");

			Cookie fnameData = new Cookie("firstname", firstname);
			response.addCookie(fnameData);
			Cookie mnameData = new Cookie("middlename", middlename);
			response.addCookie(mnameData);
			Cookie lnameData = new Cookie("lastname", lastname);
			response.addCookie(lnameData);

			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();

			CustomerBooking customerBooking = new CustomerBooking(date1, origin, destination, firstname, middlename,
					lastname, phone, email, age, sex, street, city, state, country, zipcode, flight);

			Cookie bkgNumData = new Cookie("bookingnumber", customerBooking.getBookingNumber());
			response.addCookie(bkgNumData);

			session.save(customerBooking);
			session.getTransaction().commit();

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if (session.getStatistics().getEntityCount() > 0) {
				out.println("<h3>Customer " + firstname + " " + middlename + " " + lastname
						+ " Successfully Inserted with hibernate</h3>");
			} else {
				out.println("<h3>No Customer Record Inserted</h3>");
			}

			out.println("<a href='insertcustomer.html'><button>Book Another</button></a>");
			out.println("<a href='paybookingnow.html'><button>Pay Now</button></a>");

		} catch (ParseException e) {
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
