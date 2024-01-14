package Ex11;
import java.util.ArrayList;
import java.util.Collections;

public class Main11 {
    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();

        langages.add("PHP");
        langages.add("Java");
        langages.add("C++");
        langages.add("Python");
        Collections.sort(langages);

        System.out.println(langages);
    }
}
