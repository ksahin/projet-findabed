package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.findabed.modeles.Annonce;
import com.findabed.modeles.Ville;

/**
 * Servlet implementation class VisualisationAnnonceT
 */
@WebServlet("/VisualisationAnnonceT")
public class VisualisationAnnonceT extends VisualisationAnnonce {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualisationAnnonceT() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void redirection(HttpServletRequest request, HttpServletResponse response, String page, Annonce ann) 
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.print(ann.getDescription());
	}
	

	
}
