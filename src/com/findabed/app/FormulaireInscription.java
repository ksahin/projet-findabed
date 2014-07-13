package com.findabed.app;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;

/**
 * Servlet implementation class FormulaireInscription
 */
@WebServlet("/FormulaireInscription")
public class FormulaireInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final boolean EN_TEST = false;
	
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
		 this.getServletContext().getRequestDispatcher( "/WEB-INF/inscriptionBS.jsp").forward( request, response );
		PrintWriter out = response.getWriter();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User user = new User(request);
			if(!user.estPresentDansBase("mail",request.getParameter("mail"))){
			user.inserer();
			request.setAttribute("message","Inscription reussie");
			request.setAttribute("messageType", "succes");
			 if (!EN_TEST) this.getServletContext().getRequestDispatcher( "/WEB-INF/accueilBS.jsp").forward( request, response );
            }
            else
            {
    			request.setAttribute("message","Un utilisateur est déjà inscrit avec cet email");
    			if (!EN_TEST) this.getServletContext().getRequestDispatcher( "/WEB-INF/inscriptionBS.jsp").forward( request, response );
            }
	} 
	}
