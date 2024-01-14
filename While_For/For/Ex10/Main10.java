package Day_2While_For.For.Ex10;

import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value;
        int max = 0;
        int i;
        int pos = 1;

        for(i = 1; i <= 20 ; i++) {
            System.out.println("Veuillez entrer un nombre : ");
            value = scanner.nextInt();
            if (value >= max) {
                max = value;
                pos = i;
            }
        }
        System.out.println("Le nombre le plus grand est : " + max);
        System.out.println("C'etait le nombre numero : " + pos);
        scanner.close();
    }
}
