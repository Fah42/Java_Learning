package CRUD;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Client> colClients = new ArrayList<>();
    public static void main(String[] args) {
        int choix=0;
		while(choix!=6) {
			choix=menu();
			if(choix==1) {
				afficherClient();
			}else if(choix==2) {
				ajouterClient();
			}else if(choix==3) {
				supprimerClient();
			}else if(choix==4) {
				rechercherClient();
			}else if(choix==5) {
				modifierClient();
			}
		}
    }
    public static int getClientIndexById() {
        int userChoice;
        int index = -1;

        afficherClient();

        System.out.println("Veuillez taper l'ID du client : ");
        userChoice = scanner.nextInt();

        for (int i = 0; i < colClients.size(); i++) {
            if (colClients.get(i).getId() == userChoice) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Il n'y a pas de client avec cet ID");
            return index;
        } else {
            return index;
        }
    }
    public static void afficherClient() {

        if (colClients.isEmpty()) {
            System.out.println("--------------------");
            System.out.println("Aucun client enregistré.");
            System.out.println("--------------------");
        } else {
            System.out.println("--------------------\n");
            System.out.println("Liste des Clients\n");
            System.out.println("--------------------\n");
            for (Client val:colClients) {
                System.out.println("--------------------\n");
                System.out.println(val);
                System.out.println("\n--------------------");
            }
        }
    }
    
    public static void ajouterClient() {
        String lastName;
        String firstName;
        String town;
        int age;

        System.out.println("--------------------");
        System.out.println("Ajout d'un client");
        System.out.println("--------------------");

        /*flash*/
        scanner.nextLine();
        System.out.println("Veuillez entrer le nom du client : ");
        lastName = scanner.nextLine();

        System.out.println("Veuillez entrer le prenom du client : ");
        firstName = scanner.nextLine();

        System.out.println("Veuillez entrer la ville du client : ");
        town = scanner.nextLine();

        System.out.println("Veuillez entrer l'age du client : ");
        age = scanner.nextInt();

        colClients.add(new Client(age, lastName, firstName, town));
        System.out.println("--------------------");
        System.out.println("Insertion Reussie");
        System.out.println("--------------------");
    }

    public static void supprimerClient() {
        int userChoice;

        System.out.println("--------------------");
        System.out.println("Suppression d'un client");
        System.out.println("--------------------");

        userChoice = getClientIndexById();

        if (userChoice == -1) {
            System.out.println("Il n'y a pas de client avec cet ID");
        } else {
            colClients.remove(userChoice);
            System.out.println("Le client a bien ete supprime !");
        }

    }

    public static void rechercherClient() {
        String userInput;

        System.out.println("--------------------");
        System.out.println("Recherche d'un client");
        System.out.println("--------------------");

        /*flash*/
        scanner.nextLine();

        System.out.println("Veuillez entrer un mot recherche : ");
        userInput = scanner.nextLine();

        for (Client val : colClients) {
            if (val.getNom().toLowerCase().contains(userInput.toLowerCase()) || 
                val.getPrenom().toLowerCase().contains(userInput.toLowerCase()) ||
                val.getVille().toLowerCase().contains(userInput.toLowerCase())) {
                    System.out.println(val);
            }
        }
    }

    public static void modifierClient() {
        int userInput;
        System.out.println("--------------------");
        System.out.println("Modifier un client");
        System.out.println("--------------------");

        userInput = getClientIndexById();
        if (userInput == -1) {
            System.out.println("Le client n'existe pas");
        } else {
            /*Flash*/
            scanner.nextLine();

            Client client = colClients.get(userInput);
			System.out.println("Prenom (" + client.getPrenom() + ") : ");
			client.setPrenom(scanner.nextLine());
			System.out.println("Nom (" + client.getNom() + ") : ");
			client.setNom(scanner.nextLine());
            System.out.println("Ville (" + client.getVille() + ") :");
            client.setVille(scanner.nextLine());
            System.out.println("Age (" + client.getAge() + ") :");
            client.setAge(scanner.nextInt());
			//colClients.set(userInput, client);
        }
    }

    public static int menu() {
        System.out.println("------ MENU ------");
		System.out.println("1 - Liste les clients");
		System.out.println("2 - Ajouter un client");
		System.out.println("3 - Supprimer un client");
		System.out.println("4 - Rechercher un client");
		System.out.println("5 - Modifier un client");
		System.out.println("6 - Quitter");
		System.out.println("------------------");
		System.out.println("Votre choix : ");
		int choice = scanner.nextInt();
		return choice;
    }
}
