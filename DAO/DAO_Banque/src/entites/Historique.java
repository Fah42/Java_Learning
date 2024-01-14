package entites;

import java.sql.Timestamp;

public class Historique {

    private int id;
    private int id_admin;
    private Timestamp date_h;
    private String tache;

    public Historique() {
       
    }

    public Historique(int id_admin, Timestamp date_h, String tache) {
        this.id_admin = id_admin;
        this.date_h = date_h;
        this.tache = tache;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public Timestamp getDate_h() {
        return date_h;
    }

    public void setDate_h(Timestamp date_h) {
        this.date_h = date_h;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String tache) {
        this.tache = tache;
    }

    @Override
    public String toString() {
        return "Historique{" +
                "id=" + id +
                ", id_admin=" + id_admin +
                ", date_h=" + date_h +
                ", tache='" + tache + '\'' +
                '}';
    }
}
