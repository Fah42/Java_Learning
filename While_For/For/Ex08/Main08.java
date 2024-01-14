package Day_2While_For.For.Ex08;
import java.util.Scanner;

public class Main08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre de départ : ");
        int nombreDepart = scanner.nextInt();
        int somme = 1;

        for (int i = 1; i <= nombreDepart; i++) {
            somme *= i;
            System.out.print(i);
            if (i < nombreDepart) {
                System.out.print(" * ");
            }
        }

        System.out.println(" = " + somme);
        scanner.close();
    }
}

