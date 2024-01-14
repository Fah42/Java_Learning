package Day_8Objet.Ex01;

public class Main {
    public static void main(String[] args) {
        Vehicule v1 = new Vehicule("kaya", "ford", 1915);
        Voiture voiture1 = new Voiture("Kiya", "Ford", 1945, "4");
        Moto m1 = new Moto("Super", "Suzuki", 2020, "wow");

        // voiture1.afficherDetailsVehicule();
        v1.afficherDetailsVehicule();
        // m1.afficherDetailsVehicule();

        // System.out.println(v1.getAnneeFabrication());
        // System.out.println(m1.getAnneeFabrication());
        // System.out.println(voiture1.getAnneeFabrication());
        System.out.println(m1);
    }
}
