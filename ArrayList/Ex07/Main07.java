package Ex07;

import java.util.ArrayList;

public class Main07 {
    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();
        langages.add("PHP");
        langages.add("Java");
        langages.add("C++");
        langages.add("Python");
        langages.remove(2);
        System.out.println(langages);
    }
}
