package Ex12;
import java.util.ArrayList;
import java.util.Collections;

public class Main12 {
    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();

        langages.add("PHP");
        langages.add("Java");
        langages.add("C++");
        langages.add("Python");
        Collections.reverse(langages);

        System.out.println(langages);
    }
}
