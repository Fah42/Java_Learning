package Day_2While_For.For.Ex13;

import java.util.Scanner;

public class Main13 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double somme = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Entrez la moyenne générale de l'élève " + i + " : ");
            double moyenneEleve = scanner.nextDouble();

            somme += moyenneEleve;
        }

        double moyenneClasse = somme / 10;
        System.out.println("La moyenne de la classe est : " + moyenneClasse);
        scanner.close();
    }
}
