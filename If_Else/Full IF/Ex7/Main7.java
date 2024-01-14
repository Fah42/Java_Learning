package Ex7;
import java.util.Scanner;

/*7-	Ecrire un algorithme qui demande trois nombres à l’utilisateur
 et l’informe ensuite s’ils sont rangés ou non dans l’ordre croissant. */

public class Main7 {
    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le premier nombre : ");
        double nb1 = scanner.nextDouble();
    
        System.out.print("Entrez le deuxième nombre : ");
        double nb2 = scanner.nextDouble();

        System.out.print("Entrez le troisieme nombre : ");
        double nb3 = scanner.nextDouble();

        if (nb1 < nb2 && nb2 < nb3) {
            System.out.println("Ils sont range dans l'ordre croissant");
        } else {
            System.out.println("nop");
        }
        scanner.close();
    }
}