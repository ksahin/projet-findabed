package com.findabed.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormulaireInscriptionT
 */
@WebServlet("/FormulaireInscriptionT")
public class FormulaireInscriptionT extends FormulaireInscription {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormulaireInscriptionT() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void redirection (HttpServletRequest request, HttpServletResponse response, String page) throws IOException, ServletException {

    }

}
