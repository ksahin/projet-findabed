package com.findabed.modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Reservation {
	
	private int id;
	private int idUser;
	private int idAnnonce;
	private Database base = new Database();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdAnnonce() {
		return idAnnonce;
	}
	public void setIdAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	
	public void inserer() throws SQLException{
			Connection con  = base.connexionBase();
			PreparedStatement pst = con.prepareStatement("insert into Reservation (iduser,idannonce) values(?,?)",Statement.RETURN_GENERATED_KEYS);
			pst.clearParameters();
			pst.setInt(1, this.idUser);
            pst.setInt(2, this.idAnnonce );
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            this.id = rs.getInt(1); 
            base.fermerConnexion(con);
	}
	
	public ArrayList<Reservation> chercherListeReservations(int idUser) throws SQLException{
		ArrayList<Reservation> listeReservations = new ArrayList<Reservation>();
		Connection con  = base.connexionBase();
		PreparedStatement pst = con.prepareStatement("SELECT * FROM Reservation where idUser = ?");
		pst.clearParameters();
		pst.setInt(1, idUser);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			Reservation resa = new Reservation();
			resa.setId(rs.getInt("id"));
			resa.setIdAnnonce(rs.getInt("idAnnonce"));
			resa.setIdUser(idUser);
			listeReservations.add(resa);
		}
		base.fermerConnexion(con);
		return listeReservations;
		
	}
	
	public void supprimerParId()throws SQLException{
		Connection con  = base.connexionBase();
		PreparedStatement pst = con.prepareStatement("delete from Reservation where id = ?");
		pst.clearParameters();
		pst.setInt(1, this.id);
        pst.executeUpdate();
        base.fermerConnexion(con);
	}
	
	
	public Reservation rechercherParIdUser(int idUser) throws SQLException{
		Connection con  = base.connexionBase();
		PreparedStatement pst = con.prepareStatement("SELECT * FROM Reservation where idUser = ?");
		pst.clearParameters();
		pst.setInt(1, idUser);
		ResultSet rs = pst.executeQuery();
		Reservation resa = new Reservation();
		if(rs.next())
		{
			resa.setId(rs.getInt("id"));
			resa.setIdAnnonce(rs.getInt("idAnnonce"));
			resa.setIdUser(idUser);
		}
		base.fermerConnexion(con);
		return resa;
		
	}
	

}
