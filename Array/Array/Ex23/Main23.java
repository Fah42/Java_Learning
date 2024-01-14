package Day_3_4.Array.Ex23;
import java.util.Scanner;
public class Main23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = {52, 82, 57, 105, 23, 95, 315};
        int arr_copy[] = {52, 82, 57, 105, 23, 95, 315};
        int i = 0, tmp = 0;
        
        System.out.println("veuillez entrer un premier index : ");
        int first_index = scanner.nextInt();
        System.out.println("veuillez entrer un deuxieme index : ");
        int second_index = scanner.nextInt();

        tmp = arr_copy[first_index];
        arr_copy[first_index] = arr_copy[second_index];
        arr_copy[second_index] = tmp;

        while (i < arr_copy.length) {
            System.out.print(arr_copy[i] + " ");
            i++;
        }
        i = 0;
        System.out.println();
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }
    }
}
