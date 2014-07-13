package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findabed.modeles.Annonce;
import com.findabed.modeles.User;
import com.findabed.modeles.Ville;

/**
 * Servlet implementation class DetailsAnnonceT
 */
@WebServlet("/DetailsAnnonceT")
public class DetailsAnnonceT extends DetailsAnnonce {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsAnnonceT() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void redirection(HttpServletRequest request, HttpServletResponse response,String page, 
			Annonce annonce, Ville ville,User user) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.print(ville.getNom());
		out.print(annonce.getIdVille());
		out.print(annonce.getDescription());
		out.print(user.getMail());
	}

}
