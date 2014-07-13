package com.findabed.test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.sql.*;

import com.findabed.app.User;
import com.meterware.httpunit.*;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;


public class testFormulaireInscription {
	
	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner("WebContent/WEB-INF/web.xml");
		this.client = sr.newClient();
		this.request = new PostMethodWebRequest("http://FindAbed/inscription");
		
		
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
		
	}
	public void setRequeteAvecUser(User usr){
		this.request.setParameter("mail", usr.getMail());
		this.request.setParameter("motdepasse", usr.getMotdepasse());
		this.request.setParameter("nom", usr.getNom());
		this.request.setParameter("prenom", usr.getPrenom());		
	}
	@Test
	public void testInscriptionReussie() throws Exception{
		User user = new User("sahin.kevin@gmail.com","toto","sahin","kevin");
		this.setRequeteAvecUser(user);
	    this.response = this.client.getResponse(request);
	    assertEquals("toto",user.trouverUserParMail().getMotdepasse());
		assertEquals("sahin",user.trouverUserParMail().getNom());
		assertEquals("kevin",user.trouverUserParMail().getPrenom());
		user.supprimerUserParMail();
		
	}
	@Test
	public void testInscriptionMailUnique() throws Exception{

		User user = new User("ramuntcho.moretti@gmail.com","cacaprout",
				"moretti","ramuntcho");
		this.setRequeteAvecUser(user);
	    this.response = this.client.getResponse(request);
	    assertTrue(user.estPresentDansBase("mail", user.getMail()));
	}
	@Test
	public void testConnexion() throws Exception{
		try{
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:file:H:/Bureau/Projet Agile/database/","SA","");
		}catch(Exception e){
			fail();
		}
		
	        
	}
	
	

}
