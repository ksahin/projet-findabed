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

/**
 * Servlet implementation class SuppressionAnnonce
 */
@WebServlet("/SuppressionAnnonce")
public class SuppressionAnnonce extends SuperServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!this.isSessionActive(request)) {
			this.getServletContext().getRequestDispatcher(JSPACCUEIL).forward( request, response );
		} else {
			Annonce annonceAsupprimer = new Annonce();
			annonceAsupprimer.setId(Integer.parseInt(request.getParameter("idAnnonce")));
			try {
				annonceAsupprimer.supprimerAnnonceParId();
				request.setAttribute("messageType", "succes");
				request.setAttribute("message", "Votre annonce a bien été supprimmsée");
			} catch (SQLException e) {
				request.setAttribute("message", "Une erreur est survenue veuillez reessayer");
			}
			
			this.redirection(request, response,"/gestionAnnonces");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
