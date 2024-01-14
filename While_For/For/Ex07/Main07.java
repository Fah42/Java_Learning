package Day_2While_For.For.Ex07;
import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre de départ : ");
        int nombreDepart = scanner.nextInt();
        int somme = 0;

        for (int i = 1; i <= nombreDepart; i++) {
            somme += i;
            System.out.print(i);
            if (i < nombreDepart) {
                System.out.print(" + ");
            }
        }

        System.out.println(" = " + somme);
        scanner.close();
    }
}
