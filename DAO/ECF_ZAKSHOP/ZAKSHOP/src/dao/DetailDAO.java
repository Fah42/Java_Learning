package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Database;
import entites.Detail;

public class DetailDAO {

    public void save(Detail details) {
        try {
            if(details.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE details SET quantite = ?, prixU = ?, id_commande = ?, id_produit = ? WHERE id = ?");
                ps.setInt(1, details.getQuantite());
                ps.setDouble(2, details.getPrixU());
                ps.setInt(3, details.getId_commande());
                ps.setInt(4, details.getId_produit());
                ps.setInt(5, details.getId());
                ps.executeUpdate();
                System.out.println("Update Ok !");
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO details (quantite, prixU, id_commande, id_produit) VALUES (?,?,?,?)");
                ps.setInt(1, details.getQuantite());
                ps.setDouble(2, details.getPrixU());
                ps.setInt(3, details.getId_commande());
                ps.setInt(4, details.getId_produit());
                ps.executeUpdate();
                System.out.println("Insert Ok !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public Detail getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM details WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Detail u = new Detail();
            u.setId(resultat.getInt("id"));
            u.setQuantite(resultat.getInt("quantite"));
            u.setPrixU(resultat.getDouble("prixU"));
            u.setId_commande(resultat.getInt("id_commande"));
            u.setId_produit(resultat.getInt("id_produit"));
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Detail> getAll() {
        ArrayList<Detail> categories = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM details");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Detail u = new Detail();
                u.setId(resultat.getInt("id"));
                u.setQuantite(resultat.getInt("quantite"));
                u.setPrixU(resultat.getDouble("prixU"));
                u.setId_commande(resultat.getInt("id_commande"));
                u.setId_produit(resultat.getInt("id_produit"));
                categories.add(u);
            }
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
            return null;
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM details WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Detail Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }
}
