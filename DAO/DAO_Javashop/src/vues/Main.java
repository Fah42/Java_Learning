package vues;

import dao.UserDAO;
import entites.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Database.connect();
        int Userchoice = 0;
		while(Userchoice != 5) {
			Userchoice = menu();
			if(Userchoice == 1) {
				displayUsers();
			} else if (Userchoice == 2) {
                addUser();
            } else if (Userchoice == 3) {
                modifyUser();
            } else if (Userchoice == 4) {
                deleteUser();
            }
        }
    }

    public static void displayUsers() {
        ArrayList<User> users = new ArrayList<>();
        UserDAO udao = new UserDAO();
        
        users = udao.getAll();
        
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void addUser() {
        User u = new User();
        UserDAO udao = new UserDAO();

        /* flash */
        scanner.nextLine();
        System.out.println("Veuillez entrer l'username : ");
        String username = scanner.nextLine(); 
        System.out.println("Veuillez entrer le mot de passe : ");
        String password = scanner.nextLine();

        u.setUsername(username);
        u.setPassword(password);

        udao.save(u);
    }

    public static void modifyUser() {
        UserDAO udao = new UserDAO();

        displayUsers();

        System.out.println("Veuillez entrer l'id de l'utilisateur a modifier : ");
        int userChoice = scanner.nextInt();
        User u = udao.getById(userChoice);
        if (u != null) {
            /* Flash */
            System.out.println("Veuillez entrer le nouveau username : ");
            scanner.nextLine();
            String username = scanner.nextLine();
            System.out.println("Veuillez entrer le nouveau mot de passe : ");
            String password = scanner.nextLine();
            u.setId(userChoice);
            u.setUsername(username);
            u.setPassword(password);
            udao.save(u);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void deleteUser() {
        UserDAO udao = new UserDAO();

        displayUsers();

        System.out.println("Veuillez entrer l'id de l'utilisateur a supprimer : ");
        int userChoice = scanner.nextInt();

        if (udao.getById(userChoice) != null) {
            udao.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static int menu() {
        System.out.println("---- MENU ----");
        System.out.println("1 - Liste des utilisateurs");
        System.out.println("2 - Ajouter un utilisateur");
        System.out.println("3 - Modifier un utilisateur");
        System.out.println("4 - Supprimer un utilisateur");
        System.out.println("5 - Quitter");
        System.out.println("Votre choix : ");
        return scanner.nextInt();
    }
}
