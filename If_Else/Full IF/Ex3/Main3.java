package Ex3;

import java.util.Scanner;

public class Main3 {
    public static  void main3 (String[] args) {
        Scanner stdout = new Scanner(System.in);
        int nbr;

        System.out.println("Donnez un nombre : ");
        nbr = stdout.nextInt();

        if(nbr >= 0) {
            System.out.println("Pos");
        } else if (nbr < 0) {
            System.out.println("Neg");
        }
        stdout.close();
    }
}
