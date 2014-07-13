package com.findabed.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.findabed.app.SuppressionAnnonce;
import com.findabed.app.SuppressionAnnonceT;
import com.findabed.modeles.Annonce;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;


public class TestSupressionAnnonce {

	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;

	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner();
		this.client = sr.newClient();
		sr.registerServlet("suppressionAnnonce", SuppressionAnnonceT.class.getName());
		this.request = new GetMethodWebRequest("http://FindAbed/suppressionAnnonce");
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
	}

	@Test
	public void reponseDetailsAnnonce() throws IOException, SAXException, SQLException {
			Annonce ann = new Annonce(1,4,"DescriptionTest","01/01/2015","10/01/2015"," 1 rue des lois","0212254563");
			ann.inserer();
			this.request.setParameter("idAnnonce", String.valueOf(ann.getId()));
			this.response = this.client.getResponse(request);
			assertTrue(ann.trouverAnnonceParId()==null);
			
	}
}
