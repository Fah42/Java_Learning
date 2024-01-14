package entites;

public class Produits {
    private int id;
    private String titre;
    private double prix;
    private int qte;
    private int categorie_id;

    public Produits() {

    }

    public Produits(int id, String titre, double prix, int qte, int categorie_id) {
        setId(id);
        setTitre(titre);
        setPrix(prix);
        setQte(qte);
        setCategorie_id(categorie_id);
    }

    public Produits(String titre, double prix, int qte, int categorie_id) {
        setTitre(titre);
        setPrix(prix);
        setQte(qte);
        setCategorie_id(categorie_id);
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

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQte() {
        return this.qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getCategorie_id() {
        return this.categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public Produits id(int id) {
        setId(id);
        return this;
    }

    public Produits titre(String titre) {
        setTitre(titre);
        return this;
    }

    public Produits prix(double prix) {
        setPrix(prix);
        return this;
    }

    public Produits qte(int qte) {
        setQte(qte);
        return this;
    }

    public Produits categorie_id(int categorie_id) {
        setCategorie_id(categorie_id);
        return this;
    }

    @Override
    public String toString() {
        return "id : " + getId() + " - " +
            "titre : " + getTitre() + " - " +
            "prix : " + getPrix() + " - " +
            "qte : " + getQte();
    }
    
}
