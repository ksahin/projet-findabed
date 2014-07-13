package com.findabed.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.findabed.app.PublicationT;
import com.findabed.app.VisualisationAnnonce;
import com.findabed.app.VisualisationAnnonceT;
import com.findabed.modeles.Annonce;
import com.findabed.modeles.Reservation;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class TestVisualisation {

	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;
	
	private String contenuAnnonce =  "A louer une chambre dans une superbe villa du 15ème siècle.";
									
	
	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner();
		sr.registerServlet("Visualisation", VisualisationAnnonceT.class.getName());
		this.client = sr.newClient();
		this.request = new GetMethodWebRequest("http://FindAbed/Visualisation");
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
	}

	@Test
	public void testReponseVisualisation() throws IOException, SAXException, SQLException {
		this.request.setParameter("idAnnonce","17");
		this.response = this.client.getResponse(request);
		assertTrue(response.getText().indexOf(contenuAnnonce) != -1);
	}


}
