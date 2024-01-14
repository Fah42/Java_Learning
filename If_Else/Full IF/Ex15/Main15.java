package Ex15;

import java.util.Scanner;

public class Main15 {
    public static void main15(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Entrer l'heure : ");
        byte hour = scanner.nextByte();
        
        System.out.println("Entrer les minutes : ");
        byte minute = scanner.nextByte();

        System.out.println("Entrer les secondes : ");
        byte second = scanner.nextByte();

        if (hour == 23 && minute == 59 && second == 59) {
            hour = 0;
            minute = 0;
            second = 0;
        } else if (minute == 59 && second == 59) {
            hour += 1;
            minute += 0;
            second = 0;
        } else if (second == 59){
            minute += 1;
        } else {
            second += 1;
        }
        scanner.close();
        System.out.println("Il sera : " + hour + " : " + minute + " : " + second);
    }
}
