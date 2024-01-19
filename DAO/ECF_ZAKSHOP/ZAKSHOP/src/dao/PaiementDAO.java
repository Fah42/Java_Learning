package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entites.Database;
import entites.Paiement;

public class PaiementDAO {

    public void save(Paiement paiement) {
        try {
            if(paiement.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE paiement SET id_facture = ?, montant = ?, dateP = ? WHERE id = ?");
                ps.setInt(1, paiement.getId_commande());
                ps.setDouble(2, paiement.getMontant());
                ps.setDate(3, paiement.getDateP());
                ps.setInt(4, paiement.getId());
                ps.executeUpdate();
                System.out.println("Update Ok !");
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO paiement (id_facture, montant, dateP) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, paiement.getId_commande());
                ps.setDouble(2, paiement.getMontant());
                ps.setDate(3, paiement.getDateP());
                ps.executeUpdate();
                System.out.println("Insert Ok !");
            }
        } catch (Exception e) {
            e.getStackTrace();
            return;
        }
    }

    public Paiement getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM paiement WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Paiement u = new Paiement();
            u.setId(resultat.getInt("id"));
            u.setId_commande(resultat.getInt("id_facture"));
            u.setMontant(resultat.getDouble("montant"));
            u.setDateP(resultat.getDate("dateP")); // Fix: Changed toLocalDate() to setDateP() method
            return u;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Paiement> getAll() {
        ArrayList<Paiement> categories = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM paiement");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Paiement u = new Paiement();
                u.setId(resultat.getInt("id"));
                u.setId_commande(resultat.getInt("id_facture"));
                u.setMontant(resultat.getDouble("montant"));
                u.setDateP(resultat.getDate("dateP")); // Fix: Changed toLocalDate() to setDateP() method
                categories.add(u);
            }
            return categories;
        } catch (Exception e) {
            return null;
        }
    }

    public Paiement getByIdCommande(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM paiement WHERE id_facture = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Paiement u = new Paiement();
            u.setId(resultat.getInt("id"));
            u.setId_commande(resultat.getInt("id_facture"));
            u.setMontant(resultat.getDouble("montant"));
            u.setDateP(resultat.getDate("dateP"));
            return u;
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM paiement WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Paiement Deleted");
        } catch (Exception e) {
            return;
        }
    }

    public void deleteByIdCommande(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM paiement WHERE id_commande = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Paiement Deleted");
        } catch (Exception e) {
            return;
        }
    }
}

