package com.findabed.app;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.findabed.modeles.Reservation;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/Reservation")
public class ReservationAnnonce extends SuperServlet  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUser;
		if (this.isSessionActive(request)){
			idUser = (int) request.getSession().getAttribute("id");
		} else {
			idUser = Integer.parseInt(request.getParameter("idUser"));
		}
		int idAnnonce = Integer.parseInt(request.getParameter("idAnnonce"));
		Reservation reservation = new Reservation();
		reservation.setIdUser(idUser);
		reservation.setIdAnnonce(idAnnonce);
		try{
				reservation.inserer();
				request.setAttribute("messageType", "succes");
				request.setAttribute("message","La réservation est effectuée.");
		}catch (SQLException e){
			request.setAttribute("message","Un problème est survenu, veuillez réessayer");
		}
		this.redirection(request, response, "/gestionReservations",reservation);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void redirection(HttpServletRequest request, HttpServletResponse response, String page,Reservation reservation) throws IOException, ServletException{
		this.getServletContext().getRequestDispatcher(page).forward(request, response);
	}
	
}
