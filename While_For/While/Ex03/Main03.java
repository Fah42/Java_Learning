package Day_2While_For.While.Ex03;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre ");
        int nb = scanner.nextInt();
        int nb_max = nb;
        int pos = 0;
        int i = 0;

        while (nb != 0) {
            if (nb > nb_max && nb != 0) {
                nb_max = nb;
                pos = i;
            }
            System.out.println("Veuillez entrer un nombre ");
            nb = scanner.nextInt();
            i++;
        }
            System.out.println("nb : " + nb_max + " \npos : " + pos);
            scanner.close();
        }
    }
