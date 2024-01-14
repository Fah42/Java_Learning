package entites;

public class Categories {
    private int id;
    private String titre;

    public Categories() {

    }

    public Categories(int id, String titre) {
        setId(id);
        setTitre(titre);
    }

    public Categories(String titre) {
        setTitre(titre);
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

    @Override
    public String toString() {
        return
            getId() + " - " + getTitre() + " " ;
    }

}
