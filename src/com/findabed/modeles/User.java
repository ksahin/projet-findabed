package com.findabed.modeles;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;

public class User {
	private String nom;
	private String prenom;
	private String mail;
	private String motdepasse;
	private String adresse;
	private String telephone;
	private int idVille;
	private Database base = new Database();
	private int idUSER;
	
	public User(){
		
	}
	
	public User(String mail, String motdepasse, String nom, String prenom,int id){
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.motdepasse = motdepasse;
		this.idUSER = id;
	}
	
	public User(String mail, String motdepasse, String nom, String prenom){
		this(mail, motdepasse, nom, prenom, 0);
	}
	
	public User(HttpServletRequest request){
		this.mail = request.getParameter("mail");
		this.motdepasse = request.getParameter("motdepasse");
		this.nom = request.getParameter("nom");
		this.prenom = request.getParameter("prenom");
		this.adresse = request.getParameter("adresse");
		this.telephone = request.getParameter("telephone");
		if(request.getParameter("ville")!= null){
			this.idVille = Integer.parseInt(request.getParameter("ville"));
		}
	}
	
	
	
	public User(String mail, String motdepasse, String nom, String prenom,String adresse,String telephone,int idVille){
		this(mail, motdepasse, nom, prenom, 0, adresse, telephone, idVille);
	}
	
	public User(String mail, String motdepasse, String nom, String prenom,int id,String adresse,String telephone,int idVille){
		this(mail, motdepasse, nom, prenom, id);
		this.adresse = adresse;
		this.telephone = telephone;
		this.idVille = idVille;
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
	public int getId() {
		return idUSER;
	}
		
	public int getIdUSER() {
		return idUSER;
	}
	public String getTelephone(){
		return telephone;
	}
	public int getIdVille() {
		return idVille;
	}
	public String getAdresse(){
		return adresse;
	}
	public void setIdUSER(int idUSER) {
		this.idUSER = idUSER;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	
	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void inserer() throws SQLException {
			Connection con  = base.connexionBase();
    	    PreparedStatement pst=con.prepareStatement("insert into User (mail,motdepasse,nom,prenom,"
    	    				+ "adresse,telephone,idville) values(?,?,?,?,?,?,?)");
            pst.clearParameters();
            pst.setString(1, this.mail);
            pst.setString(2, crypter(this.motdepasse));
            pst.setString(3, this.nom);
            pst.setString(4, this.prenom);
            pst.setString(5, this.adresse );
            pst.setString(6, this.telephone);
            pst.setInt(7, this.idVille);
            pst.executeUpdate();
            base.fermerConnexion(con);
		}
	
	public void update(boolean changerMdp) throws SQLException {
			Connection con  = base.connexionBase();
			PreparedStatement pst = con.prepareStatement("update User set mail = ?,nom = ?,prenom = ?,"
					+ "adresse = ?,telephone = ?,idville = ? where id = ?");
			pst.clearParameters();
            pst.setString(1, this.mail );            
            pst.setString(2, this.nom);            
            pst.setString(3, this.prenom);            
            pst.setString(4, this.adresse);            
            pst.setString(5, this.telephone);            
            pst.setInt(6, this.idVille);
            pst.setInt(7, this.idUSER);
            pst.executeUpdate();
            if (changerMdp){
            	PreparedStatement pst2 = con.prepareStatement("Update User set motdepasse = ? where id = ?");
            	pst2.clearParameters();
            	pst2.setString(1, crypter(this.motdepasse));
                pst2.setInt(2, this.idUSER ); 
                pst2.executeUpdate();
            }
            base.fermerConnexion(con);
	}
	
	public boolean estPresentDansBase(String champ, String valeurchamp){
		boolean resultat = false;
		try{
				Connection con = base.connexionBase();
				PreparedStatement pst2=con.prepareStatement("select count(*) from User where "+champ+"=?");
				pst2.clearParameters();
	            pst2.setString(1, valeurchamp);
	            ResultSet rs = pst2.executeQuery();
	            rs.next();
	            resultat = (rs.getInt(1) == 1);
	            base.fermerConnexion(con);

		}catch(SQLException e){
			
		}
		return resultat;
	}
	
	public void supprimerUserParMail() throws SQLException{
			Connection con = base.connexionBase();
			PreparedStatement pst = con.prepareStatement("DELETE FROM User where mail=?");
			pst.clearParameters();
			pst.setString(1, this.mail);
			pst.executeUpdate();
			base.fermerConnexion(con);
		}
	
	public User trouverUserParMail() throws SQLException {
		Connection con = base.connexionBase();
		PreparedStatement pst = con.prepareStatement("select * from User where mail=? ");
		pst.clearParameters();
		pst.setString(1, this.mail);
		ResultSet rs = pst.executeQuery();
		User user = construireUser(rs);
		base.fermerConnexion(con);
		return user;
    }
	
	public User trouverUserParId() throws SQLException {
		Connection con = base.connexionBase();
		PreparedStatement pst = con.prepareStatement("select * from User where id=? ");
		pst.clearParameters();
		pst.setInt(1, this.idUSER);
		ResultSet rs = pst.executeQuery();
		User user = construireUser(rs);
		base.fermerConnexion(con);
		return user;
    }
	
	public User construireUser(ResultSet rs) throws SQLException{
		User user = null;
		if(rs.next()){
		user = new User(rs.getString("mail"),rs.getString("motdepasse"),
					rs.getString("nom"),rs.getString("prenom"),rs.getInt("id"),
					rs.getString("adresse"),rs.getString("telephone"),rs.getInt("idVille"));
		}
		return user;
		
	}
	
		
		 public static String crypter(String input) {
		 	String salt = "1D23er!fGTd4%^^dzsd78611djbsHhqlh#é~u4qlDe";
		 	input += salt;
	        String resultat = null;
	        if(null == input) return null;
	        try {
		        MessageDigest digest = MessageDigest.getInstance("MD5");
		        digest.update(input.getBytes(), 0, input.length());
		        resultat = new BigInteger(1, digest.digest()).toString(16);
	        } catch (NoSuchAlgorithmException e) {

	        }
	        return resultat;
	    }
		 
}
