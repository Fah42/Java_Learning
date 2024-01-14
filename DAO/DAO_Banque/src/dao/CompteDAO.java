package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Compte;
import entites.Database;

public class CompteDAO {
 public void save(Compte compte) {
        try {
            if(compte.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE compte SET nb = ?, solde = ?, id_client = ? WHERE id = ?");
                ps.setString(1, compte.getRib());
                ps.setDouble(2, compte.getSolde());
                ps.setInt(3, compte.getId_client());
                ps.setInt(4, compte.getId());
                ps.executeUpdate();
                System.out.println("Update Ok !");
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO compte (nb, solde, id_client) VALUES (?,?,?)");
                ps.setString(1, compte.getRib());
                ps.setDouble(2, compte.getSolde());
                ps.setInt(3, compte.getId_client());
                ps.executeUpdate();
                System.out.println("Insert Ok !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public Compte getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM compte WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Compte u = new Compte();
            u.setId(resultat.getInt("id"));
            u.setRib(resultat.getString("nb"));
            u.setSolde(resultat.getInt("solde"));
            u.setId_client(resultat.getInt("id_client"));
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Compte getByIdClient(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM compte WHERE id_client = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Compte u = new Compte();
            u.setId(resultat.getInt("id"));
            u.setRib(resultat.getString("nb"));
            u.setSolde(resultat.getInt("solde"));
            u.setId_client(resultat.getInt("id_client"));
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Compte> getAll() {
        ArrayList<Compte> comptes = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM compte");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Compte u = new Compte();
                u.setId(resultat.getInt("id"));
                u.setRib(resultat.getString("nb"));
                u.setSolde(resultat.getInt("solde"));
                u.setId_client(resultat.getInt("id_client"));
                comptes.add(u);
            }
            return comptes;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
            return null;
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement psDeleteCarte = Database.connexion.prepareStatement("DELETE FROM carte WHERE id_compte IN (SELECT id FROM compte WHERE id = ?)");
            psDeleteCarte.setInt(1, id);
            psDeleteCarte.executeUpdate();
            
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM compte WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Compte Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public void deleteAccountByIdClient(int id) {
        try {
            // Delete from the carte table first
            PreparedStatement psDeleteCarte = Database.connexion.prepareStatement("DELETE FROM carte WHERE id_compte IN (SELECT id FROM compte WHERE id_client = ?)");
            psDeleteCarte.setInt(1, id);
            psDeleteCarte.executeUpdate();
    
            // Then delete from the compte table
            PreparedStatement psDeleteCompte = Database.connexion.prepareStatement("DELETE FROM compte WHERE id_client = ?");
            psDeleteCompte.setInt(1, id);
            psDeleteCompte.executeUpdate();
    
            System.out.println("Compte Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }
}
