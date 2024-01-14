package Ex06;

import java.util.ArrayList;

public class Main06 {
    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();
        langages.add("PHP");
        langages.add("Java");
        langages.add("C++");
        langages.add("Python");
        langages.set(2, "Zack");
        System.out.println(langages);
    }
}
