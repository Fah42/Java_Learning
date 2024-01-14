package Day_3.Array.Ex05;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer une taille de tableau : ");

        int taille = scanner.nextInt();
        int i = 0;
        int arr[] = new int [taille];
        int pos_value = 0;
        int neg_value = 0;

        while (i < taille) {
            System.out.println("Donnez un nombre : ");
            arr[i] = scanner.nextInt();
            if (arr[i] >= 0) {
                pos_value++;
            } else {
                neg_value++;
            }
            i++;
        }
        System.out.println("Nombres de valeur positif : " + pos_value + "\n" + "Nombres de valeur negatif : " + neg_value);
        scanner.close();
    }
}