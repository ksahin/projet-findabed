package com.findabed.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.findabed.app.DetailsAnnonce;
import com.findabed.app.DetailsAnnonceT;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.InvocationContext;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class TestDetailsAnnonce {


	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;
	
	private String corpsAnnonce = "Donec id elit non mi porta gravida "
								+ "at eget metus. Fusce dapibus, "
								+ "tellus ac cursus commodo, tortor "
								+ "mauris condimentum nibh, ut fermentum"
								+ " massa justo sit amet risus. Etiam porta "
								+ "sem malesuada magna mollis euismod. Donec sed odio dui.";

	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner();
		this.sr.registerServlet("Details", DetailsAnnonceT.class.getName());
		this.client = sr.newClient();
		this.request = new GetMethodWebRequest("http://FindAbed/Details");
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
	}

	@Test
	public void reponseDetailsAnnonce() throws IOException, SAXException {
			this.request.setParameter("idAnnonce", "45");
			this.response = this.client.getResponse(request);
			assertTrue(response.getText().indexOf(corpsAnnonce) != -1);
			
	}
	

	  
}
