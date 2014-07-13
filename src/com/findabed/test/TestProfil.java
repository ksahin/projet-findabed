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
import com.findabed.app.FormulaireProfilT;
import com.findabed.modeles.Annonce;
import com.findabed.modeles.User;
import com.meterware.httpunit.*;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;


public class TestProfil {
	
	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;
	
	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner();
		this.sr.registerServlet("Profil", FormulaireProfilT.class.getName());
		this.client = sr.newClient();
		this.request = new PostMethodWebRequest("http://FindAbed/Profil");
		
		
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
		
	}
	public void setUser(User usr){
		this.request.setParameter("mail", usr.getMail());
		this.request.setParameter("motdepasse", usr.getMotdepasse());
		this.request.setParameter("nom", usr.getNom());
		this.request.setParameter("prenom", usr.getPrenom());
		this.request.setParameter("adresse", usr.getAdresse());
		this.request.setParameter("telephone", usr.getTelephone());
		this.request.setParameter("ville", String.valueOf(usr.getIdVille()));
	}
	@Test
	public void testModificationReussie() throws Exception{
		User user = new User("lolilol@gmail.com","lolilol","sahin","kevin","nouvelle adresse","0632589654",1);
		this.request.setParameter("iduser", "63");
		this.request.setParameter("idville", "1");
		this.setUser(user);
		this.response = this.client.getResponse(request);
		String ID = (response.getText());
	    user.setIdUSER(Integer.parseInt(ID));
	    User userVerfication = user.trouverUserParId();
	    assertEquals("lolilol@gmail.com",userVerfication.getMail());
	    assertEquals(User.crypter("lolilol"),userVerfication.getMotdepasse());
		assertEquals("sahin",userVerfication.getNom());
		assertEquals("kevin",userVerfication.getPrenom());
		assertEquals("nouvelle adresse",userVerfication.getAdresse());
		assertEquals("0632589654",userVerfication.getTelephone());
		assertEquals(1,userVerfication.getIdVille());
	}

	
}
