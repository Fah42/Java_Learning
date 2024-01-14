package Ex15;
import java.util.Collections;
import java.util.ArrayList;

public class Main15 {
    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();

        langages.add("PHP");
        langages.add("Java");
        langages.add("C++");
        langages.add("Python");

        Collections.shuffle(langages);
        System.out.println(langages);
    } 
}
