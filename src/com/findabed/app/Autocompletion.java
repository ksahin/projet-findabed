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

import com.findabed.modeles.Ville;


/**
 * Servlet implementation class Autocompletion
 */
@WebServlet("/Autocompletion")
public class Autocompletion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String JSPACCUEIL = "/WEB-INF/accueilBS.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autocompletion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( JSPACCUEIL).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Ville> listeVilles = new ArrayList<Ville>();
		Ville ville = new Ville();
		PrintWriter out = response.getWriter();
		try {
			listeVilles = ville.chercherListeVillesAuto(request.getParameter("ville").toUpperCase());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print(toJson(listeVilles));
	}
	
	public static String toJson(ArrayList<Ville> liste) {
	    StringBuilder result = new StringBuilder();
	    result.append("[");
	    for (Ville v : liste) {
	        result.append("{\"id\":"+v.getIdville()+",\"name\":\""+v.getNom()+" - "+v.getCodepostal()+"\"}");
	        if (liste.lastIndexOf(v)+1 != liste.size()) result.append(",");
	    }
	    result.append("]");
	    return result.toString();
	}
	
}
