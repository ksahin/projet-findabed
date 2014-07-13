package com.findabed.app;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findabed.modeles.Annonce;

/**
 * Servlet implementation class SuppressionAnnonceT
 */
@WebServlet("/SuppressionAnnonceT")
public class SuppressionAnnonceT extends SuppressionAnnonce {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionAnnonceT() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void redirection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			Annonce annonceAsupprimer = new Annonce();
			annonceAsupprimer.setId(Integer.parseInt(request.getParameter("idAnnonce")));
			try{
				annonceAsupprimer.supprimerAnnonceParId();
				this.redirection(request, response);
			} catch (SQLException e) {
				
			}
			
	}
	

}
