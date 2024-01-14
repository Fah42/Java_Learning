package Day_2While_For.For.Ex09;
import java.util.Scanner;
public class Main09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value;
        int max = 0;
        int i;

        for(i = 1; i <= 20 ; i++) {
            System.out.println("Veuillez entrer un nombre : ");
            value = scanner.nextInt();
            if (value >= max) {
                max = value;
            }
        }
        System.out.println("Le nombre le plus grand est : " + max);
        scanner.close();
    }
}
