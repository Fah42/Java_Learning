package Day_8Objet.Ex01;

public class Moto extends Vehicule{
    private String typeMoto;

    public Moto() {

    }

    public Moto(String modele, String marque, int anneeFabrication, String typeMoto) {
        super(modele, marque, anneeFabrication);
        this.typeMoto = typeMoto;
    }

    public String getTypeMoto() {
        return this.typeMoto;
    }

    public void setTypeMoto(String typeMoto) {
        this.typeMoto = typeMoto;
    }

    @Override
    public void afficherDetailsVehicule() {
        System.out.println(super.toString() + "\n" + "type de moto :" + typeMoto);
    }
}
