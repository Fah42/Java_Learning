package Day_3.Array.Ex07;

import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer une taille de tableau : ");

        int taille = scanner.nextInt();
        int i = 0;
        int arr[] = new int [taille];
        int even = 0;
        int odd = 0;

        while (i < taille) {
            System.out.println("Donnez un nombre : ");
            arr[i] = scanner.nextInt();
            if (arr[i] % 2 == 0) {
                even++;
            } else if (arr[i] % 3 == 0){
                odd++;
            }
            i++;
        }
        System.out.println("Nombres d'elements pair : " + even + "\n" + "Nombres d'element impair : " + odd);
        scanner.close();
    }
}