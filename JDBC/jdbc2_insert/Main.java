package jdbc2_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Connexion la base de données */
		String url = "jdbc:mysql://localhost:3306/javashop";
		String utilisateur = "root";
		String motDePasse = "";
		Connection connexion = null;
		Scanner clavier =  new Scanner(System.in);
		
		 try {

	            Class.forName("com.mysql.jdbc.Driver").newInstance();;
	            connexion =DriverManager.getConnection(url,utilisateur,motDePasse);
	            
	            
	            
	            
	            System.out.println("Donnez votre nom d'utilisateur : ");
	            String nu=clavier.nextLine();
	            System.out.println("Donnez votre mot de passe : ");
	            String mdp=clavier.nextLine();
	            
	            PreparedStatement preparedStatement  = connexion.prepareStatement("INSERT INTO users (username,password) VALUES(?,?)");
	            
	            preparedStatement.setString(1,nu);
	            preparedStatement.setString(2,mdp);
	            
	            preparedStatement.executeUpdate();
	            
	           
	           
	            
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        }
		 
		 
	}



}
