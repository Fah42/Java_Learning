package entites;

import java.sql.Timestamp;

public class Commande {
    private int id;
    private Timestamp dateF;
    private int id_client;

    public Commande() {
    }

    public Commande(Timestamp dateF, int id_client) {
        this.dateF = dateF;
        this.id_client = id_client;
    }

    public Commande(int id, Timestamp dateF, int id_client) {
        this.id = id;
        this.dateF = dateF;
        this.id_client = id_client;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateF() {
        return this.dateF;
    }

    public void setDateF(Timestamp dateF) {
        this.dateF = dateF;
    }

    public int getId_client() {
        return this.id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Commande id(int id) {
        setId(id);
        return this;
    }

    public Commande dateF(Timestamp dateF) {
        setDateF(dateF);
        return this;
    }

    public Commande id_client(int id_client) {
        setId_client(id_client);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", dateF='" + getDateF() + "'" +
            ", id_client='" + getId_client() + "'" +
            "}";
    }
}