package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entites.Database;
import entites.Produits;

public class ProduitsDAO {
    public void save (Produits produit) {
        try {
            if(produit.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE produits SET titre = ?, prix = ?, qte = ?, categorie_id = ? WHERE id = ?");
                ps.setString(1, produit.getTitre());
                ps.setDouble(2, produit.getPrix());
                ps.setInt(3, produit.getQte());
                ps.setInt(4, produit.getCategorie_id());
                ps.setInt(5, produit.getId());
                ps.executeUpdate();
                System.out.println("Update OK !");
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO produits (titre, prix, qte, categorie_id) VALUES (?,?,?,?)");
                ps.setString(1, produit.getTitre());
                ps.setDouble(2, produit.getPrix());
                ps.setInt(3, produit.getQte());
                ps.setInt(4, produit.getCategorie_id());
                ps.executeUpdate();
                System.out.println("Insert Ok !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public Produits getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM produits WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Produits p = new Produits();
            p.setId(resultat.getInt("id"));
            p.setTitre(resultat.getString("titre"));
            p.setPrix(resultat.getDouble("prix"));
            p.setQte(resultat.getInt("qte"));
            p.setCategorie_id(resultat.getInt("categorie_id"));
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
            return null;
        }
    }

    public ArrayList<Produits> getAll() {
        ArrayList<Produits> produits = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM produits");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Produits p = new Produits();
                p.setId(resultat.getInt("id"));
                p.setTitre(resultat.getString("titre"));
                p.setQte(resultat.getInt("qte"));
                p.setCategorie_id(resultat.getInt("categorie_id"));
                produits.add(p);
            }
            return produits;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
            return null;
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM produits WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("User Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public void deleteByCatId(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM produits WHERE categorie_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("User Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public int nbProductByCat(int idCat) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT COUNT(*) as nombre FROM produits WHERE categorie_id = ?");
            ps.setInt(1, idCat);
            ResultSet resultat = ps.executeQuery();
            resultat.next();
            return resultat.getInt("nombre");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
            return -1;
        }
    }
}
