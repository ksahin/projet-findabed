package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findabed.modeles.Annonce;

/**
 * Servlet implementation class PublicationT
 */
@WebServlet("/PublicationT")
public class PublicationT extends Publication {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicationT() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void redirection(String message, HttpServletRequest request, HttpServletResponse response, Annonce annonce) throws IOException, ServletException {
			PrintWriter out = response.getWriter();
			out.print(annonce.getId());
	
	}

}
