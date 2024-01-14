package Ex1;

import java.util.Scanner;

/*1-    Ecrire un programme qui demande son prénom à l'utilisateur, et qui lui réponde par un charmant « Bonjour » suivi du prénom. On aura ainsi le dialogue suivant :
Programme : Quel est votre prénom ?
Utilisateur : Zack
Programme : Bonjour, Zack !

 */
public class Main {
    public static void main(String[] args) {
        Scanner stdout = new Scanner(System.in);
        String name;

        System.out.println("Quel est votre prénom ? ");
        name = stdout.nextLine();
        System.out.println("Bonjour, " + name);
        stdout.close();
    }
}
