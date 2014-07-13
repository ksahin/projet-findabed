package com.findabed.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.findabed.app.GestionAnnoncesT;
import com.findabed.app.GestionReservationT;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class TestGestionReservations {

	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;
	private  String texteReservation = "La Cigale, ayant chanté tout l'été, ";
	
	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner();
		this.sr.registerServlet("GestionReservations", GestionReservationT.class.getName());
		this.client = sr.newClient();
		this.request = new GetMethodWebRequest("http://FindAbed/GestionReservations");
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
	}

	

	@Test
	public void testAffichageReservationUtilisteur() throws Exception {
		request.setParameter("idUser", "1");
	    this.response = this.client.getResponse(request);
	    assertTrue(response.getText().indexOf(texteReservation) != -1);
	}


}
