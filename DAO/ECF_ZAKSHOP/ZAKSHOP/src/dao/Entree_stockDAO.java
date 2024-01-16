package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Database;
import entites.Entree_stock;

public class Entree_stockDAO {

    public void save(Entree_stock entree_stock) {
        try {
            if(entree_stock.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE entree_stock SET id_produit = ?, id_fournisseur = ?, quantite = ?, dateE = NOW() WHERE id = ?");
                ps.setInt(1, entree_stock.getId_produit());
                ps.setInt(2, entree_stock.getId_fournisseur());
                ps.setInt(3, entree_stock.getQuantite());
                ps.setInt(4, entree_stock.getId());
                ps.executeUpdate();
                System.out.println("Update Ok !");
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO entree_stock (id_produit, id_fournisseur, quantite, dateE) VALUES (?,?,?,NOW())");
                ps.setInt(1, entree_stock.getId_produit());
                ps.setInt(2, entree_stock.getId_fournisseur());
                ps.setInt(3, entree_stock.getQuantite());
                ps.executeUpdate();
                System.out.println("Insert Ok !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public Entree_stock getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM entree_stock WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Entree_stock u = new Entree_stock();
            u.setId(resultat.getInt("id"));
            u.setId_produit(resultat.getInt("id_produit"));
            u.setId_fournisseur(resultat.getInt("id_fournisseur"));
            u.setQuantite(resultat.getInt("quanttite"));
            u.setDateE(resultat.getDate("dateE"));
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Entree_stock> getAll() {
        ArrayList<Entree_stock> categories = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM entree_stock");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Entree_stock u = new Entree_stock();
                u.setId(resultat.getInt("id"));
                u.setId_produit(resultat.getInt("id_produit"));
                u.setId_fournisseur(resultat.getInt("id_fournisseur"));
                u.setDateE(resultat.getDate("dateE"));
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
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM entree_stock WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Entree_stock Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }
}
