package Day_2While_For.While.Ex01;
import java.util.Scanner;
public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre compris entre 1 et 3 : ");
        int nb = scanner.nextInt();

        while (nb < 1 || nb > 3) {
            System.out.println("Veuillez entrer un nombre compris entre 1 et 3 : ");
            nb = scanner.nextInt();
        }
    }
}
