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
        
        int admin_id = isAdmin();
        if (admin_id != 0){
            int Userchoice = 0;
            while (Userchoice != 17) {
                Userchoice = menu();
                if (Userchoice == 1) {
                    displayClient();
                    saveHistorique(admin_id, "Affichage de la liste des clients");
                } else if (Userchoice == 2) {
                    addClient();
                    saveHistorique(admin_id, "Ajout d'un client");
                } else if (Userchoice == 3) {
                    modifyClient();
                    saveHistorique(admin_id, "Modification d'un client");
                } else if (Userchoice == 4) {
                    deleteClient();
                    saveHistorique(admin_id, "Suppression d'un client");
                } else if (Userchoice == 5) {
                    displayAccount();
                    saveHistorique(admin_id, "Affichage de la liste des comptes");
                } else if (Userchoice == 6) {
                    addAccount();
                    saveHistorique(admin_id, "Ajout d'un compte");
                } else if (Userchoice == 7) {
                    modifyAccount();
                    saveHistorique(admin_id, "Modification d'un compte");
                } else if (Userchoice == 8) {
                    deleteAccount();
                    saveHistorique(admin_id, "Suppression d'un compte");
                } else if (Userchoice == 9) {
                    displayCard();
                    saveHistorique(admin_id, "Affichage de la liste des cartes");
                } else if (Userchoice == 10) {
                    addCard();
                    saveHistorique(admin_id, "Ajoute d'une carte");
                } else if (Userchoice == 11) {
                    modifyCard();
                    saveHistorique(admin_id, "Modification d'une carte");
                } else if (Userchoice == 12) {
                    deleteCard();
                    saveHistorique(admin_id, "Suppression d'une carte");
                } else if (Userchoice == 13) {
                    displayAdmin();
                    saveHistorique(admin_id, "Affichage de la liste des admins");
                } else if (Userchoice == 14) {
                    addAdmin();
                    saveHistorique(admin_id, "Ajout d'un admin");
                } else if (Userchoice == 15) {
                    modifyAdmin();
                    saveHistorique(admin_id, "Modification d'un admin");
                } else if (Userchoice == 16) {
                    deleteAdmin();
                    saveHistorique(admin_id, "Suppresion d'un admin");
                } else if (Userchoice == 17) {
                    transferFunds();
                    saveHistorique(admin_id, "Transfert de fond");
                } else if (Userchoice == 18) {
                    searchClient();
                    saveHistorique(admin_id, "Recherche client");
                }
            }
        } else {
            System.out.println("Erreur !");
        }
    }

    public static void displayClient() {
        ArrayList<Client> users = new ArrayList<>();
        ClientDAO udao = new ClientDAO();

        users = udao.getAll();

        for (Client user : users) {
            System.out.println(user);
        }
    }

    public static int isAdmin() {
        AdminDAO adao = new AdminDAO();
        Admin a = new Admin();

        System.out.println("Veuillez entrer le username admin :");
        String user_admin = scanner.nextLine();
        System.out.println("Veuillez entrer le mot de passe administrateur :");
        String password_admin = scanner.nextLine();
        
        a = adao.logIntoAdmin(user_admin, password_admin);
        if (a != null) {
            return a.getId();
        }
        else {
            return 0;
        }
    }

    public static void displayAccount() {
        ArrayList<Compte> comptes = new ArrayList<>();
        CompteDAO cdao = new CompteDAO();

        comptes = cdao.getAll();

        for (Compte compte : comptes) {
            System.out.println(compte);
        }
    }

    public static void displayCard() {
        ArrayList<Carte> cartes = new ArrayList<>();
        CarteDAO cdao = new CarteDAO();

        cartes = cdao.getAll();

        for (Carte carte : cartes) {
            System.out.println(carte);
        }
    }

    public static void addClient() {
        Client u = new Client();
        ClientDAO udao = new ClientDAO();

        /* flash */
        scanner.nextLine();
        System.out.println("Veuillez entrer le prenom : ");
        String name = scanner.nextLine();
        System.out.println("Veuillez entrer l'age : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Veuillez entrer la ville : ");
        String city = scanner.nextLine();

        u.setName(name);
        u.setAge(age);
        u.setCity(city);

        udao.save(u);
    }

    public static void addAccount() {
        Compte c = new Compte();
        CompteDAO cdao = new CompteDAO();

        displayClient();
        System.out.println("Veuillez entrer l'id du client : ");
        int userChoice = scanner.nextInt();
  
        scanner.nextLine();
        System.out.println("Veuillez entrer le rib : ");
        String rib = scanner.nextLine();
        System.out.println("Veuillez entrer le solde : ");
        double solde = scanner.nextInt();

        c.setRib(rib);
        c.setSolde(solde);
        c.setId_client(userChoice);
        cdao.save(c);
    }

    public static void addCard() {
        Carte c = new Carte();
        Client u = new Client();

        CarteDAO cdao = new CarteDAO();
        ClientDAO udao = new ClientDAO();

        displayAccount();
        System.out.println("Veuillez entrer l'id du compte : ");
        int userChoice = scanner.nextInt();

        u = udao.getById(userChoice);
        if (u != null) {
            scanner.nextLine();
            System.out.println("Veuillez entrer le numero de carte : ");
            String numero = scanner.nextLine();
            System.out.println("Veuillez entrer le type de carte : ");
            String typeC = scanner.nextLine();
            System.out.println("Veuillez entrer la date d'expiration de la carte : ");
            int an_exp = scanner.nextInt();

            c.setNumero(numero);
            c.setTypeC(typeC);
            c.setAn_exp(an_exp);
            c.setId_compte(userChoice);
            cdao.save(c);
        } else {
            System.out.println("ID Invalide");
            return;
        }
    }

    public static void modifyClient() {
        ClientDAO udao = new ClientDAO();

        displayClient();

        System.out.println("Veuillez entrer l'id de l'utilisateur a modifier : ");
        int userChoice = scanner.nextInt();
        Client u = udao.getById(userChoice);
        if (u != null) {
            /* Flash */
            System.out.println("Veuillez entrer le prenom : ");
            String name = scanner.nextLine();
            System.out.println("Veuillez entrer l'age : ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Veuillez entrer la ville : ");
            String city = scanner.nextLine();

            u.setName(name);
            u.setAge(age);
            u.setCity(city);
            udao.save(u);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void modifyAccount() {
        CompteDAO cdao = new CompteDAO();

        displayAccount();

        System.out.println("Veuillez entrer l'id du compte a modifier : ");
        int userChoice = scanner.nextInt();
        Compte c = cdao.getById(userChoice);
        if (c != null) {
            /* Flash */
            scanner.nextLine();
            System.out.println("Veuillez entrer le rib : ");
            String rib = scanner.nextLine();
            System.out.println("Veuillez entrer le solde : ");
            double solde = scanner.nextInt();

            c.setRib(rib);
            c.setSolde(solde);
            c.setId_client(userChoice);
            cdao.save(c);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void modifyCard() {
        CarteDAO cdao = new CarteDAO();

        displayCard();

        System.out.println("Veuillez entrer l'id de la carte a modifier : ");
        int userChoice = scanner.nextInt();
        Carte c = cdao.getById(userChoice);
        if (c != null) {
            /* Flash */
            scanner.nextLine();
            System.out.println("Veuillez entrer le numero de carte : ");
            String numero = scanner.nextLine();
            System.out.println("Veuillez entrer le type de carte : ");
            String typeC = scanner.nextLine();
            System.out.println("Veuillez entrer la date d'expiration de la carte : ");
            int an_exp = scanner.nextInt();

            c.setNumero(numero);
            c.setTypeC(typeC);
            c.setAn_exp(an_exp);
            c.setId_compte(userChoice);
            cdao.save(c);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void deleteClient() {
        ClientDAO udao = new ClientDAO();
        CompteDAO comptedao = new CompteDAO();
        CarteDAO cartedao = new CarteDAO();

        displayClient();
        
        System.out.println("Veuillez entrer l'id de l'utilisateur a supprimer : ");
        int userChoice = scanner.nextInt();
        Compte c = comptedao.getByIdClient(userChoice);

        if (udao.getById(userChoice) != null) {
            cartedao.deleteCardByIdCompte(c.getId());
            comptedao.deleteAccountByIdClient(userChoice);
            udao.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void deleteAccount() {
        CompteDAO cdao = new CompteDAO();

        displayAccount();

        System.out.println("Veuillez entrer l'id du compte a supprimer : ");
        int userChoice = scanner.nextInt();

        if (cdao.getById(userChoice) != null) {

            cdao.deleteById(userChoice);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void deleteCard() {
        CarteDAO cdao = new CarteDAO();

        displayCard();

        System.out.println("Veuillez entrer l'id de la carte a supprimer : ");
        int userChoice = scanner.nextInt();

        if (cdao.getById(userChoice) != null) {
            cdao.deleteById(userChoice);
            
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void displayAdmin() {
        ArrayList<Admin> admins = new ArrayList<>();
        AdminDAO adao = new AdminDAO();

        admins = adao.getAll();

        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

    public static void addAdmin() {
        Admin a = new Admin();
        AdminDAO udao = new AdminDAO();

        System.out.println("Veuillez entrer l'username : ");
        String name = scanner.nextLine();
        System.out.println("Veuillez entrer le mot de passe : ");
        String mdp = scanner.nextLine();

        a.setAdmin_user(name);
        a.setAdmin_password(mdp);

        udao.save(a);
    }

    public static void modifyAdmin() {
        AdminDAO adao = new AdminDAO();

        displayAdmin();

        System.out.println("Veuillez entrer l'id de l'admin a modifier : ");
        int userChoice = scanner.nextInt();
        Admin a = adao.getById(userChoice);
        if (a != null) {
            /* Flash */
            System.out.println("Veuillez entrer l'username : ");
            String name = scanner.nextLine();
            System.out.println("Veuillez entrer le mot de passe : ");
            String mdp = scanner.nextLine();

            a.setAdmin_user(name);
            a.setAdmin_password(mdp);
            adao.save(a);
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void deleteAdmin() {
        AdminDAO adao = new AdminDAO();

        displayAdmin();

        System.out.println("Veuillez entrer l'id de l'admin a supprimer : ");
        int userChoice = scanner.nextInt();

        if (adao.getById(userChoice) != null) {
            adao.deleteById(userChoice);
            
        } else {
            System.out.println("Erreur ID invalide");
        }
    }

    public static void transferFunds() {
        CompteDAO compteDAO = new CompteDAO();

        System.out.println("Veuillez entrer l'ID du compte source : ");
        int sourceAccountId = scanner.nextInt();

        System.out.println("Veuillez entrer l'ID du compte destination : ");
        int destinationAccountId = scanner.nextInt();

        System.out.println("Veuillez entrer le montant à transférer : ");
        double amount = scanner.nextDouble();

        Compte sourceAccount = compteDAO.getById(sourceAccountId);
        Compte destinationAccount = compteDAO.getById(destinationAccountId);

        if (sourceAccount != null && destinationAccount != null) {
            if (sourceAccount.getSolde() >= amount) {
                sourceAccount.setSolde(sourceAccount.getSolde() - amount);
                destinationAccount.setSolde(destinationAccount.getSolde() + amount);

                compteDAO.save(sourceAccount);
                compteDAO.save(destinationAccount);

                System.out.println("Transfert de fonds effectue");
            } else {
                System.out.println("Solde insuffisant pour effectuer le transfert");
            }
        } else {
            System.out.println("Erreur");
        }
    }

    public static void saveHistorique(int adminId, String tache) {
        HistoriqueDAO historiqueDAO = new HistoriqueDAO();
        Historique historique = new Historique(adminId, new Timestamp(System.currentTimeMillis()), tache);
        historiqueDAO.save(historique);
    }

    private static void searchClient() {
        ClientDAO clientDAO = new ClientDAO();
    
        System.out.println("Veuillez entrer le prenom recherche : ");
        String search = scanner.next();
    
        ArrayList<Client> searchResults = clientDAO.searchClients(search);
    
        if (searchResults != null && !searchResults.isEmpty()) {
            System.out.println("Résultats de la recherche : ");
            for (Client client : searchResults) {
                System.out.println(client);
            }
        } else {
            System.out.println("Aucun résultat trouvé pour  : " + search);
        }
    }
    

    public static int menu() {
        System.out.println("---- MENU ----");
        System.out.println("1 - Liste des utilisateurs");
        System.out.println("2 - Ajouter un utilisateur");
        System.out.println("3 - Modifier un utilisateur");
        System.out.println("4 - Supprimer un utilisateur");
        System.out.println("5 - Liste des comptes");
        System.out.println("6 - Ajouter un compte");
        System.out.println("7 - Modifier un compte");
        System.out.println("8 - Supprimer un compte");
        System.out.println("9 - Liste des cartes");
        System.out.println("10 - Ajouter une carte");
        System.out.println("11 - Modifier une carte");
        System.out.println("12 - Supprimer une carte");
        System.out.println("13 - Liste des admins");
        System.out.println("14 - Ajouter un admin");
        System.out.println("15 - Modifier un admin");
        System.out.println("16 - Supprimer un admin");
        System.out.println("17 - Transfert de fond");
        System.out.println("18 - Recherche client");
        System.out.println("19 - Quitter");
        System.out.println("Votre choix : ");
        return scanner.nextInt();
    }
}
