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
        Produit p = new Produit();

        ProduitDAO pdao = new ProduitDAO();
        CategorieDAO cdao = new CategorieDAO();

        System.out.println("------ Ajout de Produit ------");

        displayCategorie();
        
        do {
            System.out.println("Veuillez Choisir a quel categorie appartiendra le produit en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int id_categorie = scanner.nextInt();

        Categorie c = cdao.getById(id_categorie);

        if (c == null) {
            do {
                System.out.println("Veuillez entrer un ID existant : ");
                scanner.next();
            } while (c == null);
            id_categorie = scanner.nextInt();
        }

        System.out.println("Veuillez entrer le nom du produit : ");
        String title = scanner.nextLine();
        
        do {
            System.out.println("Veuillez entrer le prix du produit uniquement en valeur numerique : ");
            scanner.next();
        } while (!scanner.hasNextDouble());
        Double price = scanner.nextDouble();

        do {
            System.out.println("Veuillez entrer le nombre de produit uniquement en valeur numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int stock = scanner.nextInt();

        p.setTitre(title);
        p.setPrix(price);
        p.setId_categorie(id_categorie);
        p.setStock(stock);

        pdao.save(p);
    }

    /*
     * FLASH QUI NE FONCTIONNE PAS ICI TODO TROUVER UNE SOLUTION
    */
    public static void modifyProduct() {
        ProduitDAO pdao = new ProduitDAO();
        CategorieDAO cdao = new CategorieDAO();

        System.out.println("------ Modification de Produit ------");
        displayProduct();

        System.out.println("Veuillez entrer l'id du produit a modifier : ");
        int Userchoice = scanner.nextInt();
        Produit p = pdao.getById(Userchoice);

        if (p != null) {
            displayCategorie();
        
            do {
                System.out.println("Veuillez Choisir a quel categorie appartiendra le produit en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
                scanner.next();
            } while (!scanner.hasNextInt());
            int id_categorie = scanner.nextInt();

            Categorie c = cdao.getById(id_categorie);

            if (c == null) {
                do {
                    System.out.println("Veuillez entrer un ID existant : ");
                    scanner.next();
                } while (c == null);
                id_categorie = scanner.nextInt();
            }

            System.out.println("Veuillez entrer le titre : ");
            String title = scanner.nextLine();

            do {
            System.out.println("Veuillez entrer le prix du produit uniquement en valeur numerique : ");
            scanner.next();
            } while (!scanner.hasNextDouble());
            Double price = scanner.nextDouble();
            
            do {
                System.out.println("Veuillez entrer le nombre de produit uniquement en valeur numerique : ");
                scanner.next();
            } while (!scanner.hasNextInt());
            int stock = scanner.nextInt();

            p.setTitre(title);
            p.setPrix(price);
            p.setStock(stock);
            p.setId_categorie(Userchoice);
            pdao.save(p);
        } else {
            System.out.println("Erreur, ID invalide");
        }
    }

    public static void deleteProduct() {
        ProduitDAO pdao = new ProduitDAO();
        System.out.println("------ Suppresion d'un Produit ------");
        displayProduct();

        System.out.println("Veuillez entrer l'id du produit a supprimer : ");
        int userChoice = scanner.nextInt();

        if (pdao.getById(userChoice) != null) {
            pdao.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void searchProduct() {
        ProduitDAO pdao =  new ProduitDAO();
        System.out.println("------ Recherche d'un Produit ------");
        /*flash*/
        scanner.nextLine();

        System.out.println("Veuillez entrer le terme de la recherche ");
        String search = scanner.nextLine();

        ArrayList<Produit> searchResults = pdao.searchProduct(search);
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
        Client c = new Client();
        ClientDAO cdao = new ClientDAO();
        int age = -1;

        System.out.println("------ Ajout de Client ------");
        /*flash*/
        scanner.nextLine();

        System.out.println("Veuillez entrer le nom : ");
        String lastname = scanner.nextLine();
        System.out.println("Veuillez entrer le prenom : ");
        String firstname = scanner.nextLine();
        System.out.println("Veuillez entrer la ville : ");
        String city = scanner.nextLine();
        do {
            /*FLASH QUI NE FONCTIONNE PAS ICI TODO TROUVER UNE SOLUTION*/
            System.out.println("Veuillez entrer l'age uniquement en valeur numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        age = scanner.nextInt();

        c.setPrenom(firstname);
        c.setNom(lastname);
        c.setAge(age);
        c.setVille(city);

        cdao.save(c);
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

        c.setTitre(title);

        cdao.save(c);
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

            c.setTitre(titre);
            cdao.save(c);
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
        String title = scanner.nextLine();
        System.out.println("Veuillez entrer la ville");
        String city = scanner.nextLine();

        fournisseur.setNom(title);
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
        CommandeDAO commandeDAO = new CommandeDAO();

        System.out.println("------ Paiement ------");

        displayPaiement();
        displayOrder();
        do {
            System.out.println("Veuillez Choisir a quel commande appartient le paiement en selectionnant l'id correspond en utilisant uniquement des caracteres numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int id_facture = scanner.nextInt();

        paiement = paiementDAO.getByIdFacture(id_facture);

        if (paiement == null) {
            do {
                System.out.println("Veuillez entrer un ID existant : ");
                scanner.next();
            } while (paiement == null);
            id_categorie = scanner.nextInt();
        }

        System.out.println("Veuillez entrer le nom du produit : ");
        String title = scanner.nextLine();
        
        do {
            System.out.println("Veuillez entrer le prix du produit uniquement en valeur numerique : ");
            scanner.next();
        } while (!scanner.hasNextDouble());
        Double price = scanner.nextDouble();

        do {
            System.out.println("Veuillez entrer le nombre de produit uniquement en valeur numerique : ");
            scanner.next();
        } while (!scanner.hasNextInt());
        int stock = scanner.nextInt();

        p.setTitre(title);
        p.setPrix(price);
        p.setId_categorie(id_categorie);
        p.setStock(stock);

        pdao.save(p);
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
