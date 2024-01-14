package Ex9;

import java.util.Scanner;

/*
9-	Écrire un algorithme qui : 
    demande à l’utilisateur deux nombres, et l'informe s'il y a au moins un positif. 
*/
public class Main9 {
    public static void main9(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un premier nombre : ");
        double nb1 = scanner.nextDouble();

        System.out.print("Entrez un deuxieme nombre : ");
        double nb2 = scanner.nextDouble();

        if (nb1 > 0 || nb2 > 0) {
            System.out.println("Il y a au moins un nombre positif");
        } else {
            System.out.println("Il n'y a pas de positif");
        }
        scanner.close();
    }
}
