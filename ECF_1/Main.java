package ECF_1;

public class Main {
    public static void main(String[] args) {
       
    }

    public static String resultat(Double note1, Double note2, Double note3) {
        if (note1 < 12 || note2 < 12 || note3 < 12) {
            return "Echoué";
        } else {
            return "Réussi";
        }
    }

    public static void multipleDeTrois(int n) {
        System.out.print("Les multiples de 3 entre 1 et " + n + " sont : ");
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void produitElementTab(int[] T) {
        System.out.println(T.length);
        int somme = 1;

      for(int i = 0; i < T.length; i++) {
        somme *= T[i]; 
      }
      System.out.println("Le produit est : " + somme);
    }

    public static void afficheEntiers(int n) {
        for(int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 7 == 0) {
                System.out.print(" M57");
            } else if (i % 7 == 0) {
                System.out.print(" M7");
            } else if (i % 5 == 0) {
                System.out.print(" M5");
            } else {
                System.out.print(" "+ i);
            }
        }
    }
    
    public static void genererMot(char[] tab1, int[] tab2) {
        for (int i = 0; i <= tab1.length - 1; i++ ) {
            for (int j = 0; j < tab2[i]; j++) {
                System.out.print(tab1[i]);
            }
        }
    }

    public static boolean parfait(int j) {
        int somme = 0;

        for (int i = 1; i < j; i++) {
            if (j % i == 0) {
                somme += i;
            }
        }

        return somme == j;
    }

    public static void sommeHarmonique(int n) {
        double somme = 0.0;

        for (int i = 1; i <= n; i++) {
            somme += 1.0 / i;
        }

        System.out.print("La somme des %d premiers termes = " + somme);
    }

    public static int occurrence(int[] tab, int n) {
        int index = -1;
        for (int i = 0; i < tab.length; i++) {
            if (n == tab[i]) {
                index = i;
            }
        }
        return index;
    }
}
