package Day_3.Array.Ex03;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer une taille de tableau : ");

        int taille = scanner.nextInt();
        int i = 0;
        int arr[] = new int [taille];

        while (i < taille) {
            System.out.println("Donnez un nombre : ");
            arr[i] = scanner.nextInt();
            i++;
        }

        i = 0;
        for (int val:arr) {
            if (val < 0) {
                System.out.print(val + " ");
            }
        }
        scanner.close();
    }
}
