package Day_2While_For.For.Ex02;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nbr;
        int i;

        System.out.println("Veuillez entrer un nombre");
        nbr = scanner.nextInt();

        for(i = 0; i < 10; i++) {
            nbr++;
            System.out.println(nbr);
        }
        scanner.close();
    }
}
