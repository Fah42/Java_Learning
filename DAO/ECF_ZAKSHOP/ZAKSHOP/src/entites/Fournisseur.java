package entites;

public class Fournisseur {
    private int id;
    private String nom;
    private String ville;


    public Fournisseur() {
    }

    public Fournisseur(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
    }

    public Fournisseur(int id, String nom, String ville) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
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
        if (nom.length() > 50 || nom.length() <= 0 ||nom == null) {
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
        if (ville.length() > 50 || ville.length() <= 0 ||ville == null) {
            return false;
        } else {
            this.ville = ville;
            return true;
        }
    }
    
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", ville='" + getVille() + "'" +
            "}";
    }
    
}
