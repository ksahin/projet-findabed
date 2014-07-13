package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.findabed.modeles.User;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends SuperServlet  {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		redirection(request, response, JSPACCUEIL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userRequete = new User();
		String resultat = "";
		userRequete.setMail(request.getParameter("mail"));
		userRequete.setMotdepasse(User.crypter(request.getParameter("motdepasse")));
		try {
				User userBase = userRequete.trouverUserParMail();
				resultat = testChampsFormulaire(userRequete,userBase);
				if (resultat.equals("Bienvenue")){
					this.ouvrirSession(userBase, request);
					request.setAttribute("messageType", "succes");
				} 
		} catch (SQLException e){ 
			request.setAttribute("message", "Une erreur est survenue, veuillez reessayer");
		}
		this.redirection(request, response, resultat,JSPACCUEIL);
	}
	
	private String testChampsFormulaire(User userRequete,User userBase){
		String message = "";
		if(userBase == null) message = "Mail incorrect";
		else {
			if(!this.estMotdepasseEgal(userBase,userRequete)) message = "Mot de passe incorrect";
			else {
				if(this.estMailEgal(userRequete, userBase) 
						&& this.estMotdepasseEgal(userRequete, userBase)) message = "Bienvenue";
			}	
		}
		return message;
	}
	
	
	private void ouvrirSession(User user,HttpServletRequest request){
		HttpSession session = request.getSession(true);
		session.setAttribute("nom", user.getNom());
		session.setAttribute("prenom", user.getPrenom());
		session.setAttribute("mail", user.getMail());
		session.setAttribute("id", user.getId());
		session.setAttribute("adresse", user.getAdresse());
		session.setAttribute("telephone", user.getTelephone());
		session.setAttribute("ville", user.getIdVille());
		session.setAttribute("connecte","connecte");	
	}
	
	
	private boolean estMailEgal(User user1,User user2){
		return user1.getMail().equals(user2.getMail());
	}
	private boolean estMotdepasseEgal(User user1,User user2){
		return user1.getMotdepasse().equals(user2.getMotdepasse());
	}
	
	public void redirection (HttpServletRequest request,HttpServletResponse response, String message,String adresse) throws IOException,ServletException{
			request.setAttribute("message",message);
			this.getServletContext().getRequestDispatcher(adresse).forward( request, response );
	}
}
