package Day_2While_For.While.Ex02;
import java.util.Scanner;
public class Main02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre ");
        int nb = scanner.nextInt();

        while (nb < 10 || nb > 20) {
            if (nb < 9) {
                System.out.println("Trop petit ... ");
                nb = scanner.nextInt();
            } else if (nb > 21) {
                System.out.println("Trop grand ...");
                nb = scanner.nextInt();
            }
            
        }
    }
}
