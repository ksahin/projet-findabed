package com.findabed.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.findabed.app.GestionAnnoncesT;
import com.findabed.app.ReservationAnnonceT;
import com.findabed.modeles.Reservation;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class TestReservation {

	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;
	
	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner();
		this.sr.registerServlet("Reservation", ReservationAnnonceT.class.getName());
		this.client = sr.newClient();
		this.request = new GetMethodWebRequest("http://FindAbed/Reservation");
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
	}

	
	@Test
	public void testReservationAnnonce() throws Exception {
		request.setParameter("idUser", "999");
		request.setParameter("idAnnonce", "997");
	    this.response = this.client.getResponse(request);
	    Reservation resaVerif = new Reservation();
	    resaVerif = resaVerif.rechercherParIdUser(999);
	    assertEquals(resaVerif.getIdAnnonce(), 997);
	    resaVerif.supprimerParId();
	}

	

}
