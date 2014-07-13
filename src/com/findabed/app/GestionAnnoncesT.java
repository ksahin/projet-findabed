package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findabed.modeles.Annonce;
import com.findabed.modeles.Contenu;
import com.findabed.modeles.Ville;

/**
 * Servlet implementation class GestionAnnoncesT
 */
@WebServlet("/GestionAnnoncesT")
public class GestionAnnoncesT extends GestionAnnonces {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionAnnoncesT() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void redirection(HttpServletRequest request, HttpServletResponse response, 
			String page,ArrayList<Contenu<Annonce,Ville>> listeAnnonces,int idUser) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.print(listeAnnonces.get(0).getValeurT().getDescription()+idUser);
	}
}
