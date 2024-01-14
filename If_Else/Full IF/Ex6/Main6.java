package Ex6;

import java.util.Scanner;

public class Main6 {
public static void main6(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez le premier nombre : ");
    double nombre1 = scanner.nextDouble();

    System.out.print("Entrez le deuxième nombre : ");
    double nombre2 = scanner.nextDouble();

    if ((nombre1 > 0 && nombre2 > 0) || (nombre1 < 0 && nombre2 < 0)) {
        System.out.println("Le produit est positif.");
    } else if (nombre1 == 0 || nombre2 == 0) {
        System.out.println("Le produit est nul.");
    } else {
        System.out.println("Le produit est négatif.");
    }
    scanner.close();
    }
}
