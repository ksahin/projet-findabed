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
import com.findabed.modeles.User;
import com.findabed.modeles.Ville;

/**
 * Servlet implementation class DétailsAnnonce
 */
@WebServlet("/DétailsAnnonce")
public class DetailsAnnonce extends SuperServlet  {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAnnonce =Integer.parseInt(request.getParameter("idAnnonce"));
		Annonce ann = new Annonce();
		Ville ville = new Ville();
		User user = new User();
		ann.setId(idAnnonce);
		try{
			ann = ann.trouverAnnonceParId(); 
			ville = ville.chercherVilleParId(ann.getIdVille());
			user.setIdUSER(ann.getIdUser());
			user = user.trouverUserParId();
		} catch (SQLException e) {
			request.setAttribute("message", "Une erreur est survenue, veuillez reessayer");
		}
		if(!this.isSessionActive(request)){
				this.redirection(request, response, JSPACCUEIL, ann, ville, user);
			} else{
				
				this.redirection(request, response, JSPDETAILANNONCE, ann, ville, user);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
		
	
	
	public void redirection(HttpServletRequest request, HttpServletResponse response,String page, 
			Annonce annonce, Ville ville,User user) throws IOException, ServletException {
		request.setAttribute("ville", ville);
		request.setAttribute("user", user);
		request.setAttribute("annonce", annonce);
		this.getServletContext().getRequestDispatcher(page).forward( request, response );
	}

}
