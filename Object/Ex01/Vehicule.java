package Day_8Objet.Ex01;

public class Vehicule {
    private String modele;
    private String marque;
    private int anneeFabrication;

    public Vehicule() {

    }

    public Vehicule(String modele, String marque, int anneeFabrication) {
        this.modele = modele;
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
    }

    public String getModele() {
        return this.modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return this.marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getAnneeFabrication() {
        return this.anneeFabrication;
    }

    public void setAnneeFabrication(int anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

    public void afficherDetailsVehicule() {
        System.out.println("modele : " + modele + "\n" + "marque : " + marque + "\n" + "annee de fabrication :" + anneeFabrication);
    }

}
