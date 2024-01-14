package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Database;
import entites.Produits;
import entites.Categories;

public class CategoriesDAO {
    public void save (Categories categorie) {
        try {
            if(categorie.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE categories SET titre = ? WHERE id = ?");
                ps.setString(1, categorie.getTitre());
                ps.setInt(2, categorie.getId());
                ps.executeUpdate();
                System.out.println("Update OK !");
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO categories (titre) VALUES (?)");
                ps.setString(1, categorie.getTitre());
                ps.executeUpdate();
                System.out.println("Insert Ok !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public Categories getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM categories WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            Categories c = new Categories();
            if (resultat.next()) {
                c.setId(resultat.getInt("id"));
                c.setTitre(resultat.getString("titre"));
                return c;
            } return c;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
            return null;
        }
    }

    public ArrayList<Categories> getAll() {
        ArrayList<Categories> categories = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM categories");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Categories c = new Categories();
                c.setId(resultat.getInt("id"));
                c.setTitre(resultat.getString("titre"));
                categories.add(c);
            }
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
            return null;
        }
    }
    
    public void deleteById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM categories WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Categorie Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public ArrayList<Produits> searchProduct(String userSearch) {
        try { 
            ArrayList<Produits> produits = new ArrayList<>();
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM produits WHERE titre LIKE '%?%");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Produits p = new Produits();
                p.setId(resultat.getInt("id"));
                p.setTitre(resultat.getString("titre"));
                produits.add(p);
            }
            return produits;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
            return null;
        }
    }
}
