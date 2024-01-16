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

    public boolean setTitre(String titre) {
        if (titre.length() > 50 || titre.length() <= 0 ||titre == null) {
            return false;
        } else {
            this.titre = titre;
            return true;
        }
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titre='" + getTitre() + "'" +
            "}";
    }
    
}
