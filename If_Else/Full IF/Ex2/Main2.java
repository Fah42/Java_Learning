package Ex2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner stdout = new Scanner(System.in);
        int nbr, result;

        System.out.println("Quel est votre chiffre ? ");
        nbr = stdout.nextInt();
        result = nbr * nbr;
        System.out.println("Bonjour, " + result);
        stdout.close();
    }
}
