package Ex20;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Main20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> col = new ArrayList<>();
        int i = 0, nb = 0, searchedValue = 0, valueFrenquency = 0;

        while(i < 5) {
            System.out.println("Veuillez entrer une valeur");
            nb = scanner.nextInt();
            col.add(nb);
            i++;
        }
        System.out.println("Nombre a rechercher : ");
        searchedValue = scanner.nextInt();
        valueFrenquency = Collections.frequency(col, searchedValue);

        System.out.println("La valeur apparait : " + valueFrenquency + " de fois dans la collection");
        scanner.close();
    }
}
