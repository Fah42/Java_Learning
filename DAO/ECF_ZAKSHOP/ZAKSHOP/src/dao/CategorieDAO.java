package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Database;
import entites.Categorie;

public class CategorieDAO {

    public void save(Categorie categorie) {
        try {
            if(categorie.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE categorie SET titre = ? WHERE id = ?");
                ps.setString(1, categorie.getTitre());
                ps.setInt(5, categorie.getId());
                ps.executeUpdate();
                System.out.println("Update Ok !");
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO categorie (titre) VALUES (?)");
                ps.setString(1, categorie.getTitre());
                ps.executeUpdate();
                System.out.println("Insert Ok !");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public Categorie getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM categorie WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Categorie u = new Categorie();
            u.setId(resultat.getInt("id"));
            u.setTitre(resultat.getString("titre"));
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Categorie> getAll() {
        ArrayList<Categorie> categories = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM categorie");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Categorie u = new Categorie();
                u.setId(resultat.getInt("id"));
                u.setTitre(resultat.getString("titre"));
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
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM categorie WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Categorie Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }
}
