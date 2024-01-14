package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {

			 Database.connect();
	         Statement statement = Database.connexion.createStatement();
	         ResultSet resultat = statement.executeQuery( "SELECT * FROM users" );
	         while ( resultat.next() ) {
	        	 int id = resultat.getInt( "id" );
	        	 String username = resultat.getString( "username" );
	        	 String password = resultat.getString( "password" );
	        	 System.out.println("id : "+id+"\t username : " + username+"\t password : "+password);
	   	     }
	     
		 
		 
	}

}
