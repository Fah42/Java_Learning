package Ex16;

import java.util.Scanner;

/*
 * 16-	Les habitants de Zorglub paient l’impôt selon les règles suivantes : 
          - les hommes de plus de 20 ans paient l’impôt 
          - les femmes paient l’impôt si elles ont entre 18 et 35 ans 
          - les autres ne paient pas d’impôt 
Le programme demandera donc l’âge et le sexe du Zorglubien, et se prononcera donc ensuite sur le fait que l’habitant est imposable
 */

public class Main16 {
    public static void main16(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quel est l'âge de l'habitant de Zorglub ? ");
        byte age = scanner.nextByte();

        System.out.print("Quel est le sexe de l'habitant (M pour homme, F pour femme) ? ");
        char sexe = scanner.next().charAt(0);

        boolean estImposable = false;

        if (sexe == 'M' && age > 20) {
            estImposable = true;
        } else if (sexe == 'F' && age >= 18 && age <= 35) {
            estImposable = true;
        }

        // Afficher le résultat
        if (estImposable) {
            System.out.println("L'habitant de Zorglub est imposable.");
        } else {
            System.out.println("L'habitant de Zorglub n'est pas imposable.");
        }
        scanner.close();
    }
}
