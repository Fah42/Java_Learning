package Cor;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static ArrayList<String> taches=new ArrayList();
    static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        int choix=-1;
        while(choix!=4) {
            choix=todoliste();
            if(choix==1) {
                ajouter();
            }else if(choix==2) {
                supprimer();
            }else if(choix==3) {
                afficher();
            }
        }
    }
    public static void afficher() {
        for(String val:taches) {
            System.out.print(val+" - ");
        }
    }
    public static void ajouter() {
        System.out.println("Donnez une tâche : ");
        String t = clavier.next();
        taches.add(t);
    }
    public static void supprimer() {
        System.out.println("Saisissez la tâche à supprimer : ");
        String s=clavier.nextLine();
        taches.remove(taches.indexOf(s));
    }
    public static int todoliste() {
        System.out.println("---- TODOLIST ----");
        System.out.println("1 - Ajouter une tâche");
        System.out.println("2 - Supprimer une tâche");
        System.out.println("3 - Lister toutes les tâches");
        System.out.println("4 - Quitter");
        System.out.println("Votre choix : ");
        int c=clavier.nextInt();
        return c;
    }

}