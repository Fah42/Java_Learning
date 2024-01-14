package Ex18;
import java.util.Collections;
import java.util.ArrayList;

public class Main18 {
    public static void main(String[] args) {
        ArrayList<String> col = new ArrayList<>();
        ArrayList<String> colBis = new ArrayList<>();
        ArrayList<Boolean> cBooleans = new ArrayList<>();
        int i = 0;
    
        col.add("PHP");
        col.add("Java");
        col.add("C++");
        col.add("Python");

        colBis.add("PHP");
        colBis.add("Java");
        colBis.add("C");
        colBis.add("Python");

        while(i < col.size()) {
            if (col.get(i).equals(colBis.get(i))) {
                cBooleans.add(true);
            } else {
                cBooleans.add(false);
            }
            i++;
        }
        System.out.println(cBooleans);
    }
}
