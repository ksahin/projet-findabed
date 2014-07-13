package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuppressionReservationT
 */
@WebServlet("/SuppressionReservationT")
public class SuppressionReservationT extends SuppressionReservation {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionReservationT() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void redirection(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		out.println("Suppression réussie");
	}

}
