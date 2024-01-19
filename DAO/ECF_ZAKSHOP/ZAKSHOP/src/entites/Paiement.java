package entites;

import java.sql.Date;

public class Paiement {
    private int id;
    private int id_commande;
    private double montant;
    private Date dateP;
    private Commande commande;

    public Paiement() {
    }

    public Paiement(Commande commande, int id_commande, double montant, Date dateP) {
        this.id_commande = id_commande;
        this.montant = montant;
        this.dateP = dateP;
        this.commande = commande;
    }

    public Paiement(Commande commande, int id, int id_commande, double montant, Date dateP) {
        this.id = id;
        this.id_commande = id_commande;
        this.montant = montant;
        this.dateP = dateP;
        this.commande = commande;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_commande() {
        return this.id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public double getMontant() {
        return this.montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateP() {
        return this.dateP;
    }

    public void setDateP(Date date) {
        this.dateP = date;
    }

    public Commande getCommande(Commande commande) {
        return this.commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return getId() + " - [Facture n : " + commande.getId() + "] - [Montant : " + getMontant() + "] - [Date : " + getDateP() + "]";
    }
}
