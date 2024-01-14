package Day_3_4.Array.Ex19;

import java.util.Scanner;

public class Main19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer le nombre d'eleve : ");
        int lenght = scanner.nextInt();
        double somme = 0;
        double moyenneEleve[] = new double[lenght];
        int result = 0;

        for (int i = 0; i < lenght; i++) {
            System.out.print("Entrez la moyenne générale de l'élève " + i + " : ");
            moyenneEleve[i] = scanner.nextDouble();
            somme += moyenneEleve[i];
        }

        double moyenneClasse = somme / 10;

        for (int i = 0; i < lenght; i++) {
            if (moyenneEleve[i] > moyenneClasse) {
                result++;
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
