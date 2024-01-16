package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Client;
import entites.Database;
import entites.Fournisseur;

public class FournisseurDAO {

    public void save(Fournisseur fournisseur) {
        try {
            if(fournisseur.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE fournisseur SET nom = ?, ville = ? WHERE id = ?");
                ps.setString(1, fournisseur.getNom());
                ps.setString(2, fournisseur.getVille());
                ps.setInt(3, fournisseur.getId());
                ps.executeUpdate();
                System.out.println("Update Ok !");
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO fournisseur (nom, ville) VALUES (?,?)");
                ps.setString(1, fournisseur.getNom());
                ps.setString(2, fournisseur.getVille());
                ps.executeUpdate();
                System.out.println("Insert Ok !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public Fournisseur getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM fournisseur WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Fournisseur u = new Fournisseur();
            u.setId(resultat.getInt("id"));
            u.setNom(resultat.getString("nom"));
            u.setVille(resultat.getString("ville"));
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Fournisseur> getAll() {
        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM fournisseur");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Fournisseur u = new Fournisseur();
                u.setId(resultat.getInt("id"));
                u.setNom(resultat.getString("nom"));
                u.setVille(resultat.getString("ville"));
                fournisseurs.add(u);
            }
            return fournisseurs;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
            return null;
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM fournisseur WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Fournisseur Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public ArrayList<Fournisseur> searchSupplier(String searchTerm) {
        ArrayList<Fournisseur> clients = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM fournisseur WHERE nom LIKE ? OR vikke LIKE ?");
            ps.setString(1, "%" + searchTerm + "%");
            ps.setString(2, "%" + searchTerm + "%");
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Fournisseur client = new Fournisseur();
                client.setId(resultat.getInt("id"));
                client.setNom(resultat.getString("nom"));
                client.setVille(resultat.getString("ville"));
                clients.add(client);
            }
            return clients;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la recherche de clients");
            return null;
        }
    }
}
