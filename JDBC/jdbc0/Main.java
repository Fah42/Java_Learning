package jdbc0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Connexion la base de données */
		String url = "jdbc:mysql://localhost:3306/javashop";
		String utilisateur = "root";
		String motDePasse = "";
		Connection connexion = null;
		
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
	         connexion =DriverManager.getConnection(url,utilisateur,motDePasse);
	         /* Création de l'objet gérant les requêtes */
	         Statement statement = connexion.createStatement();
	         /* Exécution d'une requête de lecture */
	         ResultSet resultat = statement.executeQuery( "SELECT * FROM users" );
	         /* Récupération des données du résultat de la requête de lecture */
	         while ( resultat.next() ) {
	        	 int id = resultat.getInt( "id" );
	        	 String username = resultat.getString( "username" );
	        	 String password = resultat.getString( "password" );
	        	 System.out.println("id : "+id+"\t username : " + username+"\t password : "+password);
	   	     }
	      } catch (Exception ex) {
	    	  ex.printStackTrace();
	    	  System.out.println("PROBLEME CONNEXION DB");
	      }
		 
		 
	}

}
