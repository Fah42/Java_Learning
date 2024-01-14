package CRUD;
/* creer une classe client est caracterise par son ID(int), le nom (en String), le prenom (String), la ville (String)
l'age (int) et l'adresse email (String)
gerer l'incrementation automatique de l'ID.

Dans le main il faut creer 7 methodes, methode main, methode menu, methode lister client,  Ajouter un client,
Supprimer un client, Rechercher un client, Modifier un client, Quitter.

recherche doit afficher par exemple avec PA, tout les clients qui contiennent PA, ou ville.
*/
public class Client {
    static int c;
    private int id;
    private int age;
    private String nom;
    private String prenom;
    private String ville;


    public Client() {
        c++;
        this.id = c;
    }

    public Client(int age, String nom, String prenom, String ville) {
        c++;
        this.id = c;
        setAge(age);
        setNom(nom);
        setPrenom(prenom);
        setVille(ville);
    }
    

    public int getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", age='" + getAge() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", ville='" + getVille() + "'" +
            "}";
    }
}
