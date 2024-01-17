package vues;

import dao.*;
import entites.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Database.connect();
        
        int userChoice = 99;
        while (userChoice != 0) {
            userChoice = menu();
            if (userChoice == 1) {
                displayProduct();
            } else if (userChoice == 2) {
                addProduct();
            } else if (userChoice == 3) {
                modifyProduct();
            } else if (userChoice == 4) {
                deleteProduct();
            } else if (userChoice == 5) {
                searchProduct();
            } else if (userChoice == 6) {
                displayClient();
            } else if (userChoice == 7) {
                addClient();
            } else if (userChoice == 8) {
                modifyClient();
            } else if (userChoice == 9) {
                deleteClient();
            } else if (userChoice == 10) {
                searchClient();
            } else if (userChoice == 11) {
                displayCategorie();
            } else if (userChoice == 12) {
                addCategorie();
            } else if (userChoice == 13) {
                modifyCategorie();
            } else if (userChoice == 14) {
                deleteCategorie(); 
            } else if (userChoice == 15) {
                displayOrder();
            } else if (userChoice == 16) {
                addOrder();
            } else if (userChoice == 17) {
                deleteOrder();  
            } else if (userChoice == 18) {
                displaySupplier();
            } else if (userChoice == 19) {
                addSupplier();
            } else if (userChoice == 20) {
                modifySupplier();
            } else if (userChoice == 21) {
                deleteSupplier();
            } else if (userChoice == 22) {
                searchSupplier();
            } else if (userChoice == 23) {
                displayStock();
            } else if (userChoice == 24) {
                addStock();
            } else if (userChoice == 25) {
                deleteStock();
            } else if (userChoice == 26) {
                displayPaiement();
            } else if (userChoice == 27) {
                addPaiement();
            } else if (userChoice == 28) {
                modifyPaiement();
            } else if (userChoice == 29) {
                deletePaiement(); 
            }
        }
    }

    public static void displayProduct() {
        ArrayList<Produit> produits = new ArrayList<>();
        ProduitDAO pdao = new ProduitDAO();

        produits = pdao.getAll();

        System.out.print("------ Affichage des Produits ------\n");
        for (Produit produit : produits) {
            System.out.println(produit);
        }
    }

    public static void addProduct() {
        ProduitDAO produitDAO = new ProduitDAO();
        Produit produit = new Produit();
        CategorieDAO categorieDAO = new CategorieDAO();
        String title;
        int id_categorie;
        int stock;
        Double price;
        boolean isTitleValid = false;
        
        System.out.println("------ Ajout de Produit ------");
        displayCategorie();

        while (true) {
            System.out.println("Veuillez choisir à quelle catégorie appartiendra le produit en sélectionnant l'id correspondant, en utilisant uniquement des caractères numériques : ");
            if (scanner.hasNextInt()) {
                id_categorie = scanner.nextInt();
                if(categorieDAO.getById(id_categorie) != null) {
                    produit.setId_categorie(id_categorie);
                    scanner.next();
                    break;
                }
                System.out.println("Veuillez entrer un ID existant : ");
                scanner.next();
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next();
            }
        }

        while (!isTitleValid) {
            System.out.println("Veuillez entrer le nom du produit : ");
            title = scanner.nextLine();
    
            if (produit.setTitre(title)) {
                isTitleValid = true;
            } else {
                System.out.println("Le titre entré n'est pas valide. Veuillez réessayer.");
            }
        }
        
        while (true) {
            System.out.println("Veuillez entrer le prix du produit uniquement en valeur numerique : ");
            if (scanner.hasNextDouble()){
                price = scanner.nextDouble();
                produit.setPrix(price);
                scanner.next();
                break;
            } else {
                System.out.print("La somme entré n'est pas valide. Veuillez réessayer.");
            }
        }

        
        while(true) {
            System.out.println("Veuillez entrer le nombre de produit uniquement en valeur numerique : ");
            if (scanner.hasNextInt()){
                stock = scanner.nextInt();
                produit.setStock(stock);
                scanner.next();
                break;
            } else {
                System.out.println("Le nombre de produit entré n'est pas valide. Veuillez réessayer.");
            }
        }
        System.out.println("Ajout reussi !");
        produitDAO.save(produit);
    }

    public static void modifyProduct() {
        ProduitDAO produitDAO = new ProduitDAO();
        Produit produit; 
        CategorieDAO categorieDAO = new CategorieDAO();
        String title;
        int userChoice;
        int id_categorie;
        int stock;
        Double price;
        boolean isTitleValid = false;

        System.out.println("------ Modification de Produit ------");

        while (true) {
            displayProduct();
            System.out.println("Veuillez entrer l'id du produit à modifier, uniquement en valeur numérique : ");
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                produit = produitDAO.getById(userChoice);
                if (produit != null) {
                    scanner.next();
                    break;
                } else {
                    System.out.println("L'ID entré n'est pas valide. Veuillez réessayer.");
                    scanner.next();
                }
            } else {
                System.out.println("L'entrée n'est pas un nombre valide. Veuillez entrer un nombre entier.");
                scanner.next();
            }
        }

        while (true) {
            displayCategorie();
            if (scanner.hasNextInt()) {
                System.out.println("Veuillez choisir a quel categorie appartiendra le produit en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
                id_categorie = scanner.nextInt();
                scanner.nextLine();
                if (categorieDAO.getById(id_categorie) != null) {
                    produit.setId_categorie(id_categorie);
                    break;
                }
                System.out.println("Veuillez entrer un ID existant : ");
            } else {
                System.out.println("L'entrée n'est pas un nombre valide. Veuillez entrer un nombre entier."); 
            }
        }

        while (!isTitleValid) {
            System.out.println("Veuillez entrer le nom du produit : ");
            title = scanner.nextLine();
    
            if (produit.setTitre(title)) {
                isTitleValid = true;
            } else {
                System.out.println("Le titre entré n'est pas valide. Veuillez réessayer.");
            }
        }

        while (true) {
            System.out.println("Veuillez entrer le prix du produit uniquement en valeur numerique : ");
            if (scanner.hasNextDouble()){
                price = scanner.nextDouble();
                produit.setPrix(price);
                scanner.next();
                break;
            } else {
                System.out.print("La somme entré n'est pas valide. Veuillez réessayer.");
            }
        }

        while(true) {
            System.out.println("Veuillez entrer le nombre de produit uniquement en valeur numerique : ");
            if (scanner.hasNextInt()){
                stock = scanner.nextInt();
                produit.setStock(stock);
                scanner.next();
                break;
            } else {
                System.out.println("La somme entré n'est pas valide. Veuillez réessayer.");
            }
        }

        produitDAO.save(produit);
        System.out.println("Modification reussi !");
    }

    public static void deleteProduct() {
        ProduitDAO produitDAO = new ProduitDAO();
        Entree_stockDAO entree_stockDAO = new Entree_stockDAO();
        DetailDAO detailDAO = new DetailDAO();
        int userChoice;

        System.out.println("------ Suppresion d'un Produit ------");
        displayProduct();
        System.out.println("Veuillez entrer l'id du produit a supprimer en utilisant uniquement des chiffres : ");
        userChoice = scanner.nextInt();
    
        if (produitDAO.getById(userChoice) != null) {
            produitDAO.deleteById(userChoice);
            if (detailDAO.getByIdProduct(userChoice) != null) {
                detailDAO.deleteByIdProduct(userChoice);
            }
            if (entree_stockDAO.getByIdProduct(userChoice) != null) {
                entree_stockDAO.deleteByIdProduct(userChoice);
            }
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void searchProduct() {
        ArrayList<Produit> searchResults = new ArrayList<>();
        ProduitDAO produitDAO =  new ProduitDAO();
        String search;

        System.out.println("------ Recherche d'un Produit ------");
        System.out.println("Veuillez entrer le terme de la recherche ");
        search = scanner.nextLine();

        searchResults = produitDAO.searchProduct(search);
        if (searchResults != null) {
            System.out.println("Resultat de la recherche : ");
            for (Produit produit : searchResults) {
                System.out.println(produit);
            }
        } else {
            System.out.println("Aucun resultat trouve pour : " + search);
        }
    }

    public static void displayClient() {
        ArrayList<Client> clients = new ArrayList<>();
        ClientDAO clientDAO = new ClientDAO();

        clients = clientDAO.getAll();

        System.out.print("------ Affichage des Clients ------\n");
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    
    public static void addClient() {
        Client client = new Client();
        ClientDAO clientDAO = new ClientDAO();
        String lastname;
        String firstname;
        String city;
        int age;
        boolean isInputValid = false;

        System.out.println("------ Ajout de Client ------");

        while(!isInputValid){
            System.out.println("Veuillez entrer le nom du client : ");
            lastname = scanner.nextLine();

            if (client.setNom(lastname)){
                isInputValid = true;
            } else {
                System.out.println("Le nom entré n'est pas valide. Veuillez réessayer.");
            }
        }
        isInputValid = false;

        while(!isInputValid){
            System.out.println("Veuillez entrer le prenom du client : ");
            firstname = scanner.nextLine();

            if (client.setPrenom(firstname)){
                isInputValid = true;
            } else {
                System.out.println("Le prenom entré n'est pas valide. Veuillez réessayer.");
            }
        }
        isInputValid = false;

        while(!isInputValid){
            System.out.println("Veuillez entrer le prenom du client : ");
            firstname = scanner.nextLine();

            if (client.setPrenom(firstname)){
                isInputValid = true;
            } else {
                System.out.println("Le prenom entré n'est pas valide. Veuillez réessayer.");
            }
        }
        isInputValid = false;

        while(!isInputValid){
            System.out.println("Veuillez entrer le ville du client : ");
            city = scanner.nextLine();

            if (client.setPrenom(city)){
                isInputValid = true;
            } else {
                System.out.println("La ville entré n'est pas valide. Veuillez réessayer.");
            }
        }

        while(true) {
            System.out.println("Veuillez entrer l'age uniquement en valeur numerique : ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                client.setAge(age);
                scanner.next();
                break;
            } else {
                System.out.println("Valeur invalide.");
            }
        }

        clientDAO.save(client);
    }

    public static void modifyClient() {
        ClientDAO clientDAO = new ClientDAO();
        Client client = new Client();
        String lastname;
        String firstname;
        String city;
        int age;
        int userChoice;
        boolean isInputValid = false;

        System.out.println("------ Modification de Client ------");
        
        while(true){
            displayClient();
            System.out.println("Veuillez entrer l'id du client a modifier : ");
            if(scanner.hasNextInt()){
                userChoice = scanner.nextInt();
                client = clientDAO.getById(userChoice);
                if(client != null) {
                    scanner.next();
                    break;
                }
                System.out.println("Veuillez entrer un ID existant : ");
                scanner.next();
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next();
            }
        }

        while (!isInputValid) {
            System.out.println("Veuillez entrer le nom : ");
            lastname  = scanner.nextLine();

            if(client.setNom(lastname)) {
                isInputValid = true;
            } else {
                System.out.println("Le nom entré n'est pas valide. Veuillez réessayer.");
            }
        }
        isInputValid = false;

        while (!isInputValid) {
            System.out.println("Veuillez entrer le prenom : ");
            firstname  = scanner.nextLine();

            if(client.setPrenom(firstname)) {
                isInputValid = true;
            } else {
                System.out.println("Le prenom entré n'est pas valide. Veuillez réessayer.");
            }
        }
        isInputValid = false;

        while (!isInputValid) {
            System.out.println("Veuillez entrer la ville : ");
            city  = scanner.nextLine();

            if(client.setVille(city)) {
                isInputValid = true;
            } else {
                System.out.println("La ville entré n'est pas valide. Veuillez réessayer.");
            }
        }
       
        while(true) {
            System.out.println("Veuillez entrer l'age uniquement en valeur numerique : ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                client.setAge(age);
                scanner.next();
                break;
            } else {
                System.out.println("Valeur invalide.");
            }
        }
        clientDAO.save(client);
    }

    public static void deleteClient() {
        ClientDAO clientDAO = new ClientDAO();
        System.out.println("------ Suppresion de Client ------");
        displayClient();

        System.out.println("Veuillez entrer l'id du client a supprimer : ");
        if(scanner.hasNextInt()){
            int userChoice = scanner.nextInt();
            if (clientDAO.getById(userChoice) != null) {
                clientDAO.deleteById(userChoice);
            } else {
                System.out.println("Erreur ID inexistant");
            }
        } else {
            System.out.println("Erreur veuillez entrer une valeur numerique");
        }
    }

    public static void searchClient() {
        ClientDAO clientDAO =  new ClientDAO();
        ArrayList<Client> searchResults = new ArrayList<>();
        String search;

        System.out.println("------ Recherche de Client ------");
        System.out.println("Veuillez entrer le terme de la recherche ");
        search = scanner.nextLine();
        searchResults = clientDAO.searchClients(search);
        
        if (searchResults != null) {
            System.out.println("Resultat de la recherche : ");
            for (Client client : searchResults) {
                System.out.println(client);
            }
        } else {
            System.out.println("Aucun resultat trouve pour : " + search);
        }
    }

    public static void displayCategorie() {
        ArrayList<Categorie> categories = new ArrayList<>();
        CategorieDAO clientDAO = new CategorieDAO();

        categories = clientDAO.getAll();

        System.out.print("------ Affichage des Categories ------\n");
        for (Categorie categorie : categories) {
            System.out.println(categorie);
        }
    }

    public static void addCategorie() {
        CategorieDAO categorieDAO = new CategorieDAO();
        Categorie categorie = new Categorie();
        String title;
        boolean isInputValid = false;

        System.out.println("------ Ajout de Categorie ------");
        displayCategorie();

        while(!isInputValid){
            System.out.println("Veuillez entrer le nom de la categorie: ");
            title = scanner.nextLine();
            if (categorie.setTitre(title)) {
                isInputValid = true;
            } else {
                System.out.println("Le nom de la categorie entré n'est pas valide. Veuillez réessayer.");
            }
        }
        categorieDAO.save(categorie);
    }
    
    public static void modifyCategorie() {
        CategorieDAO clientDAO = new CategorieDAO();
        Categorie categorie = new Categorie();
        String titre;
        int userChoice;
        boolean isInputValid = false;

        System.out.println("------ Modification de Categorie ------");
        displayCategorie();

        while(true) {
            System.out.println("Veuillez entrer l'id de la categorie a modifier : ");
            if(scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                categorie = clientDAO.getById(userChoice);
                    if(categorie != null) {
                        scanner.next();
                        break;
                    } else {
                        System.out.println("Entrée invalide.");
                        scanner.next();
                    }
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next();
            }
        }

        while(!isInputValid) {
            System.out.println("Ancien nom : " + categorie.getTitre() + "\nVeuillez entrer le nouveau titre : ");
            titre = scanner.nextLine();

            if(categorie.setTitre(titre)) {
                isInputValid = true;
            } else {
                System.out.println("Le titre de la categorie entré n'est pas valide. Veuillez réessayer.");
            }
        }
        clientDAO.save(categorie);
    }

    public static void deleteCategorie() {
        CategorieDAO categorieDAO = new CategorieDAO();
        ProduitDAO produitDAO = new ProduitDAO();
        int userChoice;

        System.out.println("------ Suppresion d'une Categorie ------");
        displayCategorie();

        System.out.println("Veuillez entrer l'id de la categorie a supprimer : ");
        if(scanner.hasNextInt()) {
            userChoice = scanner.nextInt();
            if (categorieDAO.getById(userChoice) != null) {
                if(produitDAO.getByIdCategorie(userChoice) != null) {
                    produitDAO.deleteByIdCategorie(userChoice);
                }
                categorieDAO.deleteById(userChoice);
            } else {
                System.out.println("Erreur ID invalide");
            }
        } else {
            System.out.println("Erreur veuillez entrer une valeur numerique");
        }
    }

    public static void displayOrder() {
        ArrayList<Commande> commandes = new ArrayList<>();
        CommandeDAO clientDAO = new CommandeDAO();

        commandes = clientDAO.getAll();

        System.out.print("------ Affichage des Commandes ------\n");
        for (Commande commande : commandes) {
            System.out.println(commande);
        }
    }

    public static void addOrder() {
        CommandeDAO commandeDAO = new CommandeDAO();
        ClientDAO clientDAO = new ClientDAO();
        Commande commande = new Commande();
        int id_client;

        System.out.println("------ Ajout de Commande ------");
        while(true) {
            displayClient();
            System.out.println("Veuillez Choisir a quel client appartiendra la commande en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
            if(scanner.hasNextInt()) {
                id_client = scanner.nextInt();
                if (clientDAO.getById(id_client) != null) {
                    commande.setId_client(id_client);
                    scanner.next();
                    break;
                } else {
                    System.out.println("Veuillez entrer un ID existant : ");
                    scanner.next();
                }
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next();
            }
        }
        commandeDAO.save(commande);
    }

    public static void deleteOrder() {
        CommandeDAO commandeDAO = new CommandeDAO();
        DetailDAO detailDAO = new DetailDAO();
        PaiementDAO paiementDAO = new PaiementDAO();
        int userChoice;

        System.out.println("------ Suppresion d'une Commande ------");
        displayOrder();

        System.out.println("Veuillez entrer l'id de la commande a supprimer : ");
        if(scanner.hasNextInt()) {
            userChoice = scanner.nextInt();
            if (commandeDAO.getById(userChoice) != null) {
                if (detailDAO.getByIdCommande(userChoice) != null) {
                    detailDAO.deleteByIdCommande(userChoice);
                }
                if (paiementDAO.getByIdCommande(userChoice) != null) {
                    paiementDAO.deleteByIdCommande(userChoice);
                }
                commandeDAO.deleteById(userChoice);
            } else {
                System.out.println("Veuillez entrer un ID existant : ");
            }
        } else {
            System.out.println("Entrée invalide. Veuillez entrer un nombre.");
        }
    }

    public static void displaySupplier() {
        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
        FournisseurDAO fournisseurDAO = new FournisseurDAO();

        fournisseurs = fournisseurDAO.getAll();

        System.out.print("------ Affichage des Produits ------\n");
        for (Fournisseur produit : fournisseurs) {
            System.out.println(produit);
        }
    }
    
    public static void addSupplier() {
        Fournisseur fournisseur = new Fournisseur();
        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        boolean isInputValid = false;
        String name;
        String city;

        System.out.println("------ Ajout de Fournisseur ------");
        displaySupplier();

        while (!isInputValid) {
            System.out.println("Veuillez entrer le nom du fournisseur : ");
            name = scanner.nextLine();
            if(fournisseur.setNom(name)) {
                isInputValid = true;
            } else {
                System.out.println("Le nom entré n'est pas valide. Veuillez réessayer.");
            }
        }
        isInputValid = false;

        while (!isInputValid) {
            System.out.println("Veuillez entrer la ville du fournisseur : ");
            city = scanner.nextLine();
            if(fournisseur.setVille(city)) {
                isInputValid = true;
            } else {
                System.out.println("La ville entré n'est pas valide. Veuillez réessayer.");
            }
        }
        fournisseurDAO.save(fournisseur);
    }

    public static void modifySupplier() {
        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        Fournisseur fournisseur = new Fournisseur();
        int userChoice;
        String name;
        String city;
        boolean isInputValid = false;

        System.out.println("------ Modification de Fournisseur ------");
        displaySupplier();

        while (true) {
            System.out.println("Veuillez entrer l'id du fournisseur a modifier en utilisant uniquement des caracteres numerique : ");
            if(scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                fournisseur = fournisseurDAO.getById(userChoice);
                scanner.next();
                break;
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next();
            }
        }

        while (!isInputValid) {
            System.out.println("Veuillez entrer le nom du fournisseur : ");
            name = scanner.nextLine();
            if(fournisseur.setNom(name)) {
                isInputValid = true;
            } else {
                System.out.println("Le nom entré n'est pas valide. Veuillez réessayer.");
            }
        }
        isInputValid = false;

        while (!isInputValid) {
            System.out.println("Veuillez entrer la ville du fournisseur : ");
            city = scanner.nextLine();
            if(fournisseur.setVille(city)) {
                isInputValid = true;
            } else {
                System.out.println("La ville entré n'est pas valide. Veuillez réessayer.");
            }
        }
        fournisseurDAO.save(fournisseur);
    }

    public static void deleteSupplier() {
        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        Entree_stockDAO entree_stockDAO = new Entree_stockDAO();
        int userChoice;

        System.out.println("------ Suppresion d'un Fourniseur ------");
        displaySupplier();

        System.out.println("Veuillez entrer l'id du fournisseur a supprimer : ");
        if (scanner.hasNextInt()) {
            userChoice = scanner.nextInt();
            if (fournisseurDAO.getById(userChoice) != null) {
                if (entree_stockDAO.getByIdSupplier(userChoice) != null) {
                    entree_stockDAO.deleteByIdSupplier(userChoice);
                }
                fournisseurDAO.deleteById(userChoice);
            } else {
                System.out.println("Erreur ID invalide");
            }
        }
    }

    public static void searchSupplier() {
        ArrayList<Fournisseur> searchResults = new ArrayList<>();
        FournisseurDAO clientDAO =  new FournisseurDAO();
        String search;

        System.out.println("------ Recherche de Fournisseur ------");
        System.out.println("Veuillez entrer le terme de la recherche ");
        search = scanner.nextLine();
        searchResults = clientDAO.searchSupplier(search);

        if (searchResults != null) {
            System.out.println("Resultat de la recherche : ");
            for (Fournisseur fournisseur : searchResults) {
                System.out.println(fournisseur);
            }
        } else {
            System.out.println("Aucun resultat trouve pour : " + search);
        }
    }

    public static void displayStock() {
        ArrayList<Entree_stock> stocks = new ArrayList<>();
        Entree_stockDAO entree_stockDAO = new Entree_stockDAO();

        stocks = entree_stockDAO.getAll();

        System.out.print("------ Affichage des Stock ------\n");
        for (Entree_stock entree_stock : stocks) {
            System.out.println(entree_stock);
        }
    }

    public static void addStock() {
        Entree_stockDAO entree_stockDAO = new Entree_stockDAO();
        ProduitDAO produitDAO = new ProduitDAO();
        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        Entree_stock entree_stock = new Entree_stock();
        int id_fournisseur;
        int id_produit;
        int quantite;

        System.out.println("------ Ajout d'une Entree Stock ------");

        displayStock();
        displayProduct();
        while (true) {
            System.out.println("Veuillez Choisir le produit a ajouter au stock en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
            if (scanner.hasNextInt()) {
                id_produit = scanner.nextInt();
                if(produitDAO.getById(id_produit) != null){
                    entree_stock.setId_produit(id_produit);
                    scanner.next();
                    break;
                } else {
                    System.out.println("Entrée invalide.");
                    scanner.next();
                }
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next();
            }
        }

        while (true) {
            System.out.println("Veuillez Choisir le fournisseur du produit a ajouter au stock en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");          
            if (scanner.hasNextInt()) {
                id_fournisseur = scanner.nextInt();
                if(fournisseurDAO.getById(id_fournisseur) != null){
                    entree_stock.setId_fournisseur(id_fournisseur);
                    scanner.next();
                    break;
                } else {
                    System.out.println("Entrée invalide.");
                    scanner.next();
                }
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next();
            }
        }

        while (true) {
            System.out.println("Veuillez entrer la quantite de produit a ajouter au stock : ");
                if (scanner.hasNextInt()) {
                quantite = scanner.nextInt();
                entree_stock.setQuantite(quantite);
                scanner.next();
                break;
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next();
            }
        }
        entree_stockDAO.save(entree_stock);
    }

    public static void deleteStock() {
        Entree_stockDAO entree_stockDAO = new Entree_stockDAO();
        int userChoice;

        System.out.println("------ Suppresion d'un Fourniseur ------");
        displayStock();

        System.out.println("Veuillez entrer l'id du Stock a supprimer uniquement en valeur numerique : ");
        if (scanner.hasNextInt()) {
            userChoice = scanner.nextInt();
            if (entree_stockDAO.getById(userChoice) != null) {
                entree_stockDAO.deleteById(userChoice);
            }
        } else {
            System.out.println("Erreur ID invalide");
        }
    }
    
    public static void displayPaiement() {
        ArrayList<Paiement> paiements = new ArrayList<>();
        PaiementDAO paiementDAO = new PaiementDAO();

        paiements = paiementDAO.getAll();

        System.out.print("------ Affichage des Paiements ------\n");
        for (Paiement paiement : paiements) {
            System.out.println(paiement);
        }
    }

    public static void addPaiement() {
        PaiementDAO paiementDAO = new PaiementDAO();
        CommandeDAO commandeDAO = new CommandeDAO();
        Paiement paiement = new Paiement();
        int id_commande;
        Double price;

        System.out.println("------ Paiement ------");
        displayOrder();

        while (true) {
            System.out.println("Veuillez choisir a quel commande appartient le paiement en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
            if (scanner.hasNextInt()){
                id_commande = scanner.nextInt();
                if(commandeDAO.getById(id_commande) != null) {
                    paiement.setId_commande(id_commande);
                    scanner.next();
                    break;
                } else {
                    System.out.println("L'ID entré n'est pas valide. Veuillez réessayer.");
                    scanner.next();
                }
            } else {
                System.out.println("L'entrée n'est pas un nombre valide. Veuillez entrer un nombre entier.");
                scanner.next();
            }
        }
        
        while(true) {
            System.out.println("Veuillez entrer le paiement uniquement en valeur numerique : ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                paiement.setMontant(price);
                scanner.next();
                break;
            } else {
                System.out.print("La somme entré n'est pas valide. Veuillez réessayer.");
            }
        }
        paiementDAO.save(paiement);
    }

    public static void modifyPaiement() {
        PaiementDAO paiementDAO = new PaiementDAO();
        CommandeDAO commandeDAO = new CommandeDAO();
        Paiement paiement = new Paiement();
        int id_commande;
        int userChoice;
        Double price;

        System.out.println("------ Modification de Paiement ------");
        
        while (true) {
            displayPaiement();
            System.out.println("Veuillez entrer l'id du paiement a modifier en utilisant uniquement des caracteres numerique : ");
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                paiement = paiementDAO.getById(userChoice);
                if (paiement != null) {
                    scanner.next();
                    break;
                } else {
                    System.out.println("L'ID entré n'est pas valide. Veuillez réessayer.");
                    scanner.next();
                }
            } else {
                System.out.println("L'entrée n'est pas un nombre valide. Veuillez entrer un nombre entier.");
                scanner.next();
            }
        }


        while (true) {
            System.out.println("Veuillez choisir a quel commande appartient le paiement en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
            if (scanner.hasNextInt()){
                id_commande = scanner.nextInt();
                if(commandeDAO.getById(id_commande) != null) {
                    paiement.setId_commande(id_commande);
                    scanner.next();
                    break;
                } else {
                    System.out.println("L'ID entré n'est pas valide. Veuillez réessayer.");
                    scanner.next();
                }
            } else {
                System.out.println("L'entrée n'est pas un nombre valide. Veuillez entrer un nombre entier.");
                scanner.next();
            }
        }
        
        while(true) {
            System.out.println("Veuillez entrer le paiement uniquement en valeur numerique : ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                paiement.setMontant(price);
                scanner.next();
                break;
            } else {
                System.out.print("La somme entré n'est pas valide. Veuillez réessayer.");
            }
        }
        paiementDAO.save(paiement);
    }

    public static void deletePaiement() {
        PaiementDAO paiementDAO = new PaiementDAO();
        int userChoice;

        System.out.println("------ Suppresion d'un Paiement ------");
        displayProduct();
        System.out.println("Veuillez entrer l'id du paiement a supprimer : ");
        userChoice = scanner.nextInt();

        if (paiementDAO.getById(userChoice) != null) {
            paiementDAO.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static int menu() {
        System.out.println("\n------ Menu de Gestion ------");
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
        System.out.println("18- Liste des Fournisseurs");
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