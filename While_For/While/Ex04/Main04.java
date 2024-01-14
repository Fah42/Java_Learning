package Day_2While_For.While.Ex04;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre ");
        int nb = scanner.nextInt();
        int i = 1;

        while (i <= nb) {
            System.out.println(i);
            i++;
           }
        }
    }
