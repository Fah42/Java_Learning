package Ex14;

import java.util.Scanner;

/*14-	Un magasin de reprographie facture 0,10 E les dix premières photocopies, 0,09 E 
        les vingt suivantes et 0,08 E au-delà. Ecrivez un algorithme qui demande à 
        l’utilisateur le nombre de photocopies effectuées et qui affiche la facture correspondante. 
*/
public class Main14 {
    public static void main14(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de photocopies effectuées : ");
        int nombrePhotocopies = scanner.nextInt();
        double facture;

        if (nombrePhotocopies <= 10) {
            facture = nombrePhotocopies * 0.10;
        } else if (nombrePhotocopies <= 30) {
            facture = 10 * 0.10 + (nombrePhotocopies - 10) * 0.09;
        } else {
            facture = 10 * 0.10 + 20 * 0.09 + (nombrePhotocopies - 30) * 0.08;
        }
        System.out.println("La facture pour " + nombrePhotocopies + " photocopies est de : " + facture + " euros");
        scanner.close();
    }
}
