package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findabed.modeles.User;

/**
 * Servlet implementation class FormulaireProfilT
 */
@WebServlet("/FormulaireProfilT")
public class FormulaireProfilT extends FormulaireProfil {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormulaireProfilT() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void redirection (String message, HttpServletRequest request, HttpServletResponse response, User user) throws IOException, ServletException {
    	PrintWriter out = response.getWriter();
		out.print(user.getIdUSER());
    }

}
