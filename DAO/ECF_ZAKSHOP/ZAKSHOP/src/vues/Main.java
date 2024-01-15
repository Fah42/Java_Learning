package vues;

import dao.*;
import entites.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Database.connect();
        
        int Userchoice = 0;
        while (Userchoice != 0) {
            Userchoice = menu();
            if (Userchoice == 1) {
                
            } else if (Userchoice == 2) {
                   
            } else if (Userchoice == 3) {
                
            } else if (Userchoice == 4) {

            } else if (Userchoice == 5) {
                    
            } else if (Userchoice == 6) {
                displayClient();
            } else if (Userchoice == 7) {
                addClient();
            } else if (Userchoice == 8) {

            } else if (Userchoice == 9) {
                    
            } else if (Userchoice == 10) {
                    
            } else if (Userchoice == 11) {
                    
            } else if (Userchoice == 12) {
                    
            } else if (Userchoice == 13) {
                    
            } else if (Userchoice == 14) {
                    
            } else if (Userchoice == 15) {
                    
            } else if (Userchoice == 16) {
                    
            } else if (Userchoice == 17) {
                    
            } else if (Userchoice == 18) {
                    
            } else if (Userchoice == 19) {
                    
            } else if (Userchoice == 20) {
                    
            } else if (Userchoice == 21) {
                    
            } else if (Userchoice == 22) {
                    
            } else if (Userchoice == 23) {
                    
            } else if (Userchoice == 23) {
                    
            } else if (Userchoice == 24) {
                    
            } else if (Userchoice == 25) {
                    
            } else if (Userchoice == 26) {
                    
            } else if (Userchoice == 27) {
                    
            } else if (Userchoice == 28) {
                    
            } else if (Userchoice == 29) {
                    
            }
        }
    }

    public static void displayClient() {
        ArrayList<Client> clients = new ArrayList<>();
        ClientDAO cdao = new ClientDAO();

        clients = cdao.getAll();

        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public static void addClient() {
        Client c = new Client();
        ClientDAO cdao = new ClientDAO();

        System.out.println("Veuillez entrer le nom : ");
        String lastname = scanner.nextLine();
        System.out.println("Veuillez entrer le prenom : ");
        String firstname = scanner.nextLine();
        System.out.println("Veuillez entrer la ville : ");
        String city = scanner.nextLine();
        System.out.println("Veuillez entrer l'age : ");
        int age = scanner.nextInt();

        c.setPrenom(firstname);
        c.setNom(lastname);
        c.setAge(age);
        c.setVille(city);

        cdao.save(c);
    }

    public static void modifyClient() {
        ClientDAO cdao = new ClientDAO();

        displayClient();

        System.out.println("Veuillez entrer l'id du client a modifier : ");
        int Userchoice = scanner.nextInt();
        Client c = cdao.getById(Userchoice);

        if (c != null) {
            System.out.println("Veuillez entrer le nom : ");
            String lastname = scanner.nextLine();
            System.out.println("Veuillez entrer le prenom : ");
            String firstname = scanner.nextLine();
            System.out.println("Veuillez entrer la ville : ");
            String city = scanner.nextLine();
            System.out.println("Veuillez entrer l'age : ");
            int age = scanner.nextInt();

            c.setPrenom(firstname);
            c.setNom(lastname);
            c.setAge(age);
            c.setVille(city);

            cdao.save(c);
        } else {
            System.out.println("Erreur, ID invalide");
        }
    }

    public static void deleteClient() {
        ClientDAO cdao = new ClientDAO();

        displayClient();

        System.out.println("Veuillez entrer l'id du client a supprimer : ");
        int userChoice = scanner.nextInt();

        if (cdao.getById(userChoice) != null) {
            cdao.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }
    public static int menu() {
        System.out.println("---- MENU ----");
        System.out.println("1- Liste des Produits");
        System.out.println("2- Ajouter un Produit");
        System.out.println("3- Modifier un Produit");
        System.out.println("4- Supprimer un Produit");
        System.out.println("5- Rechercher un Produit");
        System.out.println("6- Liste des Clients");
        System.out.println("7- Ajouter un Client");
        System.out.println("8- Modifier un Client");
        System.out.println("9- Supprimer un Client");
        System.out.println("10- Rechercher un Client");
        System.out.println("11- Liste des Catégories");
        System.out.println("12- Ajouter une Catégorie");
        System.out.println("13- Modifier une Catégorie");
        System.out.println("14- Supprimer une Catégorie");
        System.out.println("15- Liste des Commandes");
        System.out.println("16- Passer une Commande");
        System.out.println("17- Supprimer une Commande");
        System.out.println("18-  Liste des Fournisseurs");
        System.out.println("19- Ajouter un Fournisseur");
        System.out.println("20- Modifier un Fournisseur");
        System.out.println("21- Supprimer un Fournisseur");
        System.out.println("22- Rechercher un Fournisseur");
        System.out.println("23- Liste des entrées en Stock");
        System.out.println("24- Ajouter une entrée en Stock");
        System.out.println("25- Supprimer une entrée en Stock");
        System.out.println("26- Liste des Paiements");
        System.out.println("27- Effectuer un Paiement");
        System.out.println("28- Modifier un Paiement");
        System.out.println("29- Supprimer un Paiement");
        System.out.println("0- Quitter");
        return scanner.nextInt();
    }
}
