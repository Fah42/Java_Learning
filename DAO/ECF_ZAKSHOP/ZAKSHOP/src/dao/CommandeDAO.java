package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import entites.Database;
import entites.Commande;

public class CommandeDAO {

    public int save(Commande commande) {
        try {
            if(commande.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE commande SET dateF = NOW(), id_client = ? WHERE id = ?");
                ps.setInt(1, commande.getId_client());
                ps.setInt(2, commande.getId());
                ps.executeUpdate();
                System.out.println("Update Ok !");
                return commande.getId();
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO commande (dateF, id_client) VALUES (NOW(),?)", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, commande.getId_client());
                ps.executeUpdate();
                ResultSet resultat = ps.getGeneratedKeys();
                resultat.next();
                int newid = resultat.getInt(1);
                return newid;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public Commande getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM commande WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Commande u = new Commande();
            u.setId(resultat.getInt("id"));
            u.setDateF(resultat.getDate("dateF"));
            u.setId_client(resultat.getInt("id_client"));
            return u;
        } catch (Exception e) {
            return null;
        }
    }

    public Commande getByIdClient(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM commande WHERE id_client = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Commande u = new Commande();
            u.setId(resultat.getInt("id"));
            u.setDateF(resultat.getDate("dateF"));
            u.setId_client(resultat.getInt("id_client"));
            return u;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Commande> getAll() {
        ArrayList<Commande> categories = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM commande");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Commande u = new Commande();
                u.setId(resultat.getInt("id"));
                u.setDateF(resultat.getDate("dateF"));
                u.setId_client(resultat.getInt("id_client"));
                categories.add(u);
            }
            return categories;
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM commande WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Commande Deleted");
        } catch (Exception e) {
            return;
        }
    }
}
