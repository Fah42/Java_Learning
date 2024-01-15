package entites;

public class Produit {
    private int id;
    private String titre;
    private double prix;
    private int id_categorie;
    private int stock;

    public Produit() {
    }

    public Produit(String titre, double prix, int id_categorie, int stock) {
        this.titre = titre;
        this.prix = prix;
        this.id_categorie = id_categorie;
        this.stock = stock;
    }

    public Produit(int id, String titre, double prix, int id_categorie, int stock) {
        this.id = id;
        this.titre = titre;
        this.prix = prix;
        this.id_categorie = id_categorie;
        this.stock = stock;
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

    public int getId_categorie() {
        return this.id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Produit id(int id) {
        setId(id);
        return this;
    }

    public Produit titre(String titre) {
        setTitre(titre);
        return this;
    }

    public Produit prix(double prix) {
        setPrix(prix);
        return this;
    }

    public Produit id_categorie(int id_categorie) {
        setId_categorie(id_categorie);
        return this;
    }

    public Produit stock(int stock) {
        setStock(stock);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titre='" + getTitre() + "'" +
            ", prix='" + getPrix() + "'" +
            ", id_categorie='" + getId_categorie() + "'" +
            ", stock='" + getStock() + "'" +
            "}";
    }
    
}
