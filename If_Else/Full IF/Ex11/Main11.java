package Ex11;

import java.util.Scanner;
/*11-	On désire écrire un algorithme qui permet d’afficher le jour 
        correspondant à un chiffre allant de 1 à 7 , entré au clavier. 
*/
public class Main11 {
    public static void main11(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un chiffre de 1 à 7 : ");
        int numeroJour = scanner.nextInt();

        String nomJour;

        if (numeroJour == 1) {
            nomJour = "Lundi";
        } else if (numeroJour == 2) {
            nomJour = "Mardi";
        } else if (numeroJour == 3) {
            nomJour = "Mercredi";
        } else if (numeroJour == 4) {
            nomJour = "Jeudi";
        } else if (numeroJour == 5) {
            nomJour = "Vendredi";
        } else if (numeroJour == 6) {
            nomJour = "Samedi";
        } else if (numeroJour == 7) {
            nomJour = "Dimanche";
        } else {
            nomJour = "Jour non valide";
        }
        System.out.println("Le jour correspondant est : " + nomJour);
        scanner.close();
    }
}
