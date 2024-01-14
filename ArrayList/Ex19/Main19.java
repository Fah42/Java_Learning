package Ex19;
import java.util.Collections;
import java.util.ArrayList;

public class Main19 {
    public static void main(String[] args) {
        ArrayList<String> col = new ArrayList<>();
    
        col.add("PHP");
        col.add("Java");
        col.add("C++");
        col.add("Python");
        Collections.swap(col, 0, 2);

        System.out.println(col);
    } 
}
