package entites;

public class Produit {
    private int id;
    private String titre;
    private double prix;
    private int id_categorie;
    private int stock;
    private Categorie categorie;

    public Produit() {
    }

    public Produit(String titre, double prix, Categorie categorie,int id_categorie, int stock) {
        this.titre = titre;
        this.prix = prix;
        this.id_categorie = id_categorie;
        this.stock = stock;
        this.categorie = categorie;
    }

    public Produit(int id, String titre, double prix, Categorie categorie, int id_categorie, int stock) {
        this.id = id;
        this.titre = titre;
        this.prix = prix;
        this.id_categorie = id_categorie;
        this.stock = stock;
        this.categorie = categorie;
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

    public double getPrix() {
        return this.prix;
    }

    public boolean setPrix(double prix) {
        if (prix < 0) {
            return false;
        } else {
            this.prix = prix;
            return true;
        }
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
    
    public Categorie getCategorie(Categorie categorie) {
        return this.categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return getId() + " - [Titre : " + getTitre() + "] - [Prix : " + getPrix() + "] - [Categorie : " + categorie.getTitre() + "] - [Stock : " + getStock() + "]";
    }
}
