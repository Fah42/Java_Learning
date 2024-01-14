package Day_3_4.Array.Ex21;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = {5, 2, 7, 5, 8, 8, 3, 9};
        boolean isInArr = false;
        int i = 0, pos = 0;
        System.out.println("Veuillez entrer la valeur recherche dans le tableau : ");
        int searched_value = scanner.nextInt();
        
        while (i < arr.length) {
            if (searched_value == arr[i]) {
                isInArr = true;
                pos = i + 1;
            }
            i++;
        }
        if (isInArr) {
            System.out.println(isInArr + " a la position : " + pos);

        } else {
            System.out.println(isInArr);
        }
    }
}
