package vues;

import dao.*;
import entites.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Database.connect();
        
        int Userchoice = 99;
        while (Userchoice != 0) {
            Userchoice = menu();
            if (Userchoice == 1) {
                displayProduct();
            } else if (Userchoice == 2) {
                addProduct();
            } else if (Userchoice == 3) {
                modifyProduct();
            } else if (Userchoice == 4) {
                deleteProduct();
            } else if (Userchoice == 5) {
                searchProduct();
            } else if (Userchoice == 6) {
                displayClient();
            } else if (Userchoice == 7) {
                addClient();
            } else if (Userchoice == 8) {
                modifyClient();
            } else if (Userchoice == 9) {
                deleteClient();
            } else if (Userchoice == 10) {
                searchClient();
            } else if (Userchoice == 11) {
                displayCategorie();
            } else if (Userchoice == 12) {
                addCategorie();
            } else if (Userchoice == 13) {
                modifyCategorie();
            } else if (Userchoice == 14) {
                deleteCategorie(); 
            } else if (Userchoice == 15) {
                displayOrder();
            } else if (Userchoice == 16) {
                addOrder();
            } else if (Userchoice == 17) {
                deleteOrder();  
            } else if (Userchoice == 18) {
                displaySupplier();
            } else if (Userchoice == 19) {
                addSupplier();
            } else if (Userchoice == 20) {
                modifySupplier();
            } else if (Userchoice == 21) {
                deleteSupplier();
            } else if (Userchoice == 22) {
                searchSupplier();
            } else if (Userchoice == 23) {
                displayStock();
            } else if (Userchoice == 24) {
                addStock();
            } else if (Userchoice == 25) {
                deleteStock();
            } else if (Userchoice == 26) {
                displayPaiement();
            } else if (Userchoice == 27) {
                addPaiement();
            } else if (Userchoice == 28) {
                modifyPaiement();
            } else if (Userchoice == 29) {
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

    /*
     * FLASH QUI NE FONCTIONNE PAS ICI TODO TROUVER UNE SOLUTION
    */

    public static void addProduct() {
        Produit produit = new Produit();

        ProduitDAO produitDAO = new ProduitDAO();
        CategorieDAO categorieDAO = new CategorieDAO();

        System.out.println("------ Ajout de Produit ------");

        displayCategorie();
        int id_categorie = 0;
        while (true) {
            System.out.println("Veuillez choisir à quelle catégorie appartiendra le produit en sélectionnant l'id correspondant, en utilisant uniquement des caractères numériques : ");
            if (scanner.hasNextInt()) {
                if(categorieDAO.getById(id_categorie) != null) {
                    id_categorie = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }
                System.out.println("Veuillez entrer un ID existant : ");
                scanner.next();
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next();
            }
        }

        String title;
        boolean isTitleValid = false;

        while (!isTitleValid) {
            System.out.println("Veuillez entrer le nom du produit : ");
            title = scanner.nextLine();
    
            if (produit.setTitre(title)) {
                isTitleValid = true;
            } else {
                System.out.println("Le titre entré n'est pas valide. Veuillez réessayer.");
            }
        }
        
        Double price = 0.0;
        while (true) {
            System.out.println("Veuillez entrer le prix du produit uniquement en valeur numerique : ");
            if (scanner.hasNextDouble()){
                price = scanner.nextDouble();
                scanner.next();
                break;
            } else {
                System.out.print("La somme entré n'est pas valide. Veuillez réessayer.");
            }
        }

        int stock;
        while(true) {
            System.out.println("Veuillez entrer le nombre de produit uniquement en valeur numerique : ");
            if (scanner.hasNextInt()){
                stock = scanner.nextInt();
                scanner.next();
                break;
            } else {
                System.out.println("La somme entré n'est pas valide. Veuillez réessayer.");
            }
        }

        produit.setPrix(price);
        produit.setId_categorie(id_categorie);
        produit.setStock(stock);
        System.out.println("Ajout reussi !");

        produitDAO.save(produit);
    }

    /*
     * FLASH QUI NE FONCTIONNE PAS ICI TODO TROUVER UNE SOLUTION
    */
    public static void modifyProduct() {
        ProduitDAO produitDAO = new ProduitDAO();
        CategorieDAO categorieDAO = new CategorieDAO();

        System.out.println("------ Modification de Produit ------");
        
        Categorie categorie;
        Produit produit; 
        int userChoice;
        int id_categorie;

        while (true) {
            displayProduct();
            System.out.println("Veuillez entrer l'id du produit à modifier, uniquement en valeur numérique : ");
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                scanner.nextLine();
                produit = produitDAO.getById(userChoice);
                if (produit != null) {
                    break;
                } else {
                    System.out.println("L'ID entré n'est pas valide. Veuillez réessayer.");
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
                categorie = categorieDAO.getById(id_categorie);
                if (categorie != null) {
                    break;
                }
                System.out.println("Veuillez entrer un ID existant : ");
            } else {
                System.out.println("L'entrée n'est pas un nombre valide. Veuillez entrer un nombre entier."); 
            }
        }

        String title;
        boolean isTitleValid = false;

        while (!isTitleValid) {
            System.out.println("Veuillez entrer le nom du produit : ");
            title = scanner.nextLine();
    
            if (produit.setTitre(title)) {
                isTitleValid = true;
            } else {
                System.out.println("Le titre entré n'est pas valide. Veuillez réessayer.");
            }
        }

        Double price = 0.0;
        while (true) {
            System.out.println("Veuillez entrer le prix du produit uniquement en valeur numerique : ");
            if (scanner.hasNextDouble()){
                price = scanner.nextDouble();
                scanner.next();
                break;
            } else {
                System.out.print("La somme entré n'est pas valide. Veuillez réessayer.");
            }
        }
                
        int stock;
        while(true) {
            System.out.println("Veuillez entrer le nombre de produit uniquement en valeur numerique : ");
            if (scanner.hasNextInt()){
                stock = scanner.nextInt();
                scanner.next();
                break;
            } else {
                System.out.println("La somme entré n'est pas valide. Veuillez réessayer.");
            }
        }

        produit.setPrix(price);
        produit.setId_categorie(id_categorie);
        produit.setStock(stock);
        System.out.println("Modification reussi !");

        produitDAO.save(produit);
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
        ProduitDAO produitDAO =  new ProduitDAO();

        System.out.println("------ Recherche d'un Produit ------");
        System.out.println("Veuillez entrer le terme de la recherche ");

        String search = scanner.nextLine();

        ArrayList<Produit> searchResults = produitDAO.searchProduct(search);
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
        ClientDAO cdao = new ClientDAO();

        clients = cdao.getAll();

        System.out.print("------ Affichage des Clients ------\n");
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    
    public static void addClient() {
        Client client = new Client();
        ClientDAO clientDAO = new ClientDAO();
        int age = -1;

        System.out.println("------ Ajout de Client ------");

        String lastname;
        String firstname;
        String city;
        boolean isInputValid = false;

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
        ClientDAO cdao = new ClientDAO();
        System.out.println("------ Modification de Client ------");
        displayClient();

        System.out.println("Veuillez entrer l'id du client a modifier : ");
        int Userchoice = scanner.nextInt();
        Client c = cdao.getById(Userchoice);

        if (c != null) {
            /* flash */
            scanner.nextLine();

            System.out.println("Veuillez entrer le nom : ");
            String lastname = scanner.nextLine();
            System.out.println("Veuillez entrer le prenom : ");
            String firstname = scanner.nextLine();
            System.out.println("Veuillez entrer la ville : ");
            String city = scanner.nextLine();
            System.out.println("Veuillez entrer l'age : ");
            
            int age = scanner.nextInt();

            if(!c.setPrenom(firstname)) {
                System.out.println("Ajout du client echoue car prenom vide ou trop long !");
                return ;
            }
            if (c.setNom(lastname)) {
                System.out.println("Ajout du client echoue car nom vide ou trop long !");
                return ;
            }
            if (c.setVille(city)) {
                System.out.println("Ajout du client echoue car nom vide ou trop long !");
                return ;
            }
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
        System.out.println("------ Suppresion de Client ------");
        displayClient();

        System.out.println("Veuillez entrer l'id du client a supprimer : ");
        int userChoice = scanner.nextInt();

        if (cdao.getById(userChoice) != null) {
            cdao.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void searchClient() {
        ClientDAO cdao =  new ClientDAO();
        System.out.println("------ Recherche de Client ------");
        /*flash*/
        scanner.nextLine();

        System.out.println("Veuillez entrer le terme de la recherche ");
        String search = scanner.nextLine();

        ArrayList<Client> searchResults = cdao.searchClients(search);
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
        CategorieDAO cdao = new CategorieDAO();

        categories = cdao.getAll();

        System.out.print("------ Affichage des Categories ------\n");
        for (Categorie categorie : categories) {
            System.out.println(categorie);
        }
    }

    public static void addCategorie() {
        Categorie c = new Categorie();
        CategorieDAO cdao = new CategorieDAO();

        System.out.println("------ Ajout de Categorie ------");
        /*flash*/
        scanner.nextLine();

        System.out.println("Veuillez entrer le nom de la categorie: ");
        String title = scanner.nextLine();

        if (c.setTitre(title)) {
            System.out.println("Saisie reussi");
            cdao.save(c);
        } else {
            System.out.println("La titre n'a pas pu etre modifie car le nombre de character a depasse la limite de 50 ou bien vous y avez inserer un charactere vide.");
        }
    }
    
    public static void modifyCategorie() {
        CategorieDAO cdao = new CategorieDAO();
        System.out.println("------ Modification de Categorie ------");
        displayCategorie();

        System.out.println("Veuillez entrer l'id de la categorie a modifier : ");
        int Userchoice = scanner.nextInt();
        Categorie c = cdao.getById(Userchoice);

        if (c != null) {
            /* flash */
            scanner.nextLine();

            System.out.println("Ancien nom : " + c.getTitre() + "\nVeuillez entrer le nouveau titre : ");
            String titre = scanner.nextLine();

            if(c.setTitre(titre)){
                c.setTitre(titre);
                cdao.save(c);
            }
        } else {
            System.out.println("Erreur, ID invalide");
        }
    }

    public static void deleteCategorie() {
        CategorieDAO cdao = new CategorieDAO();
        System.out.println("------ Suppresion d'une Categorie ------");
        displayCategorie();

        System.out.println("Veuillez entrer l'id de la categorie a supprimer : ");
        int userChoice = scanner.nextInt();

        if (cdao.getById(userChoice) != null) {
            cdao.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void displayOrder() {
        ArrayList<Commande> commandes = new ArrayList<>();
        CommandeDAO cdao = new CommandeDAO();

        commandes = cdao.getAll();

        System.out.print("------ Affichage des Commandes ------\n");
        for (Commande commande : commandes) {
            System.out.println(commande);
        }
    }

    public static void addOrder() {
        Commande commande = new Commande();
        CommandeDAO commandedao = new CommandeDAO();
        ClientDAO clientdao = new ClientDAO();

        System.out.println("------ Ajout de Commande ------");

        displayClient();
        
        do {
            System.out.println("Veuillez Choisir a quel client appartiendra la commande en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int id_client = scanner.nextInt();

        Client client = clientdao.getById(id_client);

        if (client == null) {
            do {
                System.out.println("Veuillez entrer un ID existant : ");
                scanner.next();
            } while (commande == null);
            id_client = scanner.nextInt();
        }

        commande.setId_client(id_client);

        commandedao.save(commande);
    }

    public static void deleteOrder() {
        CommandeDAO commandeDAO = new CommandeDAO();
        System.out.println("------ Suppresion d'une Commande ------");
        displayOrder();

        System.out.println("Veuillez entrer l'id de la commande a supprimer : ");
        int userChoice = scanner.nextInt();

        if (commandeDAO.getById(userChoice) != null) {
            commandeDAO.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
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

        System.out.println("------ Ajout de Fournisseur ------");

        displaySupplier();

        System.out.println("Veuillez entrer le nom du fournisseur : ");
        String name = scanner.nextLine();
        System.out.println("Veuillez entrer la ville du fournisseur : ");
        String city = scanner.nextLine();

        if (!fournisseur.setNom(name)) {
            System.out.println("Le nom est trop long ou vide.");
            return ;
        }
        if (!fournisseur.setVille(city)){
            System.out.println("Le nom de la ville est trop long ou vide.");
            return ;
        }
        fournisseur.setNom(name);
        fournisseur.setVille(city);

        fournisseurDAO.save(fournisseur);
    }

    public static void modifySupplier() {
        FournisseurDAO fournisseurDAO = new FournisseurDAO();

        System.out.println("------ Modification de Fournisseur ------");
        displaySupplier();

        do {
            System.out.println("Veuillez entrer l'id du fournisseur a modifier en utilisant uniquement des caracteres numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int userChoice = scanner.nextInt();

        Fournisseur fournisseur = fournisseurDAO.getById(userChoice);

        if (fournisseur == null) {
            do {
                System.out.println("Veuillez entrer un ID existant : ");
                scanner.next();
            } while (fournisseur == null);
            userChoice = scanner.nextInt();
        }

        System.out.println("Veuillez entrer le titre : ");
        String name = scanner.nextLine();
        System.out.println("Veuillez entrer la ville");
        String city = scanner.nextLine();

        if (!fournisseur.setNom(name)) {
            System.out.println("Le nom est trop long ou vide.");
            return ;
        }
        if (!fournisseur.setVille(city)){
            System.out.println("Le nom de la ville est trop long ou vide.");
            return ;
        }

        fournisseur.setNom(name);
        fournisseur.setVille(city);
        fournisseurDAO.save(fournisseur);
    }

    public static void deleteSupplier() {
        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        System.out.println("------ Suppresion d'un Fourniseur ------");
        displaySupplier();

        System.out.println("Veuillez entrer l'id du fournisseur a supprimer : ");
        int userChoice = scanner.nextInt();

        if (fournisseurDAO.getById(userChoice) != null) {
            fournisseurDAO.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void searchSupplier() {
        FournisseurDAO cdao =  new FournisseurDAO();
        System.out.println("------ Recherche de Fournisseur ------");
        /*flash*/
        scanner.nextLine();

        System.out.println("Veuillez entrer le terme de la recherche ");
        String search = scanner.nextLine();

        ArrayList<Fournisseur> searchResults = cdao.searchSupplier(search);
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
        Entree_stock entree_stock = new Entree_stock();

        Entree_stockDAO entree_stockDAO = new Entree_stockDAO();
        ProduitDAO produitDAO = new ProduitDAO();
        FournisseurDAO fournisseurDAO = new FournisseurDAO();

        System.out.println("------ Ajout d'une Entree Stock ------");

        displayStock();
        displayProduct();
        do {
            System.out.println("Veuillez Choisir le produit a ajouter au stock en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int id_produit = scanner.nextInt();

        Produit produit = produitDAO.getById(id_produit);

        if (produit == null) {
            do {
                System.out.println("Veuillez entrer un ID existant : ");
                scanner.next();
            } while (produit == null);
            id_produit = scanner.nextInt();
        }

        displaySupplier();
        do {
            System.out.println("Veuillez Choisir le fournisseur du produit a ajouter au stock en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int id_fournisseur = scanner.nextInt();

        Fournisseur fournisseur = fournisseurDAO.getById(id_fournisseur);

        if (fournisseur == null) {
            do {
                System.out.println("Veuillez entrer un ID existant : ");
                scanner.next();
            } while (fournisseur == null);
            id_fournisseur = scanner.nextInt();
        }

        System.out.println("Veuillez entrer la quantite de produit a ajouter au stock : ");   
        do {
            System.out.println("Veuillez entrer la quantite de produit uniquement en valeur numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int quantite = scanner.nextInt();

        entree_stock.setId_produit(id_produit);
        entree_stock.setId_fournisseur(id_fournisseur);
        entree_stock.setQuantite(quantite);

        entree_stockDAO.save(entree_stock);
    }

    public static void deleteStock() {
        Entree_stockDAO entree_stockDAO = new Entree_stockDAO();
        System.out.println("------ Suppresion d'un Fourniseur ------");
        displayStock();

        do {
            System.out.println("Veuillez entrer l'id du Stock a supprimer uniquement en valeur numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int userChoice = scanner.nextInt();

        if (entree_stockDAO.getById(userChoice) != null) {
            entree_stockDAO.deleteById(userChoice);
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
        Paiement paiement = new Paiement();

        PaiementDAO paiementDAO = new PaiementDAO();

        System.out.println("------ Paiement ------");

        displayPaiement();
        displayOrder();
        do {
            System.out.println("Veuillez Choisir a quel commande appartient le paiement en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int id_commande = scanner.nextInt();

        
        paiement = paiementDAO.getByIdCommande(id_commande);

        if (paiement == null) {
            do {
                System.out.println("Veuillez entrer un ID existant : ");
                scanner.next();
            } while (paiement == null);
            id_commande = scanner.nextInt();
        }
        
        do {
            System.out.println("Veuillez entrer le paiement uniquement en valeur numerique : ");
            scanner.next();
        } while (!scanner.hasNextDouble());
        Double price = scanner.nextDouble();

        paiement.setMontant(price);

        paiementDAO.save(paiement);
    }

    /*A revoir ENTIEREMENT PROBLEME DE CONCEPTION DANS LA MANIERE DE GERER LES CONTROLES DE SAISI */
    public static void modifyPaiement() {
        PaiementDAO paiementDAO = new PaiementDAO();

        System.out.println("------ Modification de Paiement ------");
        displayPaiement();

        do {
            System.out.println("Veuillez entrer l'id du paiement a modifier en utilisant uniquement des caracteres numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int userChoice = scanner.nextInt();

        Paiement paiement = paiementDAO.getById(userChoice);

        if (paiement == null) {
            do {
                System.out.println("Veuillez entrer un ID existant : ");
                scanner.next();
            } while (paiement == null);
            userChoice = scanner.nextInt();
        }
        paiement = paiementDAO.getById(userChoice);

        do {
            System.out.println("Veuillez entrer un prix en chiffre uniquement : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int price = scanner.nextInt();

        paiement.setMontant(price);
    }

    public static void deletePaiement() {
        PaiementDAO paiementDAO = new PaiementDAO();
        System.out.println("------ Suppresion d'un Paiement ------");
        displayProduct();

        System.out.println("Veuillez entrer l'id du paiement a supprimer : ");
        int userChoice = scanner.nextInt();

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
