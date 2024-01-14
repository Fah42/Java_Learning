package Day_3.Array.Ex08;

import java.util.Scanner;

public class Main08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer une taille de tableau : ");

        int taille = scanner.nextInt();
        int i = 0, y  = 0;
        int arr[] = new int [taille];
        int arr_value[] = new int [taille];

        while (i < taille) {
            System.out.println("Donnez un nombre : ");
            arr[i] = scanner.nextInt();
            i++;
        }
        i = 0;
        
        while (i < taille) {
            while (y < taille) {
                if (arr[i] == arr[y]) {
                    arr_value[y]++;
                }
                y++;
            }
            System.out.println("Element" + i + " : " + arr_value[i]);
            y = 0;
            i++;
        }
        scanner.close();
    }
}