package entites;

public class Compte {
    private int id;
    private  String rib;
    private double solde;
    private int id_client;

    public Compte() {
    }
    
    public Compte(String rib, double solde, int id_client) {
        this.rib = rib;
        this.solde = solde;
        this.id_client = id_client;
    }
    
    public Compte(int id, String rib, double solde, int id_client) {
        this.id = id;
        this.rib = rib;
        this.solde = solde;
        this.id_client = id_client;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId_client() {
        return this.id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Compte id(int id) {
        setId(id);
        return this;
    }

    public Compte rib(String rib) {
        setRib(rib);
        return this;
    }

    public Compte solde(double solde) {
        setSolde(solde);
        return this;
    }

    public Compte id_client(int id_client) {
        setId_client(id_client);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", rib='" + getRib() + "'" +
            ", solde='" + getSolde() + "'" +
            ", id_client='" + getId_client() + "'" +
            "}";
    }
}