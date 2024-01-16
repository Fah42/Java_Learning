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

    public void setNom(String nom) {
        this.nom = nom;
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
            ", nom='" + getNom() + "'" +
            ", ville='" + getVille() + "'" +
            "}";
    }
    
}
