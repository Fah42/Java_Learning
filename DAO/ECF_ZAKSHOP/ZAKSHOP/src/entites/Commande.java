package entites;

import java.sql.Date;

public class Commande {
    private int id;
    private Date dateF;
    private int id_client;

    public Commande() {
    }

    public Commande(Date dateF, int id_client) {
        this.dateF = dateF;
        this.id_client = id_client;
    }

    public Commande(int id, Date dateF, int id_client) {
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

    public Date getDateF() {
        return this.dateF;
    }

    public void setDateF(Date dateF) {
        this.dateF = dateF;
    }

    public int getId_client() {
        return this.id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return getId() + " - [date :" + getDateF() + "] - [id_client :" + getId_client() + "]";
    }
}