package com.findabed.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class TestAutocompletion {

	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;
	
	private String reponseAttendue = 	"["
										+"{\"id\":39433,\"name\":\"TOULOUSE - 31500\"},"
										+"{\"id\":39434,\"name\":\"TOULOUSE - 31400\"},"
										+"{\"id\":39435,\"name\":\"TOULOUSE - 31300\"},"
										+"{\"id\":39436,\"name\":\"TOULOUSE - 31100\"},"
										+"{\"id\":39437,\"name\":\"TOULOUSE - 31000\"},"
										+"{\"id\":39438,\"name\":\"TOULOUSE - 31200\"},"
										+"{\"id\":39439,\"name\":\"TOULOUSE LE CHATEAU - 39230\"}"
										+"]";

	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner( new File("WebContent/WEB-INF/web.xml"));
		this.client = sr.newClient();
		this.request = new PostMethodWebRequest("http://FindAbed/autocompletion");
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
	}

	@Test
	public void reponseAutocompletion() throws IOException, SAXException {
			this.request.setParameter("ville", "Toulouse");
			this.response = this.client.getResponse(request);
			assertEquals(reponseAttendue, response.getText());
	}

}
