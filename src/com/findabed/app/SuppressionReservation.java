package com.findabed.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findabed.modeles.Reservation;

/**
 * Servlet implementation class SuppressionReservation
 */
@WebServlet("/SuppressionReservation")
public class SuppressionReservation extends SuperServlet  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idReservation = Integer.parseInt(request.getParameter("idReservation"));
		Reservation reservation = new Reservation();
		reservation.setId(idReservation);
		try{
				reservation.supprimerParId();	
		} catch (SQLException e){
			request.setAttribute("message", "Une erreur est survenue veuillez reessayer");		
		}
		this.redirection(request, response, "/gestionReservations");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
