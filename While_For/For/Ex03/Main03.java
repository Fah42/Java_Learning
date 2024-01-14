package Day_2While_For.For.Ex03;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        int i;
        int nbr;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre : ");
        nbr = scanner.nextInt();

        for(i = 1; i <= 10; i++) {
            System.out.println(nbr + " x " + i + "=" + nbr*i);
        }
        scanner.close();
    }
}