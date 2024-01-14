package Ex14;
import java.util.ArrayList;
import java.util.Collections;

public class Main14 {
    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();
        ArrayList<String> langagesBis = new ArrayList<>();

        langages.add("PHP");
        langages.add("Java");
        langages.add("C++");
        langages.add("Python");
        langagesBis.add("Ruby");
        langagesBis.add("Cobol");
        langagesBis.add("JavaScript");

        langages.addAll(langagesBis);
        Collections.sort(langages);
        System.out.println(langages);
    }
}
