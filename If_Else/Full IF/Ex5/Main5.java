package Ex5;

import java.util.Scanner;

/*
5-    Écrire un programme qui
      demande à l'utilisateur deux nombre et l’informe ensuite qui était
      le plus grand
 */
public class Main5 {
    public static void main5(String[] args) {

        Scanner stdout = new Scanner(System.in);
        int nb1;
        int nb2;

        System.out.println("Donnez un premier nombre : ");
        nb1 = stdout.nextInt();

        System.out.println("Donnez un deuxieme nombre : ");
        nb2 = stdout.nextInt();

        if(nb1 > nb2) {
            System.out.println(nb1 + " est superieur a " + nb2);
        } else if (nb1 < nb2) {
            System.out.println(nb2 + "est superieur a " + nb1);
        } else {
            System.out.println("Ils sont egaux");
        }
        stdout.close();
    }
}
