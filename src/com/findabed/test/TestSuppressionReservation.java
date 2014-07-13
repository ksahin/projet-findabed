package com.findabed.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.findabed.app.IndexT;
import com.findabed.app.SuppressionReservationT;
import com.findabed.modeles.Reservation;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class TestSuppressionReservation {

	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;

	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner();
		sr.registerServlet("SuppressionReservation", SuppressionReservationT.class.getName());
		this.client = sr.newClient();
		this.request = new GetMethodWebRequest("http://FindAbed/SuppressionReservation");
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
	}

	@Test
	public void testSuppressionReservation() throws IOException, SAXException, SQLException {
		Reservation reservation = new Reservation();
		reservation.setIdAnnonce(999);
		reservation.setIdUser(999);
		reservation.inserer();
		this.request.setParameter("idReservation",String.valueOf(reservation.getId()));
		this.response = this.client.getResponse(request);
		assertTrue(reservation.chercherListeReservations(999).isEmpty());
	}

}
