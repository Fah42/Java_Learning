package Ex12;
import java.util.Scanner;

/*
12-	Ecrire un algorithme qui permet de saisir 
    deux nombres entiers x ,y et les afficher à l’écran dans l’ordre croissant. 
*/
public class Main12 {
    public static void main12(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez le premier nombre : ");
    int x = scanner.nextInt();

    System.out.print("Entrez le deuxième nombre : ");
    int y = scanner.nextInt();

    if (x < y) {
        System.out.println("Les nombres dans l'ordre croissant : " + x + ", " + y);
    } else if (x > y) {
        System.out.println("Les nombres dans l'ordre croissant : " + y + ", " + x);
    } else {
        System.out.println("Les deux nombres sont égaux : " + x + ", " + y);
    }
    scanner.close();  
    }
}
