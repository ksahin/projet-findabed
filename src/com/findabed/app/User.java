package com.findabed.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class User {
	private String nom;
	private String prenom;
	private String mail;
	private String motdepasse;
	private Database base = new Database();
	
	public User(){
		
	}
	public User(String mail, String motdepasse, String nom, String prenom){
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.motdepasse = motdepasse;
	}
	public User(HttpServletRequest request){
		this.mail = request.getParameter("mail");
		this.motdepasse = request.getParameter("motdepasse");
		this.nom = request.getParameter("nom");
		this.prenom = request.getParameter("prenom");
	}
	
	public String getMail() {
		return mail;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	
	public void inserer(){
		try {
			Connection con  = base.connexionBase();
    	    PreparedStatement pst=con.prepareStatement("insert into User (MAIL,MOTDEPASSE,NOM,PRENOM) values(?,?,?,?)");
            pst.clearParameters();
            pst.setString(1, this.mail);
            pst.setString(2, this.motdepasse );
            pst.setString(3, this.nom);
            pst.setString(4, this.prenom);
            pst.executeUpdate();
            base.fermerConnexion(con);
    } catch (SQLException e) {
    		System.out.println("ERREUR INSERTION");
    	  e.printStackTrace(System.out);
    }}
		public boolean estPresentDansBase(String champ, String valeurchamp){
			boolean resultat = false;
			try{
					Connection con = base.connexionBase();
					PreparedStatement pst2=con.prepareStatement("SELECT COUNT (*) FROM USER where "+champ+"=?");
					pst2.clearParameters();
		            pst2.setString(1, valeurchamp);
		            ResultSet rs = pst2.executeQuery();
		            rs.next();
		            resultat = (rs.getInt(1) == 1);
		            base.fermerConnexion(con);

		}catch(SQLException e){
			e.printStackTrace();
		}
			return resultat;

	
	}
		public void supprimerUserParMail(){
			try{
			Connection con = base.connexionBase();
			PreparedStatement pst = con.prepareStatement("DELETE FROM USER where mail=?");
			pst.clearParameters();
			pst.setString(1, this.mail);
			pst.executeUpdate();
			base.fermerConnexion(con);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		public User trouverUserParMail(){
			User user = null;
			try {
				Connection con = base.connexionBase();
				PreparedStatement pst = con.prepareStatement("select * from User where mail=? ");
				pst.clearParameters();
				pst.setString(1, this.mail);
				ResultSet rs = pst.executeQuery();
				if(rs.next()){
				user = new User(rs.getString("mail"),rs.getString("motdepasse"),
							rs.getString("nom"),rs.getString("prenom"));}
				base.fermerConnexion(con);
			} 
			catch (SQLException e) {
				System.out.println("ERREUR LISTE");
				e.printStackTrace(System.out);
			}
			return user;
	    }
		public String toString(){
			return(this.nom + " "+this.prenom+" "+this.mail+" "+this.motdepasse);
		}
}
