package entites;

import java.sql.Date;

public class Entree_stock {
    private int id;
    private int id_produit;
    private int id_fournisseur;
    private int quantite;
    private Date dateE;


    public Entree_stock() {
    }

    public Entree_stock(int id_produit, int id_fournisseur, int quantite, Date dateE) {
        this.id_produit = id_produit;
        this.id_fournisseur = id_fournisseur;
        this.quantite = quantite;
        this.dateE = dateE;
    }

    public Entree_stock(int id, int id_produit, int id_fournisseur, int quantite, Date dateE) {
        this.id = id;
        this.id_produit = id_produit;
        this.id_fournisseur = id_fournisseur;
        this.quantite = quantite;
        this.dateE = dateE;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_produit() {
        return this.id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_fournisseur() {
        return this.id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateE() {
        return this.dateE;
    }

    public void setDateE(Date dateE) {
        this.dateE = dateE;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", id_produit='" + getId_produit() + "'" +
            ", id_fournisseur='" + getId_fournisseur() + "'" +
            ", quantite='" + getQuantite() + "'" +
            ", dateE='" + getDateE() + "'" +
            "}";
    }
    
}
