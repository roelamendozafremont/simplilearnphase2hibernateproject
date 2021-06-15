package com.simplilearn.workshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.workshop.domain.Iterenary;
import com.simplilearn.workshop.utils.HibernateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/insertiterenary")
public class InsertIterenarySqlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Read the parameter's from request
			String datestr = request.getParameter("DATE");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date1 = sdf.parse(datestr);
			String origin = request.getParameter("ORIGIN");
			String destination = request.getParameter("DESTINATION");
			Integer seats = Integer.parseInt(request.getParameter("SEATS"));
			String flight = request.getParameter("FLIGHT");
			Float fare = Float.parseFloat(request.getParameter("FARE"));
			
			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			
			Iterenary iterenary = new Iterenary(date1,origin,destination,seats,flight,fare);
			session.save(iterenary);
			session.getTransaction().commit();

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if (session.getStatistics().getEntityCount() > 0) {
				out.println("<h3>Iterenary Successfully Inserted with hibernate</h3>");
			} else {
				out.println("<h3>No Iterenary Record Inserted</h3>");
			}
			session.close();

		} catch ( ParseException e) {
			e.printStackTrace();
		}

	}

}
