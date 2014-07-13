package com.findabed.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SuperServlet
 */
@WebServlet("/SuperServlet")
public class SuperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String JSPACCUEIL = "/WEB-INF/accueilBS.jsp";
    public static String JSPDETAILANNONCE = "/WEB-INF/detailsAnnonceBS.jsp";
    public static String JSPINSCRIPTION = "/WEB-INF/inscriptionBS.jsp";
    public static String JSPGESTIONANNONCES = "/WEB-INF/gestionAnnonces.jsp";
    public static String JSPPUBLICATION = "/WEB-INF/publicationBS.jsp";
    public static String JSPVISUALISATION = "/WEB-INF/visualisationAnnonceBS.jsp";
    public static String JSPVISUALISERANNONCE= "/WEB-INF/visualisationAnnonceBS.jsp";
    public static String JSPRECHERCHEANNONCE = "/WEB-INF/rechercheAnnonceBS.jsp";
    public static String JSPMODIF = "/WEB-INF/modifierAnnonce.jsp";
    public static String JSPPROFIL = "/WEB-INF/Profil.jsp";
    public static String JSPGESTIONRESERVATIONS = "/WEB-INF/gestionReservations.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public boolean isSessionActive(HttpServletRequest request){
		HttpSession session = request.getSession();
		String connecte = (String)session.getAttribute("connecte");
		return connecte != null;
	}
	
	public  void redirection(HttpServletRequest request, HttpServletResponse response,String page) throws IOException,ServletException {
		this.getServletContext().getRequestDispatcher(page).forward( request, response );
	}

}
