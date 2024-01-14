package Projet_BankSystem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Integer> client_id = new ArrayList<>();
    static ArrayList<String> client_prenom = new ArrayList<>();
    static ArrayList<String> client_nom = new ArrayList<>();
    static ArrayList<String> client_ville = new ArrayList<>();
    static ArrayList<Integer> client_age = new ArrayList<>();

    static ArrayList<Integer> compte_id = new ArrayList<>();
    static ArrayList<String> compte_rib = new ArrayList<>();
    static ArrayList<Double> compte_solde = new ArrayList<>();
    static ArrayList<Integer> compte_id_client = new ArrayList<>();

    static ArrayList<Integer> carte_id = new ArrayList<>();
    static ArrayList<String> carte_num = new ArrayList<>();
    static ArrayList<Integer> carte_aexp = new ArrayList<>();
    static ArrayList<Integer> carte_id_compte = new ArrayList<>();

    public static void main(String[] args) {
        int userChoice = -1;
        while(userChoice != 12) {
            userChoice = menu();
            switch(userChoice) {
                case 1:
                    displayAllClient();
                    break;
                case 2:
                    displayAllAccount();
                    break;
                case 3:
                    displayAllCard();
                    break;
                case 4:
                    transfert_money();
                    break;
                case 5:
                    search_client();
                    break;
                case 6:
                    add_client();
                    break;
                case 7:
                    add_account(client_id);
                    break;
                case 8:
                    add_card();
                    break;
                case 9:
                    delete_client();
                    break;
                case 10:
                    delete_account();
                    break;
                case 11:
                    delete_card();
                    break;
                case 12:
                    System.out.println("Quitter");
                    break;
                default:
                    System.out.println("Option non valide, veuillez réessayer.");
            }
        }
    }

    public static void displayAllInfo() {
        if (client_id.isEmpty()) {
            System.out.println("--------------------\n");
            System.out.println("Aucun client enregistré.");
            System.out.println("\n--------------------");
            return;
        }
    
        for (int i = 0; i < client_id.size(); i++) {
            System.out.println("--------------------\n");
            System.out.println("ID: " + client_id.get(i) + " - " + client_prenom.get(i) + " " + client_nom.get(i));
            System.out.println("Ville: " + client_ville.get(i) + ", Âge: " + client_age.get(i));
            int accountIdIndex = compte_id_client.indexOf(client_id.get(i));
            if (accountIdIndex != -1) {
                System.out.println("Compte associé: RIB " + compte_rib.get(accountIdIndex) + ", Solde: " + compte_solde.get(accountIdIndex));
            }
            int cardIdIndex = carte_id_compte.indexOf(client_id.get(i));
            if (cardIdIndex != -1) {
                System.out.println("Carte associée: Numéro " + carte_num.get(cardIdIndex) + ", Expiration: " + carte_aexp.get(cardIdIndex));
            }
            System.out.println("\n--------------------");
        }
    }

    public static void displayAllClient() {
        if (client_id.isEmpty()) {
            System.out.println("--------------------\n");
            System.out.println("Aucun client enregistré.");
            System.out.println("\n--------------------");
            return;
        }
    
        for (int i = 0; i < client_id.size(); i++) {
            System.out.println("--------------------\n");
            System.out.println("ID: " + client_id.get(i) + " - " + client_prenom.get(i) + " " + client_nom.get(i));
            System.out.println("\n--------------------");
        }
    }

    public static void displayAllAccount() {
        if (compte_rib.isEmpty()) {
            System.out.println("--------------------\n");
            System.out.println("Aucun compte enregistré.");
            System.out.println("\n--------------------");
            return;
        }
    
        for (int i = 0; i < compte_rib.size(); i++) {
            Integer id = compte_id.get(i);
            String rib = compte_rib.get(i);
            Double solde = compte_solde.get(i);
            Integer idClient = compte_id_client.get(i);
            System.out.println("--------------------\n");
            System.out.println("Id : " + id + ", Compte RIB: " + rib + ", Solde: " + solde + ", ID Client: " + idClient);
            System.out.println("\n--------------------");
        }
    }

    public static void displayAllCard() {
        if (carte_num.isEmpty()) {
            System.out.println("--------------------\n");
            System.out.println("Aucune carte enregistrée.");
            System.out.println("\n--------------------");
            return;
        }
    
        for (int i = 0; i < carte_num.size(); i++) {
            Integer id = carte_id.get(i);
            String numero = carte_num.get(i);
            Integer aexp = carte_aexp.get(i);
            Integer idCompte = carte_id_compte.get(i);
            System.out.println("--------------------\n");
            System.out.println("ID: " + id + "Carte Numéro: " + numero + ", Année d'Expiration: " + aexp + ", ID Compte: " + idCompte);
            System.out.println("\n--------------------");
        }
    }

    public static void add_client() {
        scanner.nextLine();
        System.out.println("Veuillez entrer le nom du client : ");
        String nom = scanner.nextLine().toLowerCase();
        System.out.println("Veuillez entrer le prenom du client : ");
        String prenom = scanner.nextLine().toLowerCase();
        int age;
        do {
            System.out.println("Veuillez entrer l'age du client :");
            while (!scanner.hasNextInt()) {
                System.out.println("Ce n'est pas un nombre valide, veuillez entrer un age valide : ");
                scanner.next(); 
            }
            age = scanner.nextInt();
        } while (age <= 0);
        System.out.println("Veuillez entrer la ville du client");
        String ville = scanner.nextLine();
        scanner.nextLine();

        int newClientId = client_id.isEmpty() ? 0 : Collections.max(client_id) + 1;
        client_id.add(newClientId);
        client_prenom.add(prenom);
        client_nom.add(nom);
        client_ville.add(ville);
        client_age.add(age);

        boolean compteAjoute = add_account(client_id);
        while (!compteAjoute) {
            System.out.println("L'Id ne correspond a aucun client, veuillez choisir un ID qui correspond a un client.");
            compteAjoute = add_account(client_id);
        }
        add_card();
    }
    public static boolean add_account(ArrayList<Integer> client_id) {
        displayAllClient();
        if (client_id.isEmpty()) {
            System.out.println("Aucun client enregistré.");
            return false;
        }
    
        System.out.println("Veuillez entrer l'ID du client pour le nouveau compte:");
        int clientId = scanner.nextInt();
        
        while(!client_id.contains(clientId)) {
            System.out.println("ID de client invalide. Veuillez entrer l'ID du client pour le nouveau compte:");
            clientId = scanner.nextInt();
        }
        scanner.nextLine();
    
        String rib;
        boolean ribIsDifferent = false;
        do {
            System.out.println("Veuillez entrer le rib du compte");
            rib = scanner.nextLine();
            if (compte_rib.contains(rib)) {
                System.out.println("Ce RIB est déjà utilisé. Veuillez entrer un autre RIB.");
            } else {
                ribIsDifferent = true;
            }
        } while (!ribIsDifferent);
        
        double solde;
        do {
            System.out.println("Veuillez entrer le solde du compte");
            while (!scanner.hasNextDouble()) {
                System.out.println("Ce n'est pas un solde valide, veuillez entrer un solde valide : ");
                scanner.next(); 
            }
            solde = scanner.nextDouble();
        } while (solde <= 0);
        scanner.nextLine();
        
        compte_id.add(compte_id.size() + 1);
        compte_rib.add(rib);
        compte_solde.add(solde);
        compte_id_client.add(clientId);
    
        return true;
    }

    public static void add_card() {
        displayAllClient();
        if (client_id.isEmpty()) {
            System.out.println("Aucun client enregistré.");
            return;
        }
        
        System.out.println("Veuillez entrer l'ID du client pour la nouvelle carte : ");
        int clientId = scanner.nextInt();
        
        while(!client_id.contains(clientId)) {
            System.out.println("ID de client invalide. Veuillez entrer l'ID du client pour la nouvelle carte:");
            clientId = scanner.nextInt();
        }
        scanner.nextLine();
    
        System.out.println("Veuillez entrer le numéro de la carte");
        String num = scanner.nextLine();
        /*------------ */
        int aexp;
        do {
            System.out.println("Veuillez entrer l'année d'expiration de la carte");
            while (!scanner.hasNextInt()) {
                System.out.println("Ce n'est pas une annee valide, veuillez entrer une annee valide : ");
                scanner.next(); 
            }
            aexp = scanner.nextInt();
        } while (aexp <= 0);

        carte_id.add(carte_id.size() + 1);
        carte_num.add(num);
        carte_aexp.add(aexp);
        carte_id_compte.add(clientId);
    }

    public static void delete_client() {
        displayAllClient();

        if (client_id.size() == 0) {
            System.out.println("--------------------\n");
            System.out.println("Il n'y a pas de client a supprimer.");
            System.out.println("\n--------------------");
            return;
        }

        System.out.println("Veuillez choisir l'ID du client à supprimer:");
        int clientIdIndex = scanner.nextInt();
        scanner.nextLine();
    
        if(clientIdIndex < 0 || clientIdIndex >= client_id.size()) {
            System.out.println("Index invalide.");
            return;
        }
    
        client_id.remove(clientIdIndex);
        client_prenom.remove(clientIdIndex);
        client_nom.remove(clientIdIndex);
        client_ville.remove(clientIdIndex);
        client_age.remove(clientIdIndex);
    
    }

    public static void delete_account() {
        displayAllAccount();
        if (compte_id.size() == 0) {
            System.out.println("--------------------\n");
            System.out.println("Il n'y a pas de compte a supprimer.");
            System.out.println("\n--------------------");
            return;
        }
        System.out.println("Veuillez choisir l'ID du compte à supprimer:");
        int accountIdIndex = scanner.nextInt();
        scanner.nextLine();
    
        if(accountIdIndex < 0 || accountIdIndex >= compte_id.size()) {
            System.out.println("Index invalide.");
            return;
        }
    
        compte_id.remove(accountIdIndex);
        compte_rib.remove(accountIdIndex);
        compte_solde.remove(accountIdIndex);
        compte_id_client.remove(accountIdIndex);
    }

    public static void delete_card() {
        displayAllCard();
        if (carte_id.size() == 0) {
            System.out.println("--------------------\n");
            System.out.println("Il n'y a pas de carte a supprimer.");
            System.out.println("\n--------------------");
            return;
        }
        System.out.println("Veuillez choisir l'ID de la carte à supprimer:");
        int cardIdIndex = scanner.nextInt();
        scanner.nextLine();
    
        if(cardIdIndex < 0 || cardIdIndex >= carte_id.size()) {
            System.out.println("Index invalide.");
            return;
        }
    
        carte_id.remove(cardIdIndex);
        carte_num.remove(cardIdIndex);
        carte_aexp.remove(cardIdIndex);
        carte_id_compte.remove(cardIdIndex);
    }

    public static void transfert_money() {
        displayAllInfo();
        if (compte_id.size() < 2) {
            System.out.println("--------------------\n");
            System.out.println("Il n'y a pas suffisament de compte enregistre pour faire un virement");
            System.out.println("\n--------------------");
            return;
        }
        scanner.nextLine();
        System.out.println("Veuillez entrer le RIB du compte à débiter");
        String ribDebit = scanner.nextLine();
        System.out.println("Veuillez entrer le RIB du compte à créditer");
        String ribCredit = scanner.nextLine();
        System.out.println("Veuillez entrer le montant à transférer");
        double montant = scanner.nextDouble();
        scanner.nextLine();
    
        int indexDebit = compte_rib.indexOf(ribDebit);
        int indexCredit = compte_rib.indexOf(ribCredit);
    
        if (indexDebit == -1 || indexCredit == -1) {
            System.out.println("Un des RIB n'a pas été trouvé.");
            return;
        }
    
        if (compte_solde.get(indexDebit) < montant) {
            System.out.println("Solde insuffisant pour le transfert.");
            return;
        }
    
        compte_solde.set(indexDebit, compte_solde.get(indexDebit) - montant);
        compte_solde.set(indexCredit, compte_solde.get(indexCredit) + montant);
        System.out.println("Transfert effectué avec succès.");
    }

    public static void search_client() {
        scanner.nextLine();
        System.out.println("Veuillez entrer le nom du client à rechercher");
        String nomRecherche = scanner.nextLine().toLowerCase();
        System.out.println("Veuillez entrer le prénom du client à rechercher");
        String prenomRecherche = scanner.nextLine().toLowerCase();
    
        for (int i = 0; i < client_id.size(); i++) {
            if (client_nom.get(i).equals(nomRecherche) && client_prenom.get(i).equals(prenomRecherche)) {
                System.out.println("Client trouvé: ID " + client_id.get(i) + ", Nom: " + client_nom.get(i) + ", Prénom: " + client_prenom.get(i) + ", Ville: " + client_ville.get(i) + ", Âge: " + client_age.get(i));
                int accountIdIndex = compte_id_client.indexOf(client_id.get(i));
                if (accountIdIndex != -1) {
                    System.out.println("Compte associé: RIB " + compte_rib.get(accountIdIndex) + ", Solde: " + compte_solde.get(accountIdIndex));
                }
                int cardIdIndex = carte_id_compte.indexOf(client_id.get(i));
                if (cardIdIndex != -1) {
                    System.out.println("Carte associée: Numéro " + carte_num.get(cardIdIndex) + ", Expiration: " + carte_aexp.get(cardIdIndex));
                }
                return;
            }
        }
    
        System.out.println("Client non trouvé.");
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
        System.out.println("9 - Supprimer un client");
        System.out.println("10 - Supprimer un compte");
        System.out.println("11 - Supprimer une carte");
        System.out.println("12 - Quitter");
        System.out.println("Votre choix : ");
        return scanner.nextInt();
    }
}