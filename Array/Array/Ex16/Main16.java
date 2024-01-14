package Day_3_4.Array.Ex16;

import java.util.Scanner;

public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer une taille de tableau : ");

        int taille = scanner.nextInt();
        int i = 0, y  = 0;
        int arr[] = new int [taille];

        while (i < taille) {
            System.out.println("Donnez un nombre : ");
            arr[i] = scanner.nextInt() + 1;
            i++;
        }
        
        i = 0;
        while (i < taille) {
            System.out.print(arr[i]);
            i++;
        }
    }
}
