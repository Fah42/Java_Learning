package CRUD_object;

public class Compte {
    static int c;
    private int id;
    private String rib;
    private double solde;
    private int idClient;


    public Compte() {
        c++;
        this.id = c;
    }

    public Compte(String rib, double solde, int idClient) {
        c++;
        this.id = c;
        this.rib = rib;
        this.solde = solde;
        this.idClient = idClient;
    }
    public int getId() {
        return this.id;
    }

    public String getRib() {
        return this.rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public double getSolde() {
        return this.solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getIdClient() {
        return this.idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", rib='" + getRib() + "'" +
            ", solde='" + getSolde() + "'" +
            ", idClient='" + getIdClient() + "'" +
            "}";
    }

    
}
