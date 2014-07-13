package com.findabed.modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.*;

import javax.servlet.http.HttpServletRequest;

public class Annonce {

	private int id;
	private int idUser;
	private int idVille;
	private String description;
	private String dateCreation;
	private String dateValidite;
	private String adresse;
	private String telephone;
	private Database base = new Database();
	
	
	public Annonce(){
		
	}
	
	public Annonce(int idUser, int idVille,String description, String dateCreation, String dateValidite, String adresse, String telephone){
		this.idUser = idUser;
		this.idVille = idVille;
		this.description = description;
		this.dateCreation = dateCreation;
		this.dateValidite = dateValidite;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	public Annonce(int id,int idUser, int idVille,String description, String dateCreation, String dateValidite, String adresse, String telephone){
		this(idUser, idVille,description,  dateCreation,  dateValidite, adresse, telephone);
		this.id = id;
	}

	public Annonce(HttpServletRequest request, int idUser){
		this(request);
		this.idUser = idUser;
		
	}
	public Annonce(HttpServletRequest request){
		this.idVille = Integer.parseInt(request.getParameter("idville"));
		this.description = request.getParameter("description");
		this.dateCreation = request.getParameter("dateCreation");
		this.dateValidite = request.getParameter("dateValidite");
		this.adresse = request.getParameter("adresse");
		this.telephone = request.getParameter("telephone");
	}
	public int getIdUser() {
		return idUser;
	}
	public int getIdVille() {
		return idVille;
	}
	public String getTelephone() {
		return telephone;
	}
	public int getId() {
		return id;
	}
	public String getDescription(){
		return description;
	}
	public String getDateCreation(){
		return dateCreation;
	}
	public String getDateValidite(){
		return dateValidite;
	}
	public String getAdresse(){
		return adresse;
	}
	public void setId(int id){
		this.id = id;
	}
	
	public void inserer() throws SQLException {
			Connection con  = base.connexionBase();
			PreparedStatement pst=con.prepareStatement("insert into Annonce (iduser,"
					+ "idville,description,datecreation,datevalide,adresse,telephone) "
					+ "values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			pst.clearParameters();
			pst.setInt(1, this.idUser);
            pst.setInt(2, this.idVille );
            pst.setString(3, this.description);
            pst.setString(4, dateFrToBase(this.dateCreation));
            pst.setString(5, dateFrToBase(this.dateValidite));
            pst.setString(6, this.adresse);
            pst.setString(7, this.telephone); 
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            this.id = rs.getInt(1); 
            base.fermerConnexion(con);
	} 
	
	
	public void update() throws SQLException {
			Connection con  = base.connexionBase();
			PreparedStatement pst=con.prepareStatement("update Annonce set idville = ?, description = ?, "
					+ "datecreation = ? , datevalide = ?, adresse = ?, telephone = ? where id = ?");
			pst.clearParameters();
            pst.setInt(1, this.idVille );
            pst.setString(2, this.description);
            pst.setString(3, dateFrToBase(this.dateCreation));
            pst.setString(4, dateFrToBase(this.dateValidite));
            pst.setString(5, this.adresse);
            pst.setString(6, this.telephone);
            pst.setInt(7, this.id);
            pst.executeUpdate();
            base.fermerConnexion(con);  
	}
	
	public void supprimerAnnonceParId() throws SQLException{
			Connection con = base.connexionBase();
			PreparedStatement pst = con.prepareStatement("delete from Annonce where id = ?");
			pst.clearParameters();
			pst.setInt(1, this.id);
			pst.executeUpdate();
			base.fermerConnexion(con);
	}
	
	public Annonce trouverAnnonceParId() throws SQLException {
		Annonce annonce = null;
			Connection con = base.connexionBase();
			PreparedStatement pst = con.prepareStatement("select * from Annonce where id=? ");
			pst.clearParameters();
			pst.setInt(1, this.id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){				
			annonce = new Annonce(this.id,rs.getInt("idUser"),rs.getInt("idVille"),
						rs.getString("description"),dateBaseToFr(rs.getTimestamp("dateCreation").toString()),
						dateBaseToFr(rs.getTimestamp("dateValide").toString()),
						rs.getString("adresse"),
						rs.getString("telephone"));}
			base.fermerConnexion(con);
			return annonce;
    }

	public ArrayList<Annonce> rechercheParIdUser(int idUser) throws SQLException {
		ArrayList<Annonce> listeAnnonces = new ArrayList<Annonce>();
		Connection con  = base.connexionBase();
		PreparedStatement pst = con.prepareStatement("select * from Annonce where idUser = ?"
													+ " order by datevalide desc");
		pst.clearParameters();
		pst.setInt(1, idUser);
		ResultSet rs = pst.executeQuery();
		listeAnnonces = construireListeAnnonces(rs);
		base.fermerConnexion(con);
		return listeAnnonces; 
	}
	
	private static String dateBaseToFr(String date) {
		String resultat ="";
			if (date!= null){ 
			resultat += date.substring(8,10);
			resultat += "/";
			resultat += date.substring(5,7);
			resultat += "/";
			resultat += date.substring(0,4);
		}
		return resultat;
	}
	
	private static String dateFrToBase(String date){
		String resultat ="";
		if (date != null){
			resultat += date.substring(6,10);
			resultat += "-";
			resultat += date.substring(3,5);
			resultat += "-";
			resultat += date.substring(0,2);
			resultat += " 00:00:00";
		}
		return resultat;
	}
	
	public ArrayList<Annonce> chercherAnnonceParVille(String nomVille,String date) throws SQLException {
		ArrayList<Annonce> listeAnnonces = new ArrayList<Annonce>();
		date = dateFrToBase(date);
		date = "'"+date+"'";
		Connection con  = base.connexionBase();
		PreparedStatement pst = con.prepareStatement("select * from Annonce where "
											+ "idville in (select distinct id from Ville where nom like upper('%"+nomVille+"%')) "
											+ "and "+date+" between datecreation and datevalide "
											+ "and Annonce.id not in (select idAnnonce from Reservation) "
											+ "order by datecreation desc");
		pst.clearParameters();
		ResultSet rs = pst.executeQuery();
		listeAnnonces = construireListeAnnonces(rs);
		base.fermerConnexion(con);
		return listeAnnonces;
	}
	
	public ArrayList<Annonce> construireListeAnnonces(ResultSet rs) throws SQLException {
		ArrayList<Annonce> liste = new ArrayList<Annonce>();
		while(rs.next())
		{
			Annonce ann = new Annonce(rs.getInt("id"),rs.getInt("iduser"),rs.getInt("idville"),rs.getString("description"),
					dateBaseToFr(rs.getString("datecreation")),dateBaseToFr(rs.getString("datevalide")),
					rs.getString("adresse"),rs.getString("telephone"));
			liste.add(ann);
		}
		return liste;
	}
	
	
}
