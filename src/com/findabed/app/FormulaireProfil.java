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

import com.findabed.modeles.User;
import com.findabed.modeles.Ville;

/**
 * Servlet implementation class FormulaireModifierAnnonce
 */
@WebServlet("/FormulaireProfil")
public class FormulaireProfil extends SuperServlet  {
	private static final long serialVersionUID = 1L;
	private final boolean ENTEST = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormulaireProfil() {
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
			int idUser = (int) request.getSession().getAttribute("id");		
			User us = new User();
			us.setIdUSER(idUser);
			try {
				User us1 = us.trouverUserParId();
				Ville ville = new Ville();
				ville = ville.chercherVilleParId(us1.getIdVille());
				request.setAttribute("ville", ville);
				request.setAttribute("user", us1);
			} catch (SQLException e){
				request.setAttribute("message", "une erreur est survenue, veuillez reessayer");
			}
			redirection(request,response,JSPPROFIL);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User us2 = new User(request);
		us2.setIdUSER(Integer.parseInt((request.getParameter("iduser"))));
		us2.setIdVille(Integer.parseInt((request.getParameter("idville"))));
		String message = "";
		try{
			boolean changerMdp = !request.getParameter("motdepasse").isEmpty();
			us2.update(changerMdp);
			request.setAttribute("messageType", "succes");
			message = "Votre profil a bien été modifé";
		} catch (SQLException e) {
			message = "Une erreur est survenue, veuillez reessayer";
		}
		
		this.redirection(message, request, response, us2);
	}
	

	
	public void redirection(String message, HttpServletRequest request, HttpServletResponse response, User user) throws IOException, ServletException {
			request.setAttribute("message",message);
			this.getServletContext().getRequestDispatcher(JSPACCUEIL).forward(request, response);
	} 
}
