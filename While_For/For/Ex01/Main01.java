package Day_2While_For.For.Ex01;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        int i;
        int nbr;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Donnez un nombre : ");
        nbr = scanner.nextInt();

        for(i = 1; i <= nbr ; i++) {
            System.out.println(i);
        }
        scanner.close();
    }
}
