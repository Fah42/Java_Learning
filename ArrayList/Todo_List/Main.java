package Todo_List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> col = new ArrayList();
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		int choix=-1;
		while(choix!=4) {
			choix=menu();
			if(choix==1) {
				ajouter();
			}else if(choix == 2) {
				supprimer();
			} else if (choix == 3) {
                afficher();
            }
		}
		
	}
    public static void supprimer() {
        int i = 0;
        while (i < col.size()) {
            System.out.println(i + " - " + col.get(i));
            i++;
        }
        
        System.out.println("Veuillez entrer l'index de la tache a supprimer : ");
        int userValue = scanner.nextInt();
        col.remove(userValue);

    }
	public static void afficher() {
		for(String val:col) {

			System.out.println(val);
		}
	}
	public static void ajouter() {
		System.out.println("Donnez une tache : ");
        scanner.nextLine();
		String nbr = scanner.nextLine();
		col.add(nbr);
	}
	public static int menu() {
		System.out.println("---- MENU ----");
		System.out.println("1 - Ajouter une tache ");
		System.out.println("2 - Supprimer une tache");
		System.out.println("3 - Lister toutes les taches");
        System.out.println("4 - Quitter");
		System.out.println("Votre choix : ");
		int c=scanner.nextInt();
		return c;
	}
}
