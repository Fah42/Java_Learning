package Day_2While_For.For.Ex11;
import java.util.Scanner;

public class Main11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nb_article;
        int y = 0;
        int total = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Veuillez entrer le prix de votre articles");
            nb_article = scanner.nextInt();
            if (nb_article < 30) {
                y++;
                total += nb_article;
            }
        }
        System.out.println(y);
        System.out.println(total);
    }
}
