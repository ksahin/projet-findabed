package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.meterware.pseudoserver.HttpRequest;

/**
 * Servlet implementation class Publication
 */
@WebServlet("/Publication")
public class Publication extends SuperServlet  {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Publication() {
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
			try {
				request.setAttribute("ville",this.rechercherVille((int) request.getSession().getAttribute("ville")));
			} catch (SQLException e){
				request.setAttribute("message","une erreur est srvenue, veuillez reessayer");
			}
			this.getServletContext().getRequestDispatcher(JSPPUBLICATION).forward( request, response );
		}
	}  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Annonce annonce;
		if (!this.isSessionActive(request)){
			annonce = new Annonce(request, Integer.parseInt(request.getParameter("idUser")));
		} else {
			annonce = new Annonce(request, (int)request.getSession().getAttribute("id"));
		}
		String message = "";
		try {
			annonce.inserer();
			request.setAttribute("messageType", "succes");
			message = "Votre annonce a bien été publiée";
		}catch (SQLException e) {
			message = "Une erreur est survenue, veuillez reessayer";
		}
		this.redirection(message, request, response, annonce); 
		
	}
	
	public void redirection(String message, HttpServletRequest request, HttpServletResponse response, Annonce annonce) throws IOException, ServletException {
			request.setAttribute("message",message);
			request.setAttribute("annonce",annonce);
			try {
				request.setAttribute("ville", this.rechercherVille(annonce.getIdVille()));
			} catch (SQLException e){
			}
			this.getServletContext().getRequestDispatcher(JSPVISUALISATION).forward( request, response );
	}
	
	private Ville rechercherVille(int idVille) throws SQLException{
		Ville ville = new Ville();
		ville = ville.chercherVilleParId(idVille);
		return ville;		
	}

}
