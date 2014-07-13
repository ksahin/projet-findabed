package com.findabed.app;

import java.io.IOException;
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
 * Servlet implementation class VisualisationAnnonce
 */
@WebServlet("/VisualisationAnnonce")
public class VisualisationAnnonce extends SuperServlet  {

	/**
     * @see HttpServlet#HttpServlet()
     */
    public VisualisationAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Annonce ann = new Annonce();
		Ville ville = new Ville();
		try {
			int idAnnonce = Integer.parseInt(request.getParameter("idAnnonce"));
			ann.setId(idAnnonce);
			ann = ann.trouverAnnonceParId();
			ville = ville.chercherVilleParId(ann.getIdVille());
			request.setAttribute("ville", ville);
			request.setAttribute("annonce", ann);
		} catch (SQLException e){
			request.setAttribute("message", "Une erreur est survenue, veuillez reessayer");
		}
		if(!isSessionActive(request)) {
			this.redirection(request, response, JSPACCUEIL, ann);
		} else {
			this.redirection(request, response, JSPVISUALISERANNONCE, ann);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void redirection(HttpServletRequest request, HttpServletResponse response, String page, Annonce ann) 
			throws IOException, ServletException {
		this.getServletContext().getRequestDispatcher(JSPVISUALISATION).forward( request, response );
	}
	
}
