package com.findabed.app;

import java.io.IOException;
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
import com.findabed.modeles.Reservation;
import com.findabed.modeles.Ville;

/**
 * Servlet implementation class GestionReservations
 */
@WebServlet("/GestionReservations")
public class GestionReservations extends SuperServlet  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionReservations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUser;
		if (this.isSessionActive(request)){
			idUser = (int) request.getSession().getAttribute("id");
		} else {
			idUser = Integer.parseInt(request.getParameter("idUser"));
		}
		Reservation reservation = new Reservation();
		ArrayList<Contenu<Annonce,Ville>> listeContenuReservation = new ArrayList<Contenu<Annonce,Ville>>();
		try{
			ArrayList<Reservation> listeReservations = reservation.chercherListeReservations(idUser);
			for(Reservation r : listeReservations){
				listeContenuReservation.add(this.rechercherContenuReservation(r));
			}
			request.setAttribute("listeContenuReservation", listeContenuReservation);
		} catch (SQLException e){
			request.setAttribute("message", "Un problème est survenu, veuillez réessayer");
		}
		this.redirection(request,response,JSPGESTIONRESERVATIONS,
				listeContenuReservation,idUser);
	}

	/**
	 * @seee HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void redirection(HttpServletRequest request, HttpServletResponse response,String page,
			ArrayList<Contenu<Annonce,Ville>> liste,int idUser) 
				throws IOException,ServletException{
		this.getServletContext().getRequestDispatcher(page).forward(request,response);
	}

	public Contenu<Annonce,Ville> rechercherContenuReservation(Reservation r) throws SQLException{
		Contenu<Annonce,Ville> contenu = new Contenu<Annonce,Ville>();
		Annonce annonce = new Annonce();
		annonce.setId(r.getIdAnnonce());
			annonce = annonce.trouverAnnonceParId();
			Ville ville = new Ville();
			ville = ville.chercherVilleParId(annonce.getIdVille());
			contenu.setValeurT(annonce);
			contenu.setValeurS(ville);
			contenu.setId(r.getId());
		return contenu;
	}
	
}
