package Day_3.Array.Ex06;

import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer une taille de tableau : ");

        int taille = scanner.nextInt();
        int i = 0;
        int arr[] = new int [taille];
        int max_value = 0;
        int min_value = 0;

        while (i < taille) {
            System.out.println("Donnez un nombre : ");
            arr[i] = scanner.nextInt();
            if (arr[i] >= max_value) {
                max_value = arr[i];
            } else if (arr[i] <= min_value){
                min_value = arr[i];
            }
            i++;
        }
        System.out.println("Nombres de valeur positif : " + max_value + "\n" + "Nombres de valeur negatif : " + min_value);
        scanner.close();
    }
}