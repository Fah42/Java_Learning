package Day_3.Array.Ex09;

import java.util.Scanner;

public class Main09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer une taille de tableau : ");

        int taille = scanner.nextInt();
        int i = 0;
        int arr[] = new int [taille];
        int arr_copy[] = new int [taille];

        while (i < taille) {
            System.out.println("Donnez un nombre : ");
            arr[i] = scanner.nextInt();
            arr_copy[i] = arr[i];
            i++;
        }

        i = 0;
        System.out.print("Les elements du tableau source : ");
        while(i < taille) {
            System.out.print(arr[i]);
            i++;
        }
        i = 0;
        System.out.print("\nLes elements du tableau copie : ");
        while(i < taille) {
            System.out.print(arr_copy[i]);
            i++;
        }
        scanner.close();
    }
}