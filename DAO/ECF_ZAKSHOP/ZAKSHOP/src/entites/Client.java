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

    public boolean setNom(String nom) {
        if (nom.length() > 40 || nom.length() <= 0 ||nom == null){
            return false;
        } else {
            this.nom = nom;
            return true;
        }
    }

    public String getVille() {
        return this.ville;
    }

    public boolean setVille(String ville) {
        if (ville.length() > 40 || ville.length() <= 0 ||ville == null) {
            return false;
        } else {
            this.ville = ville;
            return true;
        }
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

    public boolean setPrenom(String prenom) {
        if (prenom.length() > 50 || prenom.length() <= 0 ||prenom == null) {
            return false;
        } else {
        this.prenom = prenom;
        return true;
        }
    }

    @Override
    public String toString() {
        return 
            "id = " + getId() + 
            "\nnom = " + getNom() +
            "\nprenom = " + getPrenom() + 
            "\nage = " + getAge() +
            "\nville = " + getVille() + "\n-----------------------------";
    }
     
}
