package com.findabed.test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.sql.*;

import com.findabed.app.FormulaireInscriptionT;
import com.findabed.modeles.User;
import com.meterware.httpunit.*;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;


public class testFormulaireInscription {
	
	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;
	
	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner();
		this.sr.registerServlet("Inscription", FormulaireInscriptionT.class.getName());
		this.client = sr.newClient();
		this.request = new PostMethodWebRequest("http://FindAbed/Inscription");
		
		
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
		this.request.setParameter("adresse", usr.getAdresse());
		this.request.setParameter("telephone", usr.getTelephone());
		this.request.setParameter("ville", String.valueOf(usr.getIdVille()));
	}
	@Test
	public void testInscriptionReussie() throws Exception{
		User user = new User("sahin.kevin@gmail.com","toto","sahin","kevin","nouvelle adresse","0632589654",1);
		this.setRequeteAvecUser(user);
	    this.response = this.client.getResponse(request);
	    assertEquals(User.crypter("toto"),user.trouverUserParMail().getMotdepasse());
		assertEquals("sahin",user.trouverUserParMail().getNom());
		assertEquals("kevin",user.trouverUserParMail().getPrenom());
		assertEquals("nouvelle adresse",user.trouverUserParMail().getAdresse());
		assertEquals("0632589654",user.trouverUserParMail().getTelephone());
		assertEquals(1,user.trouverUserParMail().getIdVille());
		user.supprimerUserParMail();
		
	}
	@Test
	public void testInscriptionMailUnique() throws Exception{

		User user = new User("ramuntcho.moretti@gmail.com","motdepasse",
				"moretti","ramuntcho","adresse ramun","0587965412",1);
		this.setRequeteAvecUser(user);
	    this.response = this.client.getResponse(request);
	    assertTrue(user.estPresentDansBase("mail", user.getMail()));
	}
	
}
