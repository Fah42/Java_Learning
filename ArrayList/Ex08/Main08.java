package Ex08;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> col = new ArrayList<>();
        int i = 0;
        int nb;

        while(i < 5) {
            System.out.println("Veuillez entrer une valeur");
            nb = scanner.nextInt();
            col.add(nb);
            i++;
        }
        System.out.println(Collections.min(col) + " " + Collections.max(col));
        scanner.close();
    }
}
