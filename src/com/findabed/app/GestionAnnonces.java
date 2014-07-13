package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.findabed.modeles.Annonce;
import com.findabed.modeles.Contenu;
import com.findabed.modeles.Ville;

/**
 * Servlet implementation class GestionAnnonces
 */
@WebServlet("/GestionAnnonces")
public class GestionAnnonces extends SuperServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionAnnonces() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUser;
		if (isSessionActive(request)){
			idUser = (int) request.getSession().getAttribute("id");
		} else {
			idUser = Integer.parseInt(request.getParameter("idUser"));
		}
		Annonce annonce = new Annonce();
		ArrayList<Contenu<Annonce,Ville>> listeContenuAnnonces = new ArrayList<Contenu<Annonce,Ville>>();
		try{
			ArrayList<Annonce> listeAnnonces = annonce.rechercheParIdUser(idUser);
			for(Annonce a : listeAnnonces){
				listeContenuAnnonces.add(this.rechercherContenuAnnonce(a));
			}
		}catch (SQLException e){
			request.setAttribute("message", "Un problème est survenu, veuillez réessayer ");
		}
		this.redirection (request, response,JSPGESTIONANNONCES,listeContenuAnnonces,idUser);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	public void redirection(HttpServletRequest request, HttpServletResponse response, 
			String page,ArrayList<Contenu<Annonce,Ville>> listeAnnonces,int idUser) throws IOException, ServletException {
		request.setAttribute("listeAnnonces", listeAnnonces);
		this.getServletContext().getRequestDispatcher(page).forward( request, response );
	}
	
	public Contenu<Annonce,Ville> rechercherContenuAnnonce(Annonce a) throws SQLException{
		Contenu<Annonce,Ville> contenu = new Contenu<Annonce,Ville>();
		contenu.setValeurT(a);
		Ville ville = new Ville();
		ville = ville.chercherVilleParId(a.getIdVille());
		contenu.setValeurS(ville);
		contenu.setId(a.getId());
		return contenu;
		
	}

}
