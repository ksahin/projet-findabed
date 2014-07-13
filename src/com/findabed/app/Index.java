package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Database db = new Database();

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
		 this.getServletContext().getRequestDispatcher( "/WEB-INF/accueilBS.jsp").forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		User user = new User(request);
		User userbase = user.trouverUserParMail();
		String resultat = testChampsFormulaire(user);
		if (resultat.equals("Bienvenue"))
		{
			
			HttpSession session = request.getSession(true);
			session.setAttribute("nom", userbase.getNom());
			session.setAttribute("prenom", userbase.getPrenom());
			session.setAttribute("mail", userbase.getMail());
			session.setAttribute("connecte", true);	
			request.setAttribute("messageType", "succes");
		}
		request.setAttribute("message",resultat);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/accueilBS.jsp").forward( request, response );
	}
	
	public String testChampsFormulaire( User user){
		String message = "";
		if(user.trouverUserParMail() == null)
			message = "Mail incorrect";
		
		else{
			
			String bonMail = user.trouverUserParMail().getMail();
			String bonMDP = user.trouverUserParMail().getMotdepasse();
			if(!user.getMotdepasse().equals(bonMDP))
				message="Mot de passe incorrect";
			else{
				if(user.getMail().equals(bonMail) && user.getMotdepasse().equals(bonMDP))
					message = "Bienvenue";
			}	
		}
		return message;
	}
}
