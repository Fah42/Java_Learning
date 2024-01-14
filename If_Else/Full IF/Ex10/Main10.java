package Ex10;

import java.util.Scanner;
public class Main10 {
    public static void main10(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un premier nombre : ");
        double age = scanner.nextDouble();

        if (age >= 6 && age <= 7) {
            System.out.println("Poussin");
        } else if (age >= 8 && age <= 9) {
            System.out.println("Pupille");
        } else if (age >= 10 && age <= 11) {
            System.out.println("Minime");
        } else if (age >= 12) {
            System.out.println("Cadet");
        } else {
            System.out.println("Hors Categorie");
        }
        scanner.close();
    }
}
