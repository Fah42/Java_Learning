package CRUD_object;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Client> colClients = new ArrayList<>();
	static ArrayList<Compte> colComptes = new ArrayList<>();
	static ArrayList<Carte> colCartes = new ArrayList<>();
    public static void main(String[] args) {
        int userChoice=0;
		while(userChoice!=12) {
			userChoice=displayMenu();
			if(userChoice==1) {
				displayClient();
			}else if(userChoice==2) {
				displayAccount();
			}else if(userChoice==3) {
				displayCreditCard();
			}else if(userChoice==4) {
				moneyTransfer();
			}else if(userChoice==5) {
				lfClient();
			}else if(userChoice==6) {
				addClient();
			}else if(userChoice==7) {
				addAccount();
			}else if(userChoice==8) {
				addCard();
			}else if(userChoice==9) {
				deleteClient();
			}else if(userChoice==10) {
				deleteAccount();
			}else if(userChoice==11) {
				deleteCard();
			} else if (userChoice==12) {
				test();
			}
		}
    }

	public static int getIndexOfIdClient(int id) {
		int index = -1;

		for(int i = 0; i < colClients.size(); i++) {
			if (id == colClients.get(i).getId()) {
				index = i;
			}
		}

		if (index == -1) {
			System.out.println("L'index est invalide veuillez rentrer un index valide.");
		}
		return index;
	}

	public static void displayClient() {
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
	
	public static void displayAccount() {
		if (colComptes.isEmpty()) {
            System.out.println("--------------------");
            System.out.println("Aucun compte enregistré.");
            System.out.println("--------------------");
        } else {
            System.out.println("--------------------\n");
            System.out.println("Liste des comptes\n");
            System.out.println("--------------------\n");
            for (Compte val:colComptes) {
                System.out.println("--------------------\n");
                System.out.println(val);
                System.out.println("\n--------------------");
            }
        }
	}
	
	public static void displayCreditCard() {
		if (colCartes.isEmpty()) {
            System.out.println("--------------------");
            System.out.println("Aucune carte enregistré.");
            System.out.println("--------------------");
        } else {
            System.out.println("--------------------\n");
            System.out.println("Liste des cartes\n");
            System.out.println("--------------------\n");
            for (Carte val:colCartes) {
                System.out.println("--------------------\n");
                System.out.println(val);
                System.out.println("\n--------------------");
            }
        }
	}
	

	public static void addClient() {
		String lastName;
        String firstName;
        String city;
        int age;

		System.out.println("--------------------");
        System.out.println("Ajout d'un client");
        System.out.println("--------------------");
		
		/* flash */
		scanner.nextLine();

		System.out.println("Veuillez entrer le prenom du client");
		firstName = scanner.nextLine();
		System.out.println("Veuillez entrer le nom du client");
		lastName = scanner.nextLine();
		System.out.println("Veuillez entrer l'age du client");
		age = scanner.nextInt();

		/* flash */
		scanner.nextLine();

		System.out.println("Veuillez entrer la ville ou reside le client");
		city = scanner.nextLine();

		colClients.add(new Client(firstName, lastName, city, age));
		addAccount();
		addCard();
		System.out.println("--------------------");
        System.out.println("Insertion Reussie");
        System.out.println("--------------------");
	}

	public static void addAccount() {
		String rib;
        double solde;
        int idClient;

		System.out.println("--------------------");
        System.out.println("Ajout d'un compte client");
        System.out.println("--------------------");
		
		displayClient();
		do {
			System.out.println("Veuillez entrer l'ID du client : ");
			idClient = scanner.nextInt();
		} while (getIndexOfIdClient(idClient) < 0);

		/* flash */
		scanner.nextLine();

		System.out.println("Veuillez entrer le rib du client");
		rib = scanner.nextLine();
		System.out.println("Veuillez entrer le solde du client");
		solde = scanner.nextDouble();


		colComptes.add(new Compte(rib, solde, idClient));
		System.out.println("--------------------");
        System.out.println("Insertion du compte reussie");
        System.out.println("--------------------");
	}

	public static void addCard() {
		String num;
		int	aexp;
        int idClient;

		System.out.println("--------------------");
        System.out.println("Ajout d'une carte au compte client");
        System.out.println("--------------------");

		displayClient();
		do {
			System.out.println("Veuillez entrer l'ID du client :");
			idClient = scanner.nextInt();
		} while (getIndexOfIdClient(idClient) < 0);

		/* flash */
		scanner.nextLine();

		System.out.println("Veuillez entrer le numero de la carte du client");
		num = scanner.nextLine();
		System.out.println("Veuillez entrer la date d'expiration de la carte du client");
		aexp = scanner.nextInt();
		
		colCartes.add(new Carte(num, aexp, idClient));
		System.out.println("--------------------");
        System.out.println("Insertion de la carte reussie");
        System.out.println("--------------------");
	}



	public static void moneyTransfer() {

		int idCrediteur;
		int idDebiteur;
		int indexCrediteur;
		int indexDebiteur;
		double sommes;
		double soldeCrediteur;
		double soldeDebiteur;

		System.out.println("--------------------");
        System.out.println("Virement bancaire");
        System.out.println("--------------------");

		/*Verifier qu'il a au moins 2 clients */
		if (colClients.size() < 2) {
			System.out.println("Il faut au moins 2 clients pour effectuer un virement.");
			return ;
		}
		displayClient();

		System.out.println("Veuillez entrer l'id du debiteur");
		idDebiteur = scanner.nextInt();
		System.out.println("Veuillez entrer l'id du crediteur");
		idCrediteur = scanner.nextInt();
		
		indexDebiteur = getIndexOfIdClient(idDebiteur);
		indexCrediteur = getIndexOfIdClient(idCrediteur);
		
		System.out.println("Combiens souhaitez vous transferer ?");
		sommes = scanner.nextDouble();
		
		soldeCrediteur = colComptes.get(indexCrediteur).getSolde();
		colComptes.get(indexCrediteur).setSolde(soldeCrediteur + sommes);
		soldeDebiteur = colComptes.get(indexDebiteur).getSolde();
		colComptes.get(indexDebiteur).setSolde(soldeDebiteur - sommes);
	}

	public static void lfClient() {
		String userInput;
		
		/*Flash*/
		scanner.nextLine();

		System.out.println("veuillez entrer votre recherche : ");
		userInput = scanner.nextLine();

		for (Client val : colClients) {
			if (val.getFirstName().toLowerCase().contains(userInput.toLowerCase()) ||
				val.getLastName().toLowerCase().contains(userInput.toLowerCase()) ||
				val.getCity().toLowerCase().contains(userInput.toLowerCase())) {
					System.out.println(val);
				}
		}
	}

	public static void deleteClient() {
		int userChoice;
		int index;

		System.out.println("Veuillez choisir l'ID du client a supprimer");
		userChoice = scanner.nextInt();

		index = getIndexOfIdClient(userChoice);
		colClients.remove(index);
		colComptes.remove(index);
		colCartes.remove(index);
	}
	public static void deleteAccount() {
		
	}
	
	public static void deleteCard() {
		
	}

	public static void test() {
		int userChoice;
		int index;

		System.out.println("Veuillez choisir l'ID du client a supprimer");
		userChoice = scanner.nextInt();

		index = getIndexOfIdClient(userChoice);
		System.out.println(colCartes.get(index));
		return ;
	}
	
	public static int displayMenu() {
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
