package com.findabed.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexT
 */
@WebServlet("/IndexT")
public class IndexT extends Index {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexT() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void redirection (HttpServletRequest request,HttpServletResponse response, String message,String adresse) throws IOException,ServletException{
			PrintWriter out = response.getWriter();
			out.print(message);
	}

}
