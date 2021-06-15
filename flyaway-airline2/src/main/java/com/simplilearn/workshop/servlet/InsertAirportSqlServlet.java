package com.simplilearn.workshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.workshop.domain.Airport;
import com.simplilearn.workshop.utils.HibernateUtils;

@WebServlet("/insertairport")
public class InsertAirportSqlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Read the parameter's from request
			String code = request.getParameter("CODE");
			String name = request.getParameter("NAME");			
			String street = request.getParameter("STREET");
			String city = request.getParameter("CITY");
			String state = request.getParameter("STATE");
			String country = request.getParameter("COUNTRY");
			String zipcode = request.getParameter("ZIPCODE");
			
			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			Airport airport = new Airport(code, name, street,city,state,country,zipcode);
			session.save(airport);
			session.getTransaction().commit();

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if (session.getStatistics().getEntityCount() > 0) {
				out.println("<h3>Airport Successfully Inserted with hibernate</h3>");
			} else {
				out.println("<h3>No Airport Record Inserted</h3>");
			}
			session.close();
			
		} catch (Exception  e) {
			e.printStackTrace();
		}

	}

}
