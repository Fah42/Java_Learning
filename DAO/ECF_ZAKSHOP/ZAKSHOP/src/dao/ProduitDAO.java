package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Database;
import entites.Produit;

public class ProduitDAO {
    private CategorieDAO categorieDAO = new CategorieDAO();
    public void save(Produit produit) {
        try {
            if(produit.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE produit SET titre = ?, prix = ?, id_categorie = ?, stock = ? WHERE id = ?");
                ps.setString(1, produit.getTitre());
                ps.setDouble(2, produit.getPrix());
                ps.setInt(3, produit.getId_categorie());
                ps.setInt(4, produit.getStock());
                ps.setInt(5, produit.getId());
                ps.executeUpdate();
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO produit (titre, prix, id_categorie, stock) VALUES (?,?,?,?)");
                ps.setString(1, produit.getTitre());
                ps.setDouble(2, produit.getPrix());
                ps.setInt(3, produit.getId_categorie());
                ps.setInt(4, produit.getStock());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            return;
        }
    }

    public Produit getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM produit WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Produit u = new Produit();
            u.setId(resultat.getInt("id"));
            u.setTitre(resultat.getString("titre"));
            u.setPrix(resultat.getDouble("prix"));
            u.setId_categorie(resultat.getInt("id_categorie"));
            u.setStock(resultat.getInt("stock"));
            u.setCategorie(categorieDAO.getById(resultat.getInt("id_categorie")));
            return u;
        } catch (Exception e) {
            return null;
        }
    }

    public Produit getByIdCategorie(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM produit WHERE id_categorie = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Produit u = new Produit();
            u.setId(resultat.getInt("id"));
            u.setTitre(resultat.getString("titre"));
            u.setPrix(resultat.getDouble("prix"));
            u.setId_categorie(resultat.getInt("id_categorie"));
            u.setStock(resultat.getInt("stock"));
            return u;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Produit> getAll() {
        ArrayList<Produit> produits = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM produit");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Produit u = new Produit();
                u.setId(resultat.getInt("id"));
                u.setTitre(resultat.getString("titre"));
                u.setPrix(resultat.getDouble("prix"));
                u.setId_categorie(resultat.getInt("id_categorie"));
                u.setStock(resultat.getInt("stock"));
                produits.add(u);
            }
            return produits;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM produit WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            return;
        }
    }

    public void deleteByIdCategorie(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM produit WHERE id_categorie = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            return;
        }
    }

    public ArrayList<Produit> searchProducts(String searchTerm) {
        ArrayList<Produit> produits = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM produit WHERE titre LIKE ? OR prix LIKE ? OR stock LIKE ?");
            ps.setString(1, "%" + searchTerm + "%");
            ps.setString(2, "%" + searchTerm + "%");
            ps.setString(3, "%" + searchTerm + "%");
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Produit p = new Produit();
                p.setId(resultat.getInt("id"));
                p.setTitre(resultat.getString("titre"));
                p.setPrix(resultat.getDouble("prix"));
                p.setId_categorie(resultat.getInt("id_categorie"));
                p.setStock(resultat.getInt("stock"));
                p.setCategorie(categorieDAO.getById(resultat.getInt("id_categorie")));
                produits.add(p);
            }
            return produits;
        } catch (Exception e) {
            return null;
        }
    }

    public int countProductByIdCategorie(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT COUNT(*) as total FROM produit WHERE id_categorie = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();
            return resultat.getInt(1);
        } catch (Exception e) {
            return 0;
        }
    }
    
}
