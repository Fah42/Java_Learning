package Day_7Objet.Ex01;
/*etape de creation dune classe :
 * - Attribus
 * - Constructeurs
 * - Getter et Setter
 * - Methodes
 */
public class Personne {
    /*On appel les variable de classe des attribus, ⚠️ utiliser les bons termes */
    /*String = null / Float = 0.0 / Int = 0  / char = ' '*/
    public String prenom;
    public String ville;
    public int age;
    /*Appeler les setter et les getter directement dans le constructeur */
    public Personne(String prenom, String ville, int age) {
        setPrenom(prenom);
        setVille(ville);
        setAge(age);
    }

    public Personne() {
    }

    /*Getter permet de retourner une valeur private*/
    public String getPrenom() {
        return this.prenom;
    }

    /*Setter permet de modifier une valeur private*/
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getAge() {
        return this.age;
    }
    /*
     * exemple d'utilisation de controle de saisi grace au setter
     */
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("L'age est invalide");
        } else {
            this.age = age;
        }
    }
    /*Cette methode qui existe deja en natif java permet d'afficher
    * une String directement en appelant l'objet directement
    */
    public String toString() {
        return "prenom : " + prenom + "\nVille : " + ville + "\nage : " + age;
    }
}
