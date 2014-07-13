package com.findabed.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.findabed.app.RechercheAnnonceT;
import com.findabed.modeles.Annonce;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class TestRecherche {


		
		private  ServletRunner sr ;
		private  ServletUnitClient client;
		private  WebRequest request;
		private  WebResponse response;
		
		@Before
		public void setUp() throws Exception {
			this.sr = new ServletRunner();
			this.sr.registerServlet("Recherche",RechercheAnnonceT.class.getName());
			this.client = sr.newClient();
			this.request = new PostMethodWebRequest("http://FindAbed/recherche");
			
			
		}

		@After
		public void tearDown() throws Exception {
			this.sr = null;
			this.client = null;
			this.request = null;
			
		}

	@Test
	public void testRechercheAnnonceExistante() throws SQLException{
		Annonce annonce = new Annonce();
		ArrayList<Annonce> maRecherche = annonce.chercherAnnonceParVille("toulouse","04/03/2014");
		
		assertEquals(maRecherche.get(0).getIdVille(),39437);
		assertEquals(maRecherche.get(0).getDescription(),"Une description!!!!");	
	}
	
	@Test
	public void testAnnonceNonExistante() throws SQLException{
		Annonce annonce =new Annonce();
		ArrayList<Annonce> maRecherche = annonce.chercherAnnonceParVille("toulouse","05/06/2015");
		assertTrue(maRecherche.isEmpty());
		
	}
	@Test
	public void testRecherchePlusieursAnnoncesExistantes() throws SQLException{
		Annonce annonce = new Annonce();
		ArrayList<Annonce> maRecherche = annonce.chercherAnnonceParVille("toulouse","04/03/2014");
		assertEquals(maRecherche.get(0).getIdVille(),39437);
		assertEquals(maRecherche.get(0).getDescription(),"Une description!!!!");
		assertEquals(maRecherche.get(1).getIdVille(),39437);
		assertEquals(maRecherche.get(1).getDescription(),"deux description");
	}
	}

