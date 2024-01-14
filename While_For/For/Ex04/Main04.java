package Day_2While_For.For.Ex04;
import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        int i;
        int nbr;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre : ");
        nbr = scanner.nextInt();
        System.out.print("Les nombres pairs de 0 a " + nbr + " sont : " );
        for(i = 0; i <= nbr; i++) {
            if (i % 2 == 0) {
                System.out.print(i+" ");
            }
        }
        scanner.close();
    }
}

