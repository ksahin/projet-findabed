package com.findabed.modeles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hsqldb.jdbc.JDBCDataSource;

public class Database {
	//static final String cheminBase = "jdbc:hsqldb:file:C:/Users/IUT/Documents/Projet/workspace/FindAbed/base";
	static final String cheminBase = "jdbc:hsqldb:file:base";
	static final String login = "SA";
	static final String mdp = "";
	static final String driver = "org.hsqldb.jdbc.JDBCDriver";
	
	
	public Connection connexionBase(){
		Connection con = null;
		try{
			 Class.forName(driver);
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

