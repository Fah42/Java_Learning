package Ex13;
import java.util.ArrayList;
import java.util.Collections;

public class Main13 {
    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();

        langages.add("PHP");
        langages.add("Java");
        langages.add("C++");
        langages.add("Python");

        ArrayList<String> langagesBis = new ArrayList<>(langages);
        System.out.println(langagesBis);
    }  
}
