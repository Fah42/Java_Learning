package Day_2While_For.For.Ex14;
import java.util.Scanner;
public class Main14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nb;
    
        System.out.println("Veuillez entrer un nombre : ");
        nb = scanner.nextInt();
        for(int i = 0; i < nb; i++){
            for(int y = 0; y < nb; y++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
