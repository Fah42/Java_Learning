package Ex02;

import java.util.ArrayList;

public class Main02 {
    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();
        langages.add("PHP");
        langages.add("Java");
        langages.add("C++");
        langages.add("Python");
        for (int i = 0; i < langages.size(); i++) {
            System.out.println(langages.get(i));
        }
    }
}
