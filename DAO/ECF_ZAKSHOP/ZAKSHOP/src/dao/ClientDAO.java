package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Database;
import entites.Client;

public class ClientDAO {

    public void save(Client client) {
        try {
            if(client.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE client SET nom = ?, ville = ?, age = ?, prenom = ? WHERE id = ?");
                ps.setString(1, client.getNom());
                ps.setString(2, client.getVille());
                ps.setInt(3, client.getAge());
                ps.setString(4, client.getPrenom());
                ps.setInt(5, client.getId());
                ps.executeUpdate();
                System.out.println("Update Ok !");
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO client (nom, ville, age, prenom) VALUES (?,?,?,?)");
                ps.setString(1, client.getNom());
                ps.setString(2, client.getVille());
                ps.setInt(3, client.getAge());
                ps.setString(4, client.getPrenom());
                ps.executeUpdate();
                System.out.println("Insert Ok !");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public Client getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM client WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Client u = new Client();
            u.setId(resultat.getInt("id"));
            u.setPrenom(resultat.getString("prenom"));
            u.setAge(resultat.getInt("age"));
            u.setVille(resultat.getString("ville"));
            u.setNom(resultat.getString("nom"));
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Client> getAll() {
        ArrayList<Client> clients = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM client");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Client u = new Client();
                u.setId(resultat.getInt("id"));
                u.setPrenom(resultat.getString("prenom"));
                u.setAge(resultat.getInt("age"));
                u.setVille(resultat.getString("ville"));
                u.setNom(resultat.getString("nom"));
                clients.add(u);
            }
            return clients;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
            return null;
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM client WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("User Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public ArrayList<Client> searchClients(String searchTerm) {
        ArrayList<Client> clients = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM client WHERE prenom LIKE ? OR nom LIKE ? OR ville LIKE ?");
            ps.setString(1, "%" + searchTerm + "%");
            ps.setString(2, "%" + searchTerm + "%");
            ps.setString(3, "%" + searchTerm + "%");
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Client client = new Client();
                client.setId(resultat.getInt("id"));
                client.setPrenom(resultat.getString("prenom"));
                client.setAge(resultat.getInt("age"));
                client.setVille(resultat.getString("ville"));
                client.setNom(resultat.getString("nom"));
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
