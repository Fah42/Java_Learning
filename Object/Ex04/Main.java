package Day_7Objet.Ex02;

public class Main {
    public static void main(String[] args) {
        Produit product1 = new Produit();
        product1.setId("1");
        product1.setNom("Ps5");
        product1.setPrix(400);
        product1.setQuantiteStock(300);
        System.out.println(product1);

        product1.setId("2");
        System.out.println(product1);
    }
}
