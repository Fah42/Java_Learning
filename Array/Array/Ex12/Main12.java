package Day_3.Array.Ex12;
import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tableau = {3, 7, 4, 9, 8};
        int n = 5; // Nombre actuel d'éléments dans le tableau

        System.out.println("Veuillez choisir un element a ajouter au tableau : ");
        int nouvelElement = scanner.nextInt();
        System.out.println("Veuillez choisir a quelle position : ");
        int position = scanner.nextInt(); // Position à laquelle insérer le nouvel élément

        // Vérifier si la position est valide
        if (position < 0 || position > n) {
            System.out.println("Position invalide");
        } else {
            // Créer un nouveau tableau si nécessaire
            if (n == tableau.length) {
                int[] nouveauTableau = new int[tableau.length + 1];
                for (int i = 0; i < position; i++) {
                    nouveauTableau[i] = tableau[i];
                }
                nouveauTableau[position] = nouvelElement;
                for (int i = position; i < n; i++) {
                    nouveauTableau[i + 1] = tableau[i];
                }
                tableau = nouveauTableau;
                n++;
            } else {
                // Déplacer les éléments pour faire de la place
                for (int i = n; i > position; i--) {
                    tableau[i] = tableau[i - 1];
                }
                // Insérer le nouvel élément
                tableau[position] = nouvelElement;
                n++;
            }

            // Afficher le tableau après insertion
            for (int i = 0; i < n; i++) {
                System.out.println(tableau[i]);
            }
        }
    }
}
