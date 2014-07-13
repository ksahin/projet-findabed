package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findabed.modeles.Reservation;

/**
 * Servlet implementation class ReservationAnnonceT
 */
@WebServlet("/ReservationAnnonceT")
public class ReservationAnnonceT extends ReservationAnnonce {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationAnnonceT() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void redirection(HttpServletRequest request, HttpServletResponse response, String page,Reservation reservation) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		out.println(reservation.getIdAnnonce()+reservation.getIdUser());
	}

}
