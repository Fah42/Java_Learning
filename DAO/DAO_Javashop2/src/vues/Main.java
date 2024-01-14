package vues;

import dao.*;
import entites.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Database.connect();
        int Userchoice = 0;
		while(Userchoice != 10) {
			Userchoice = menu();
			if (Userchoice == 1) {
				displayCat();
			} else if (Userchoice == 2) {
                addCat();
            } else if (Userchoice == 3) {
                modifyCat();
            } else if (Userchoice == 4) {
                deleteCat();
            } else if (Userchoice == 5) {
                displayProduct();
            } else if (Userchoice == 6) {
                addProduct();
            } else if (Userchoice == 7) {
                modifyProduct();
            } else if (Userchoice == 8) {
                deleteProduct();
            } else if (Userchoice == 9) {
                //searchProduct();
            }
        }
    }

    public static void displayCat() {
        ArrayList<Categories> categories = new ArrayList<>();
        ArrayList<Produits> produits = new ArrayList<>();

        CategoriesDAO cdao = new CategoriesDAO();
        ProduitsDAO pdao = new ProduitsDAO();

        categories = cdao.getAll();

        int i = 0;
        int j = 0;
        int nbProduct = 0;

        // while (i < categories.size()) {
        //     j = 0;
        //     nbProduct = 0;
        //     while (j < produits.size()) {
        //         if (produits.get(j).getCategorie_id() == categories.get(i).getId()) {
        //             nbProduct++;
        //         }
        //         j++;
        //     }
        //     System.out.println(categories.get(i) + " <" + nbProduct + " produit (s)>");
        //     i++;
        // }
        
        for (Categories c:categories) {
            nbProduct = pdao.nbProductByCat(c.getId());
            System.out.println(c + " <" + nbProduct + " produit (s)>");
        }
    }

    
    public static void displayProduct() {
        ArrayList<Produits> produits = new ArrayList<>();

        ProduitsDAO pdao = new ProduitsDAO();
        CategoriesDAO cdao = new CategoriesDAO();

        produits = pdao.getAll();
        for (Produits produit : produits) {
            System.out.println(produit + " categorie : " + cdao.getById(produit.getCategorie_id()).getTitre());
        }
        
    }

    public static void addCat() {
        Categories c = new Categories();
        CategoriesDAO cdao = new CategoriesDAO();

        /* flash */
        scanner.nextLine();
        System.out.println("Veuillez entrer le nom de la categorie : ");
        String title = scanner.nextLine(); 

        c.setTitre(title);

        cdao.save(c);
    }

    public static void addProduct() {
        Produits p = new Produits();
        ProduitsDAO cdao = new ProduitsDAO();

        /* flash */
        scanner.nextLine();
        System.out.println("Veuillez entrer le nom du produit : ");
        String title = scanner.nextLine(); 

        p.setTitre(title);

        cdao.save(p);
    }

    public static void modifyCat() {
        CategoriesDAO cdao = new CategoriesDAO();

        displayCat();

        System.out.println("Veuillez entrer l'id de la categorie a modifier : ");
        int userChoice = scanner.nextInt();
        Categories c = cdao.getById(userChoice);
        if (c != null) {
            /* Flash */
            System.out.println("Veuillez entrer le nouveau nom de la categorie : ");
            scanner.nextLine();
            String titre = scanner.nextLine();
            c.setId(userChoice);
            c.setTitre(titre);
            cdao.save(c);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void modifyProduct() {
        ProduitsDAO pdao = new ProduitsDAO();

        displayProduct();

        System.out.println("Veuillez entrer l'id de la categorie a modifier : ");
        int userChoice = scanner.nextInt();
        Produits p = pdao.getById(userChoice);
        if (p != null) {
            /* Flash */
            System.out.println("Veuillez entrer le nouveau nom de la categorie : ");
            scanner.nextLine();
            String titre = scanner.nextLine();
            p.setId(userChoice);
            p.setTitre(titre);
            pdao.save(p);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void deleteCat() {
        CategoriesDAO cdao = new CategoriesDAO();
        ProduitsDAO pdao = new ProduitsDAO();

        displayCat();
        
        System.out.println("Veuillez entrer l'id de la categorie a supprimer : ");
        int userChoice = scanner.nextInt();

        if (cdao.getById(userChoice) != null) {
            pdao.deleteById(userChoice);
            cdao.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void deleteProduct() {
        CategoriesDAO cdao = new CategoriesDAO();

        displayProduct();

        System.out.println("Veuillez entrer l'id de la categorie a supprimer : ");
        int userChoice = scanner.nextInt();

        if (cdao.getById(userChoice) != null) {
            cdao.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }


    public static int menu() {
        System.out.println("---- MENU ----");
        System.out.println("1 - Liste des categories");
        System.out.println("2 - Ajouter une categorie");
        System.out.println("3 - Modifier une categorie");
        System.out.println("4 - Supprimer une categorie");
        System.out.println("5 - Liste des produits");
        System.out.println("6 - Ajouter un produit");
        System.out.println("7 - Modifier un produit");
        System.out.println("8 - Supprimer un produit");
        System.out.println("9 - Recherche un produit");
        System.out.println("10 - Quitter");
        System.out.println("Votre choix : ");
        return scanner.nextInt();
    }
}
