package entites;

public class Categorie {
    private int id;
    private String titre;

    public Categorie() {
    }

    public Categorie(String titre) {
        this.titre = titre;
    }

    public Categorie(int id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Categorie id(int id) {
        setId(id);
        return this;
    }

    public Categorie titre(String titre) {
        setTitre(titre);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titre='" + getTitre() + "'" +
            "}";
    }
    
}
