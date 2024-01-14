package Ex10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        langages.add("PHP");
        langages.add("Java");
        langages.add("C++");
        langages.add("Python");

        System.out.println("Veuillez taper votre recherche : ");
        String userValue = scanner.nextLine();

        System.out.println("L'element existe a la position : " + langages.indexOf(userValue));

        System.out.println(langages);

    }
}
