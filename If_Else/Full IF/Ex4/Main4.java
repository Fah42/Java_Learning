package Ex4;

import java.util.Scanner;

/*
4-    Ecrire un programme qui lit le prix HT d’un article, le nombre d’articles
      et le taux de TVA (ex :20), et qui fournit le prix total TTC correspondant
 */
public class Main4 {
    public static void main4(String[] args){
        Scanner stdout = new Scanner(System.in);

        double prix;
        double nb_articles;
        double tauxTva;
        double result;

        System.out.println("Donnez le prix de l'article : ");
        prix = stdout.nextInt();

        System.out.println("Donnez le nombre d'article : ");
        nb_articles = stdout.nextInt();

        System.out.println("Donnez le taux de la TVA : ");
        tauxTva = stdout.nextInt();

        tauxTva = (tauxTva / 100) + 1;
        result = (prix * nb_articles);
        System.out.println(tauxTva * result);
        stdout.close();
    }
}
