package Day_8Objet.Ex01;

public class Voiture extends Vehicule {
    private String nombrePortes;

    public Voiture() {

    }

    public Voiture(String modele,String marque,int anneeFabrication,String nombrePortes) {
        super(modele, marque, anneeFabrication);
        this.nombrePortes = nombrePortes;
    }
    
    public String getNombrePortes() {
        return this.nombrePortes;
    }

    public void setNombrePortes(String nombrePortes) {
        this.nombrePortes = nombrePortes;
    }

    @Override
    public void afficherDetailsVehicule() {
        System.out.println(super.toString() + "\n" + "nombre de porte :" +nombrePortes);
    }
}
