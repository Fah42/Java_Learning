package Day_2While_For.For.Ex12;
import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = 1;
        int temp_age = age;
        int result = 0;
        for (int i = 0; i <= age; i++){
            result += 100 + (temp_age*2);
            temp_age++;
        }
        System.out.println(result);
        scanner.close();
    }    
}
