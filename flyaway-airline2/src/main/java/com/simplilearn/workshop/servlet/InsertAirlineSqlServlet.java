package com.simplilearn.workshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.workshop.domain.Airline;
import com.simplilearn.workshop.utils.HibernateUtils;

@WebServlet("/insertairline")
public class InsertAirlineSqlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Read the parameter's from request
			String code = request.getParameter("CODE");
			String name = request.getParameter("NAME");
			String plane = request.getParameter("PLANE");
			String seats = request.getParameter("SEATS");
			
			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			Airline airline = new Airline(code,name,plane,Integer.parseInt(seats));
			session.save(airline);
			session.getTransaction().commit();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if (session.getStatistics().getEntityCount() > 0) {
				out.println("<h3>Airline Successfully Inserted with hibernate</h3>");
			} else {
				out.println("<h3>No Airline Record Inserted</h3>");
			}
			session.close();
			
		} catch (Exception  e) {
			e.printStackTrace();
		}

	}

}
