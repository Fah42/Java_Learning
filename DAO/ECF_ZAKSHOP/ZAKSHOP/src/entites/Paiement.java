package entites;

import java.sql.Date;

public class Paiement {
    private int id;
    private int id_facture;
    private double montant;
    private Date dateP;

    public Paiement() {
    }

    public Paiement(int id_facture, double montant, Date dateP) {
        this.id_facture = id_facture;
        this.montant = montant;
        this.dateP = dateP;
    }

    public Paiement(int id, int id_facture, double montant, Date dateP) {
        this.id = id;
        this.id_facture = id_facture;
        this.montant = montant;
        this.dateP = dateP;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_facture() {
        return this.id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
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

    public Paiement id_facture(int id_facture) {
        setId_facture(id_facture);
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
            ", id_facture='" + getId_facture() + "'" +
            ", montant='" + getMontant() + "'" +
            ", dateP='" + getDateP() + "'" +
            "}";
    }

    
}
