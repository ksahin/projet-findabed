package com.findabed.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
	static final String cheminBase = "jdbc:hsqldb:file:H:/Bureau/Projet Agile/database/";
	static final String login = "SA";
	static final String mdp = "";
	public Connection connexionBase(){
		Connection con = null;
		try{
			 Class.forName("org.hsqldb.jdbc.JDBCDriver");
			 con = DriverManager.getConnection(cheminBase,login,mdp);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace(); 
		}
		return con;	
	}
	
	public void fermerConnexion(Connection con){
		try {
				PreparedStatement shutdown = con.prepareStatement("SHUTDOWN");
				shutdown.executeUpdate();
				con.close();				
        } catch (SQLException e) {
        	e.printStackTrace(System.out);
        }  
	}
	
    
}


