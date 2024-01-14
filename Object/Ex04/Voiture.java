package Day_7Objet.Ex02;
import java.util.Objects;

    public class Voiture {
        private String marque;
        private int km;
        private int annee;


    public Voiture() {
    }

    public Voiture(String marque, int km, int annee) {
        this.marque = marque;
        this.km = km;
        this.annee = annee;
    }

    public String getMarque() {
        return this.marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getKm() {
        return this.km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getAnnee() {
        return this.annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Voiture marque(String marque) {
        setMarque(marque);
        return this;
    }

    public Voiture km(int km) {
        setKm(km);
        return this;
    }

    public Voiture annee(int annee) {
        setAnnee(annee);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " marque='" + getMarque() + "'" +
            ", km='" + getKm() + "'" +
            ", annee='" + getAnnee() + "'" +
            "}";
    }
}