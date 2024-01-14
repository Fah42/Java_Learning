package Day_2While_For.For.Ex06;
import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        int x;
        int y;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez entrer un premier nombre : ");
        x = scanner.nextInt();

        System.out.println("Veuillez entrer un deuxieme nombre : ");
        y = scanner.nextInt();

        int min, max;
        if (x <= y) {
            min = x;
            max = y;
        } else {
            min = y;
            max = x;
        }
        for (int i = min; i <= max; i++) {
            System.out.print(i + " ");
        }
        scanner.close();
    }
}
