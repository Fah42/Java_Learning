package Ex17;
import java.util.Collections;
import java.util.ArrayList;

public class Main17 {
    static int test = 9;
    public static void main(String[] args) {
        ArrayList<Integer> col = new ArrayList<>();
        ArrayList<Integer> colBis = new ArrayList<>();
        col.add(1);
        col.add(2);
        col.add(3);
        col.add(4);
        col.add(5);
        col.add(6);
        col.add(7);
        
        test = 8;
        test();
    }
    public static void test() {
        System.out.println(test);
    }

}   
