package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Connexion la base de données */
		String url = "jdbc:mysql://localhost:3306/javashop"; // chaine de connexion
		String utilisateur = "root";
		String motDePasse = "";
		Connection connexion = null;
		Scanner clavier =  new Scanner(System.in);
		
		 try {

	            Class.forName("com.mysql.jdbc.Driver").newInstance(); // Installation du driver 
	            connexion =DriverManager.getConnection(url,utilisateur,motDePasse); // Connexion au driver 
	            /* Création de l'objet gérant les requêtes */
	            Statement statement = connexion.createStatement();
	            System.out.println("Donnez votre nom d'utilisateur : ");
	            String nu=clavier.nextLine();
	            System.out.println("Donnez votre mot de passe : ");
	            String mdp=clavier.nextLine();
	            ResultSet resultat = statement.executeQuery( "SELECT * FROM users WHERE username='"+nu+"' and password='"+mdp+"'" );
	            if(resultat.next()) {
	            	System.out.println("Bonjour");
	            }else {
	            	System.out.println("NO");
	            }
	            
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        }
		 
		 
	}

}
