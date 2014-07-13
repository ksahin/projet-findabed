package com.findabed.modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ville {
	private Database base = new Database();
	private String nom;
	private String codepostal;
	private int idville;
	
	public Ville(){
		super();
	}
	
	public Ville(String nom, String codepostal,int idville) {
		this(nom, codepostal);
		this.idville = idville;
	}
	
	public Ville(String nom, String codepostal) {
		this.nom = nom;
		this.codepostal = codepostal;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public int getIdville() {
		return idville;
	}

	public void setIdville(int idville) {
		this.idville = idville;
	}
	
	
	public ArrayList<Ville> chercherListeVillesAuto(String nom) throws SQLException {
		ArrayList<Ville> listeVilles = new ArrayList<Ville>();
		Connection con = base.connexionBase();
		PreparedStatement pst = con.prepareStatement("select * from Ville where nom like '"+nom+"%' limit 10");
		pst.clearParameters();
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			Ville ville = new Ville(rs.getString("nom"),rs.getString("codepostal"),rs.getInt("id"));
			listeVilles.add(ville);
		}
		base.fermerConnexion(con);
		return listeVilles;
	}
	
	public Ville chercherVilleParId(int idVille) throws SQLException {
		Connection con = base.connexionBase();
		PreparedStatement pst = con.prepareStatement("select * from Ville where id = ?");
		pst.clearParameters();
		pst.setInt(1, idVille);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Ville ville  = new Ville(rs.getString("nom"),rs.getString("codepostal"),rs.getInt("id"));
		base.fermerConnexion(con);
		return ville;
	}
	
	
	
}
