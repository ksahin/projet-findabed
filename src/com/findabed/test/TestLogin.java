package com.findabed.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.*;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

import java.sql.Connection;
import java.sql.DriverManager;
import com.findabed.app.*;
public class TestLogin {
	
	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;

	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner( "WebContent/WEB-INF/web.xml" );
		this.client = sr.newClient();
		this.request = new PostMethodWebRequest("http://FindAbed/index.html");
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
	}

	@Test
	public void testLoginNominal() throws IOException, SAXException {
			this.request.setParameter("mail", "toto@gmail.com");
			this.request.setParameter("motdepasse", "titi6");  
			this.response = this.client.getResponse(request);
			assertTrue(response.getText().indexOf("Bienvenue") != -1);
	}
	

	@Test
	public void testLoginChampMailErrone() throws IOException, SAXException {
		this.request.setParameter("mail", "hkll");
		this.request.setParameter("motdepasse", "toto6");  
		this.response = this.client.getResponse(request);
		assertTrue(response.getText().indexOf("Mail incorrect") != -1);
	}
	
	@Test
	public void testLoginChampMdpErrone() throws IOException, SAXException {
		this.request.setParameter("mail", "toto@gmail.com");
		this.request.setParameter("motdepasse", "y");  
		this.response = this.client.getResponse(request);
		assertTrue(response.getText().indexOf("Mot de passe incorrect") != -1);
	}
	@Test
	public void testConnexion() throws Exception{
		try{
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:file:H:/Bureau/Projet Agile/database/","SA","");
		}catch(Exception e){
			fail();
		}
		
	        
	}
	
}
