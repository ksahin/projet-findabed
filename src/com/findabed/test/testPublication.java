package com.findabed.test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.sql.*;

import com.findabed.app.PublicationT;
import com.findabed.modeles.Annonce;
import com.findabed.modeles.Database;
import com.findabed.modeles.User;
import com.meterware.httpunit.*;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;


public class testPublication {

	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;
	
	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner();
		sr.registerServlet("Publication", PublicationT.class.getName());
		this.client = sr.newClient();
		this.request = new PostMethodWebRequest("http://FindAbed/Publication");
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
	}
	public void setRequeteAvecAnnonce(Annonce ann){
		this.request.setParameter("idUser", String.valueOf(ann.getIdUser()));
		this.request.setParameter("idville",String.valueOf(ann.getIdVille()));
		this.request.setParameter("description", ann.getDescription());
		this.request.setParameter("dateCreation", ann.getDateCreation());
		this.request.setParameter("dateValidite", ann.getDateValidite());
		this.request.setParameter("adresse", ann.getAdresse());
		this.request.setParameter("telephone", ann.getTelephone());	
	}

	@Test
	public void testPublicationReussie() throws Exception {
		Annonce annonce = new Annonce(4,1,"description de l'annonce","03/11/2014","08/11/2014",
							"20 rue de la soif 51051 jetaime","0645879632");
		this.setRequeteAvecAnnonce(annonce);
	    this.response = this.client.getResponse(request);
	    String IDANNONCE = (response.getText());
	    annonce.setId(Integer.parseInt(IDANNONCE));
	    Annonce result = annonce.trouverAnnonceParId();
	    assertEquals(4,result.getIdUser());
	    assertEquals(1,result.getIdVille());
	    assertEquals("description de l'annonce",result.getDescription());
	    assertEquals("03/11/2014",result.getDateCreation());
	    assertEquals("08/11/2014",result.getDateValidite());
	    assertEquals("20 rue de la soif 51051 jetaime",result.getAdresse());
	    assertEquals("0645879632",result.getTelephone());
		annonce.supprimerAnnonceParId();
	}

}
