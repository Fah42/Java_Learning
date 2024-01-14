package Ex09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
9-	Écrivez un programme Java qui demande à l'utilisateur 6 entiers, 
les ajoutes dans une collection, Ensuite il demande à l'utilisateur un nombre à remplacer
et la nouvelle valeur et affiche la nouvelle collection. (Sans utiliser la fonction replaceAll)
NB : Supposons que l'utilisateur ne va pas entrer le même nombre deux fois .
Exemple : 
Donnez un nbr : 18
Donnez un nbr :25
Donnez un nbr :9
Donnez un nbr :19
Donnez un nbr :38
Donnez un nbr :15
Donnez le nbr à remplacer : 18
Donnez la nouvelle valeur : 100
Sortie prévue : 
Nouvelle collection : [100,25,9,100,38,15]
 */
public class Main09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> col = new ArrayList<>();
        int i = 0;
        int nb, newValue, oldValue, indexOldValue;

        while(i < 6) {
            System.out.println("Veuillez entrer une valeur");
            nb = scanner.nextInt();
            col.add(nb);
            i++;
        }

        System.out.println("Donnez le nbr à remplacer : ");
        oldValue = scanner.nextInt();

        System.out.println("Donnez la nouvelle valeur : ");
        newValue = scanner.nextInt();

        indexOldValue = col.indexOf(oldValue);
        col.set(indexOldValue, newValue);
        System.out.println(col);
        scanner.close();
    }
}
