package Day_3_4.Array.Ex18;

import java.util.Scanner;

public class Main18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer une taille de tableau : ");

        int taille = scanner.nextInt();
        int i = 0, max  = 0, sec_max = 0, pos = 0, sec_pos = 0;
        int arr[] = new int [taille];

        while (i < taille) {
            System.out.println("Donnez un nombre : ");
            arr[i] = scanner.nextInt();
            i++;
        }
        
        i = 0;
        while (i < taille) {
            if (max < arr[i]) {
                max = arr[i];
                pos = i;
            }
            i++;
        }
        i = 0;
        while (i < taille) {
            if (sec_max < arr[i] && arr[i] != arr[pos]) {
                sec_max = arr[i];
                sec_pos = i + 1;
            }
            i++;
        }
        pos+=1;
        System.out.println("La valeur max est : " + max + "\na la position : " + pos);
        System.out.println("La valeur deuxieme max est : " + sec_max + "\na la position : " + sec_pos);
    }
}
