package entites;

public class Detail {
    private int id;
    private int quantite;
    private double prixU;
    private int id_commande;
    private int id_produit; 

    public Detail() {
    }

    public Detail(int quantite, double prixU, int id_commande, int id_produit) {
        this.quantite = quantite;
        this.prixU = prixU;
        this.id_commande = id_commande;
        this.id_produit = id_produit;
    }

    public Detail(int id, int quantite, double prixU, int id_commande, int id_produit) {
        this.id = id;
        this.quantite = quantite;
        this.prixU = prixU;
        this.id_commande = id_commande;
        this.id_produit = id_produit;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixU() {
        return this.prixU;
    }

    public void setPrixU(double prixU) {
        this.prixU = prixU;
    }

    public int getId_commande() {
        return this.id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_produit() {
        return this.id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public Detail id(int id) {
        setId(id);
        return this;
    }

    public Detail quantite(int quantite) {
        setQuantite(quantite);
        return this;
    }

    public Detail prixU(double prixU) {
        setPrixU(prixU);
        return this;
    }

    public Detail id_commande(int id_commande) {
        setId_commande(id_commande);
        return this;
    }

    public Detail id_produit(int id_produit) {
        setId_produit(id_produit);
        return this;
    }
    
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", quantite='" + getQuantite() + "'" +
            ", prixU='" + getPrixU() + "'" +
            ", id_commande='" + getId_commande() + "'" +
            ", id_produit='" + getId_produit() + "'" +
            "}";
    }
}
