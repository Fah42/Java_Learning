package Ex05;

import java.util.ArrayList;
import java.util.Collections;

public class Main05 {
    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();
        langages.add("PHP");
        langages.add("Java");
        langages.add("C++");
        langages.add("Python");
        langages.add(0, "Zack");
        Collections.replaceAll(langages,"C++", "Zack");
        System.out.println(langages);
    }
}
