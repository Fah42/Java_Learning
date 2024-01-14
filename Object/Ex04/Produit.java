package Day_7Objet.Ex02;

class Produit {
    private String id;
    private String nom;
    private int prix;
    private int quantiteStock;

    public Produit(String id, String nom, int prix, int quantiteStock) {
        setId(id);
        setNom(nom);
        setPrix(prix);
        setQuantiteStock(quantiteStock);
    }

    public Produit() {
        
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getPrix() {
        return this.prix;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
    public int getQuantiteStock() {
        return this.quantiteStock;
    }
    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public String toString() {
        return "id : " + id + "\nnom : " + nom + "\nprix : " + prix + "\nquantite de stock : " + quantiteStock;
    }
}
