package Ex04;

import java.util.ArrayList;

public class Main04 {
    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();
        langages.add("PHP");
        langages.add("Java");
        langages.add("C++");
        langages.add("Python");
        langages.add(0, "Zack");
        System.out.println(langages.isEmpty());
    }
}
