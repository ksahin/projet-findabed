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
 * Servlet implementation class FormulaireModifierAnnonce
 */
@WebServlet("/FormulaireModifierAnnonce")
public class FormulaireModifierAnnonce extends SuperServlet  {
	private static final long serialVersionUID = 1L;
	private final boolean ENTEST = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormulaireModifierAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!this.isSessionActive(request)) {
				redirection(request,response,JSPACCUEIL);
		} else {
			try{
					int idAnnonce = Integer.parseInt(request.getParameter("idAnnonce"));
					Annonce ann = new Annonce();
					ann.setId(idAnnonce);
					Annonce ann1 = ann.trouverAnnonceParId();
					Ville ville = new Ville();
					ville = ville.chercherVilleParId(ann1.getIdVille());
					request.setAttribute("ville", ville);
					request.setAttribute("annonce", ann1); 
			} catch (SQLException e){
				request.setAttribute("message", "Une erreur est survenue, veuillez ressayer"); 
			}
			redirection(request,response,JSPMODIF);
		} 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Annonce ann2 = new Annonce(request);
		ann2.setId(Integer.parseInt((request.getParameter("idAnnonce"))));
		String message = "";
		try {
			ann2.update();
			request.setAttribute("messageType", "succes");
			message = "Votre annonce a bien été modifée";
		} catch (SQLException e){
			message = "Une erreur est survenue, veuillez reessayer";
		}
		this.redirection(message, request, response, ann2);
	}
	
	
	public void redirection(String message, HttpServletRequest request, HttpServletResponse response, Annonce annonce) throws IOException, ServletException {
			request.setAttribute("message",message);
			response.sendRedirect("/FindAbed/gestionAnnonces");
	}
	
}
