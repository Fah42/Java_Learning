package Day_3_4.Array.Ex17;
import java.util.Scanner;

public class Main17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer une taille de tableau : ");

        int taille = scanner.nextInt();
        int i = 0, max  = 0, pos = 0;
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
                pos = i + 1;
            }
            i++;
        }
        System.out.println("La valeur max est : " + max + "\na la position : " + pos);
    }
}
