import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int Userchoice = 0;
		while(Userchoice != 15) {
			Userchoice = menu();
			if(Userchoice == 1) {
				displayClient();
			} else if (Userchoice == 2) {
                displayAccount();
            } else if (Userchoice == 3) {
                displayCard();
            } else if (Userchoice == 4) {
                moneyTransfert();
            } else if (Userchoice == 5) {
                lookingForClient();
            } else if (Userchoice == 6) {
                addClient();
            } else if (Userchoice == 7) {
                addAccount();
            } else if (Userchoice == 8) {
                addCard();
            } else if (Userchoice == 9) {
                modifyClient();
            } else if (Userchoice == 10) {
                modifyAccount();
            } else if (Userchoice == 11) {
                modifyCard();
            } else if (Userchoice == 12) {
                deleteClient();
            } else if (Userchoice == 13) {
                deleteAccount();
            } else if (Userchoice == 14) {
                deleteCard();
            }
		}
    }

    public static void displayClient() throws Exception{
        Database.connect();
	    Statement statement = Database.connexion.createStatement();
	    ResultSet resultat = statement.executeQuery( "SELECT * FROM client" );
	    while ( resultat.next() ) {
	        int id = resultat.getInt( "id" );
	        String firstname = resultat.getString( "prenom" );
	        String age = resultat.getString( "age" );
            String city = resultat.getString( "ville" );
	        System.out.println("id : "+ id +"\t prenom : " + firstname +"\t age : "+ age +"\t vile : "+ city);
	   	}
    }

    public static void displayAccount() throws SQLException{
        Database.connect();
	    Statement statement = Database.connexion.createStatement();
	    ResultSet resultat = statement.executeQuery( "SELECT * FROM compte" );
	    while ( resultat.next() ) {
	        int id = resultat.getInt( "id" );
	        String rib = resultat.getString( "nb" );
	        String solde = resultat.getString( "solde" );
	        System.out.println("id : "+ id +"\t rib : " + rib +"\t solde : "+ solde);
	   	}
    }

    public static void displayCard() throws SQLException{
        Database.connect();
	    Statement statement = Database.connexion.createStatement();
	    ResultSet resultat = statement.executeQuery( "SELECT * FROM compte" );
	    while ( resultat.next() ) {
	        int id = resultat.getInt( "id" );
	        String rib = resultat.getString( "nb" );
	        String solde = resultat.getString( "solde" );
	        System.out.println("id : "+ id +"\t rib : " + rib +"\t solde : "+ solde);
	   	}
    }

    public static void addClient() throws SQLException {
        Database.connect();
        /* Flash */
        scanner.nextLine();
        System.out.println("Donnez le prenom du client : ");
	    String firstname = scanner.nextLine();
	    System.out.println("Donnez l'age du client : ");
	    String age = scanner.nextLine();
        System.out.println("Donnez la ville du client : ");
	    String city = scanner.nextLine();
	    
	    PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO client (prenom,age,ville) VALUES(?,?,?)");
	            
	    preparedStatement.setString(1,firstname);
	    preparedStatement.setString(2,age);
        preparedStatement.setString(3, city);
	    preparedStatement.executeUpdate();
    }

    public static void addAccount() throws Exception {
        Database.connect();
        /* Flash */
        scanner.nextLine();
        displayClient();
        System.out.println("Veuillez choisir un client : ");
        int userChoiceId = scanner.nextInt();
        System.out.println("Donnez le rib du client : ");
	    String rib = scanner.nextLine();
	    System.out.println("Donnez solde du client : ");
	    double solde = scanner.nextDouble();
	    
	    PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO compte (nb,solde,id_client) VALUES(?,?,?)");
	            
	    preparedStatement.setString(1,rib);
	    preparedStatement.setDouble(2,solde);
        preparedStatement.setInt(3, userChoiceId);
	    preparedStatement.executeUpdate();
    }

    public static void addCard() throws Exception{
        Database.connect();
        /* Flash */
        scanner.nextLine();
        displayAccount();
        System.out.println("Veuillez choisir un compte pour lie la carte : ");
        int userChoiceId = scanner.nextInt();
        System.out.println("Donnez le numero de carte : ");
	    String numcard = scanner.nextLine();
	    System.out.println("Donnez le type de la carte : ");
	    String typec = scanner.nextLine();
        System.out.println("Donnez la date d'expiration: ");
	    int anExp = scanner.nextInt();
	    
	    PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO carte (numero, typec, an_exp, id_compte) VALUES(?,?,?,?)");
	            
	    preparedStatement.setString(1,numcard);
	    preparedStatement.setString(2,typec);
        preparedStatement.setInt(3, anExp);
        preparedStatement.setInt(4, userChoiceId);
	    preparedStatement.executeUpdate();;
    }
    public static void modifyClient() throws Exception {
        Database.connect();
        /* Flash */
        displayClient();
        scanner.nextLine();
        System.out.println("Donnez l'id du client a modifier: ");
	    String userChoiceId = scanner.nextLine();
        System.out.println("Donnez le prenom du client : ");
	    String firstname = scanner.nextLine();
	    System.out.println("Donnez l'age du client : ");
	    String age = scanner.nextLine();
        System.out.println("Donnez la ville du client : ");
	    String city = scanner.nextLine();
	    
	    PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE client SET prenom = ?, age = ?, ville = ? WHERE id = ?");
	    
        preparedStatement.setString(4, userChoiceId);
	    preparedStatement.setString(1,firstname);
	    preparedStatement.setString(2,age);
        preparedStatement.setString(3, city);
	    preparedStatement.executeUpdate();
    }
    
    public static void modifyAccount () throws Exception {
        Database.connect();
        /* Flash */
        displayAccount();
        scanner.nextLine();
        System.out.println("Veuillez choisir un compte : ");
        int userChoiceId = scanner.nextInt();
        System.out.println("Donnez le nouveau rib du client : ");
	    String rib = scanner.nextLine();
	    System.out.println("Donnez le nouveau solde du client : ");
	    double solde = scanner.nextDouble();
	    
	    PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE client SET nb = ?, solde = ? WHERE id = ?");
	    
        preparedStatement.setInt(3, userChoiceId);
	    preparedStatement.setString(1,rib);
	    preparedStatement.setDouble(2,solde);
	    preparedStatement.executeUpdate();
    }

    public static void modifyCard() throws Exception {
        Database.connect();
        /* Flash */
        displayCard();
        scanner.nextLine();
        System.out.println("Veuillez choisir une carte : ");
        int userChoiceId = scanner.nextInt();

        System.out.println("Donnez le nouveau numero de la carte : ");
	    String nbCarte = scanner.nextLine();

	    System.out.println("Donnez le nouveau type de carte: ");
	    String typeC = scanner.nextLine();

        System.out.println("Donnez la nouvelle date d'expiration de la carte: ");
	    int an_exp = scanner.nextInt();
	    
	    PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE carte SET numero = ?, typec = ?, an_exp = ?, WHERE id = ?");
	    
        preparedStatement.setInt(4, userChoiceId);
	    preparedStatement.setString(1,nbCarte);
	    preparedStatement.setString(2,typeC);
        preparedStatement.setInt(3, an_exp);
	    preparedStatement.executeUpdate();
    }
    public static void deleteClient() throws Exception {
        Database.connect();
        /* Flash */
        displayClient();
        scanner.nextLine();
        System.out.println("Donnez l'id du client a supprimer: ");
	    int userChoiceId = scanner.nextInt();
        
	    PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT id FROM client WHERE id = ?");
        preparedStatement.setInt(1, userChoiceId);
        ResultSet result = preparedStatement.executeQuery();
	    if (!result.next()) {
            System.out.println("Il n'y a pas de client a supprimer.");
            return;
	   	} 

        /*Delete ALL from there*/
        preparedStatement = Database.connexion.prepareStatement("DELETE FROM carte WHERE id_compte IN (SELECT id FROM compte WHERE id_client = ?)");
        preparedStatement.setInt(1, userChoiceId);
        preparedStatement.executeUpdate();

        preparedStatement = Database.connexion.prepareStatement("DELETE FROM compte WHERE id_client = ?");
        preparedStatement.setInt(1, userChoiceId);
        preparedStatement.executeUpdate();

        preparedStatement = Database.connexion.prepareStatement("DELETE FROM client WHERE id = ?");
        preparedStatement.setInt(1, userChoiceId);
        preparedStatement.executeUpdate();
    }

    public static void deleteAccount() throws Exception {
        Database.connect();
        /* Flash */
        displayAccount();
        scanner.nextLine();
        System.out.println("Donnez l'id du compte : ");
	    int userChoiceId = scanner.nextInt();
        
	    PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT id FROM compte WHERE id = ?");
        preparedStatement.setInt(1, userChoiceId);
        ResultSet result = preparedStatement.executeQuery();
	    if (!result.next()) {
            System.out.println("Il n'y a pas de compte a supprimer.");
            return;
	   	} 

        /*Delete ALL from there*/
        preparedStatement = Database.connexion.prepareStatement("DELETE FROM carte WHERE id_compte = ?");
        preparedStatement.setInt(1, userChoiceId);
        preparedStatement.executeUpdate();

        preparedStatement = Database.connexion.prepareStatement("DELETE FROM compte WHERE id = ?");
        preparedStatement.setInt(1, userChoiceId);
        preparedStatement.executeUpdate();
    }

    public static void deleteCard() throws Exception {
        Database.connect();
        /* Flash */
        displayAccount();
        scanner.nextLine();
        System.out.println("Donnez l'id de la carte : ");
	    int userChoiceId = scanner.nextInt();
        
	    PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT id FROM carte WHERE id = ?");
        preparedStatement.setInt(1, userChoiceId);
        ResultSet result = preparedStatement.executeQuery();
	    if (!result.next()) {
            System.out.println("Il n'y a pas de carte a supprimer.");
            return;
	   	} 

        /*Delete ALL from there*/
        preparedStatement = Database.connexion.prepareStatement("DELETE FROM carte WHERE id = ?");
        preparedStatement.setInt(1, userChoiceId);
        preparedStatement.executeUpdate();
    }

    public static void moneyTransfert() {
        return ;
    }

    public static void lookingForClient() {
        return ;
    }
    public static int menu() {
        System.out.println("---- MENU ----");
        System.out.println("1 - Liste des clients");
        System.out.println("2 - Liste des comptes");
        System.out.println("3 - Liste des cartes");
        System.out.println("4 - Virer de l'argent");
        System.out.println("5 - Rechercher un client");
        System.out.println("6 - Ajouter un client");
        System.out.println("7 - Ajouter un compte");
        System.out.println("8 - Ajouter une carte");
        System.out.println("9 - Modifier un client");
        System.out.println("10 - Modifier un compte");
        System.out.println("11 - Modifier une carte");
        System.out.println("12 - Supprimer un client");
        System.out.println("13 - Supprimer un compte");
        System.out.println("14 - Supprimer une carte");
        System.out.println("15 - Quitter");
        System.out.println("Votre choix : ");
        return scanner.nextInt();
    }
}
