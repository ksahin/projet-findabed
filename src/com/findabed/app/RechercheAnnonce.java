package com.findabed.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.findabed.modeles.Annonce;
import com.findabed.modeles.Ville;

/**
 * Servlet implementation class RechercheAnnonce
 */
@WebServlet("/RechercheAnnonce")
public class RechercheAnnonce extends SuperServlet  {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!this.isSessionActive(request)) {
			this.redirection(request, response,JSPACCUEIL);
		} else {
			this.redirection(request, response, JSPRECHERCHEANNONCE);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Annonce ann = new Annonce();
			ArrayList<Annonce> listeAnnonce = new ArrayList<Annonce>();
			try {
			listeAnnonce = ann.chercherAnnonceParVille((request.getParameter("nomVille")),
					request.getParameter("date"));
			if(listeAnnonce.isEmpty())
				request.setAttribute("message", "Aucune annonce trouvée pour ces critères");
			else{
				request.setAttribute("listeAnnonces", listeAnnonce);
			}
			request.setAttribute("ville", (request.getParameter("nomVille")));
			request.setAttribute("villeId", new Ville());
			request.setAttribute("date", request.getParameter("date"));
		} catch (SQLException e){
			request.setAttribute("message", "Une erreur est survenue, veuillez reessayer");
		} 
		
		this.redirection(request, response, JSPRECHERCHEANNONCE);
	}	
	
}
