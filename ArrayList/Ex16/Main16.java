package Ex16;
import java.util.Collections;
import java.util.ArrayList;

public class Main16 {
    public static void main(String[] args) {
        ArrayList<Integer> col = new ArrayList<>();
        ArrayList<Integer> colBis = new ArrayList<>();
        int i = 0;

        col.add(1);
        col.add(2);
        col.add(3);
        col.add(4);
        col.add(5);
        col.add(6);

        while(i <= col.indexOf(4)) {
            colBis.add(col.get(i));
            i++;
        }
        System.out.println(colBis);
    }
}
