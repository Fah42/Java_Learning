package Day_3.Array.Ex11;

public class Main11 {
    public static void main(String[] args) {
       // Étape 1: Création et initialisation du tableau
       int[] tableau = {3, 7, 3, 9, 8};

       // Étape 2: Trouver et afficher les éléments uniques
       System.out.println("Éléments uniques :");
       for (int i = 0; i < tableau.length; i++) {
           boolean estUnique = true;

           // Vérifier si l'élément actuel apparaît ailleurs dans le tableau
           for (int j = 0; j < tableau.length; j++) {
               if (i != j && tableau[i] == tableau[j]) {
                   estUnique = false;
                   break;
               }
           }

           // Si l'élément est unique, l'afficher
           if (estUnique) {
               System.out.println(tableau[i]);
           }
       }
    }
}
