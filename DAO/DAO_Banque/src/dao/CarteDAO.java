package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Carte;
import entites.Database;

public class CarteDAO {
 public void save(Carte carte) {
        try {
            if(carte.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE carte SET numero = ?, typec = ?, an_exp = ?, id_compte = ? WHERE id = ?");
                ps.setString(1, carte.getNumero());
                ps.setString(2, carte.getTypeC());
                ps.setInt(3, carte.getAn_exp());
                ps.setInt(4, carte.getId_compte());
                ps.setInt(5, carte.getId());
                ps.executeUpdate();
                System.out.println("Update Ok !");
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO carte (numero, typec, an_exp, id_compte) VALUES (?,?,?,?)");
                ps.setString(1, carte.getNumero());
                ps.setString(2, carte.getTypeC());
                ps.setInt(3, carte.getAn_exp());
                ps.setInt(4, carte.getId_compte());
                ps.executeUpdate();
                System.out.println("Insert Ok !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public Carte getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM carte WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Carte u = new Carte();
            u.setId(resultat.getInt("id"));
            u.setNumero(resultat.getString("numero"));
            u.setTypeC(resultat.getString("typec"));
            u.setAn_exp(resultat.getInt("an_exp"));
            u.setId_compte(resultat.getInt("id_compte"));
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Carte> getAll() {
        ArrayList<Carte> cartes = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM carte");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Carte u = new Carte();
                u.setId(resultat.getInt("id"));
                u.setNumero(resultat.getString("numero"));
                u.setTypeC(resultat.getString("typec"));
                u.setAn_exp(resultat.getInt("an_exp"));
                u.setId_compte(resultat.getInt("id_compte"));
                cartes.add(u);
            }
            return cartes;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
            return null;
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM carte WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Carte Supprime");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public void deleteCardByIdCompte(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM carte WHERE id_compte = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Carte Supprime");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }
}
