package com.findabed.app;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findabed.modeles.User;

import java.io.*;
import java.sql.Connection;

/**
 * Servlet implementation class FormulaireInscription
 */
@WebServlet("/FormulaireInscription")
public class FormulaireInscription extends SuperServlet  {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormulaireInscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.getServletContext().getRequestDispatcher(JSPINSCRIPTION).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User user = new User(request);
			if(!user.estPresentDansBase("mail",request.getParameter("mail"))){
				try{
				user.inserer();
				request.setAttribute("message","Inscription reussie");
				request.setAttribute("messageType", "succes");
				} catch (SQLException e){
					request.setAttribute("message", "Une erreur est survenue veuilez ressayer.");
				}
				this.redirection(request, response, JSPACCUEIL);
            }
            else
            {
    			request.setAttribute("message","Un utilisateur est déjà  inscrit avec cet email");
    			this.redirection(request, response, JSPINSCRIPTION);
            }
	}
	
}
