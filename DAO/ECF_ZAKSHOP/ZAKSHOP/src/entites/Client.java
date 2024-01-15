package entites;

public class Client {
    private int id;
    private String nom;
    private String ville;
    private int age;
    private String prenom;

    public Client() {
    }

    public Client(String nom, String ville, int age, String prenom) {
        this.nom = nom;
        this.ville = ville;
        this.age = age;
        this.prenom = prenom;
    }

    public Client(int id, String nom, String ville, int age, String prenom) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
        this.age = age;
        this.prenom = prenom;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Client id(int id) {
        setId(id);
        return this;
    }

    public Client nom(String nom) {
        setNom(nom);
        return this;
    }

    public Client ville(String ville) {
        setVille(ville);
        return this;
    }

    public Client age(int age) {
        setAge(age);
        return this;
    }

    public Client prenom(String prenom) {
        setPrenom(prenom);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", ville='" + getVille() + "'" +
            ", age='" + getAge() + "'" +
            ", prenom='" + getPrenom() + "'" +
            "}";
    }
     
}
