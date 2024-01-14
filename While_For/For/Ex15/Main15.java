package Day_2While_For.For.Ex15;
import java.util.Scanner;

public class Main15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nb;

        System.out.println("Veuillez entrer un nombre : ");
        nb = scanner.nextInt();

        for(int i = 0; i < nb; i++) {
            for(int y = 0; y <= i; y++){
                System.out.print("*");
            }
            System.out.println("");
        }
        scanner.close();
    }
}
