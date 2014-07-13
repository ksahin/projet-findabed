package com.findabed.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RechercheAnnonceT
 */
@WebServlet("/RechercheAnnonceT")
public class RechercheAnnonceT extends RechercheAnnonce {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheAnnonceT() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void redirection(HttpServletRequest request, HttpServletResponse response, String page) throws IOException, ServletException {

    }

}
