package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;

import entites.Historique;
import entites.Database;

public class HistoriqueDAO {

    public void save(Historique historique) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO historique (id_admin, date_h, tache) VALUES (?, ?, ?)");
            ps.setInt(1, historique.getId_admin());
            ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            ps.setString(3, historique.getTache());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'enregistrement de l'historique");
        }
    }

    public ArrayList<Historique> getAll() {
        ArrayList<Historique> historiques = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM historique");
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Historique h = new Historique();
                h.setId(resultat.getInt("id"));
                h.setId_admin(resultat.getInt("id_admin"));
                h.setDate_h(resultat.getTimestamp("date_h"));
                h.setTache(resultat.getString("tache"));
                historiques.add(h);
            }
            return historiques;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'historique");
            return null;
        }
    }
}
