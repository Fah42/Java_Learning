package entites;

import java.sql.Date;

public class Paiement {
    private int id;
    private int id_commande;
    private double montant;
    private Date dateP;

    public Paiement() {
    }

    public Paiement(int id_commande, double montant, Date dateP) {
        this.id_commande = id_commande;
        this.montant = montant;
        this.dateP = dateP;
    }

    public Paiement(int id, int id_commande, double montant, Date dateP) {
        this.id = id;
        this.id_commande = id_commande;
        this.montant = montant;
        this.dateP = dateP;
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

    public void setDateP(Date dateP) {
        this.dateP = dateP;
    }

    public Paiement id(int id) {
        setId(id);
        return this;
    }

    public Paiement id_commande(int id_commande) {
        setId_commande(id_commande);
        return this;
    }

    public Paiement montant(double montant) {
        setMontant(montant);
        return this;
    }

    public Paiement dateP(Date dateP) {
        setDateP(dateP);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", id_commande='" + getId_commande() + "'" +
            ", montant='" + getMontant() + "'" +
            ", dateP='" + getDateP() + "'" +
            "}";
    }

    
}
