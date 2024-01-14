package Day_3_4.Array.Ex20;
import java.util.Scanner;

public class Main20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = {12, 15, 13, 10, 8, 9, 13, 14};
        boolean isInArr = false;
        int i = 0;
        System.out.println("Veuillez entrer la valeur recherche dans le tableau : ");
        int searched_value = scanner.nextInt();
        
        while (i < arr.length) {
            if (searched_value == arr[i]) {
                isInArr = true;
            }
            i++;
        }
        System.out.println(isInArr);
    }
}
