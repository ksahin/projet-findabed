package com.findabed.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.findabed.app.FormulaireInscriptionT;
import com.findabed.app.FormulaireModifierAnnonceT;
import com.findabed.modeles.Annonce;
import com.meterware.httpunit.*;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class TestModifierAnnonce {
	
	private  ServletRunner sr ;
	private  ServletUnitClient client;
	private  WebRequest request;
	private  WebResponse response;
	
	@Before
	public void setUp() throws Exception {
		this.sr = new ServletRunner();
		this.sr.registerServlet("ModifierAnnonce", FormulaireModifierAnnonceT.class.getName());
		this.client = sr.newClient();
		this.request = new PostMethodWebRequest("http://FindAbed/ModifierAnnonce");
	}

	@After
	public void tearDown() throws Exception {
		this.sr = null;
		this.client = null;
		this.request = null;
	}
	public void setAnnonce(Annonce ann){
		this.request.setParameter("idUser", String.valueOf(ann.getIdUser()));
		this.request.setParameter("idville",String.valueOf(ann.getIdVille()));
		this.request.setParameter("description", ann.getDescription());
		this.request.setParameter("dateCreation", ann.getDateCreation());
		this.request.setParameter("dateValidite", ann.getDateValidite());
		this.request.setParameter("adresse", ann.getAdresse());
		this.request.setParameter("telephone", ann.getTelephone());	
	}

	@Test
	public void testModificationReussie() throws Exception {
		Annonce annonce = new Annonce(1,29,"description de l'annonce","03/11/2014","08/11/2014","20 rue de la soif 51051 jetaime","0645879632");
		this.request.setParameter("idAnnonce", "24");
		this.setAnnonce(annonce);
		this.response = this.client.getResponse(request);
		
		String IDANNONCE = (response.getText());
	    annonce.setId(Integer.parseInt(IDANNONCE));
	    Annonce result = annonce.trouverAnnonceParId();
	    
	    assertEquals(1,result.getIdUser());
	    assertEquals(29,result.getIdVille());
	    assertEquals("description de l'annonce",result.getDescription());
	    assertEquals("03/11/2014",result.getDateCreation());
	    assertEquals("08/11/2014",result.getDateValidite());
	    assertEquals("20 rue de la soif 51051 jetaime",result.getAdresse());
	    assertEquals("0645879632",result.getTelephone());
	}

}
