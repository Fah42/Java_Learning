package Day_8Objet;

public class Main {
    public static void main(String[] args) {
        Utilisateur u = new Utilisateur("test@test", "123");
        Admin ad = new Admin("aas@as", "1443", "root");

        System.out.println(ad);
        System.out.println(u);
    }
}
