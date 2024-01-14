package Ex13;
import java.util.Scanner;

/* 
 13-	Cet algorithme est destiné à prédire l'avenir, et il doit être infaillible ! 
        Il lira au clavier l’heure et les minutes, et il affichera l’heure qu’il sera une minute plus tard.
        Par exemple, si l'utilisateur tape 21 puis 32, l'algorithme doit répondre : 
        " Dans une minute, il sera 21 heure(s) 33". 
        NB : on suppose que l'utilisateur entre une heure valide. Pas besoin donc de la vérifier.
*/
public class Main13 {
    public static void main13(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le premier nombre : ");
        int x = scanner.nextInt();

        System.out.print("Entrez le deuxieme nombre : ");
        int y = scanner.nextInt();

        if (x ==  23 || y == 59) {
            if (x == 23 && y == 59) {
                x = 0;
                y = 0;
            } 
            if (y == 59){
                x += 1;
                y = 0;
            }
            System.out.println("Il est : " + x + ":" + y + "H");
        } else {
            y += 1;
            System.out.println("Il sera : " + x + ":" + y + "H");
        }
        scanner.close();
    }
}
