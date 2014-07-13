package com.findabed.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.findabed.app.GestionAnnoncesT;
import com.findabed.modeles.Annonce;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class TestGestionAnnonces {

	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;
	private  String texteAnnonce = "La Cigale, ayant chanté tout l'été, "
									+ "se trouva fort dépourvue quand la bise fut venue : "
									+ "pas un seul petit morceau de mouche ou de vermisseau.";
	
	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner();
		this.sr.registerServlet("GestionAnnonces", GestionAnnoncesT.class.getName());
		this.client = sr.newClient();
		this.request = new GetMethodWebRequest("http://FindAbed/GestionAnnonces");
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
	}

	
	@Test
	public void testAffichageIdUtilisteur() throws Exception {
		request.setParameter("idUser", "33");
	    this.response = this.client.getResponse(request);
	    assertTrue(response.getText().indexOf("33") != -1);
	}

	@Test
	public void testAffichageAnnoncesUtilisteur() throws Exception {
		request.setParameter("idUser", "33");
	    this.response = this.client.getResponse(request);
	    assertTrue(response.getText().indexOf(texteAnnonce) != -1);
	}

}
