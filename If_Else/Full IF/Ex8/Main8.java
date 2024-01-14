package Ex8;


import java.util.Scanner;

public class Main8 {
    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre réel : ");
        double nombreReel = scanner.nextDouble();

        if (nombreReel < 0){
            double valeurAbsolue = nombreReel * -1;
            System.out.println("La valeur absolue de " + nombreReel + " est : " + valeurAbsolue);
        } else {
            System.out.println("La valeur absolue de " + nombreReel + " est : " + nombreReel);
        }
        scanner.close();
    }
}
