package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Admin;
import entites.Database;

public class AdminDAO {
    public void save(Admin admin) {
        try {
            if(admin.getId() != 0) {
                PreparedStatement ps = Database.connexion.prepareStatement("UPDATE admin SET admin_user = ?, admin_password = ?, WHERE id = ?");
                ps.setString(1, admin.getAdmin_user());
                ps.setString(2, admin.getAdmin_password());
                ps.setInt(3, admin.getId());
                ps.executeUpdate();
                System.out.println("Update Ok !");
            } else {
                PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO admin (admin_user, admin_password) VALUES (?,?)");
                ps.setString(1, admin.getAdmin_user());
                ps.setString(2, admin.getAdmin_password());
                ps.executeUpdate();
                System.out.println("Insert Ok !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public Admin getById(int id) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM admin WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Admin u = new Admin();
            u.setId(resultat.getInt("id"));
            u.setAdmin_user(resultat.getString("admin_user"));
            u.setAdmin_password(resultat.getString("admin_password"));
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Admin logIntoAdmin(String admin_user, String admin_password) {
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM admin WHERE admin_user = ? AND admin_password = ?");
            ps.setString(1, admin_user);
            ps.setString(2, admin_password);

            ResultSet resultat = ps.executeQuery();
            resultat.next();

            Admin u = new Admin();
            u.setId(resultat.getInt("id"));
            u.setAdmin_user(resultat.getString("admin_user"));
            u.setAdmin_password(resultat.getString("admin_password"));
            return u;
        } catch (Exception e) {
            System.out.println("ERROR");
            return null;
        }
    }

    public ArrayList<Admin> getAll() {
        ArrayList<Admin> clients = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM admin");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()) {
                Admin u = new Admin();
                u.setId(resultat.getInt("id"));
                u.setAdmin_user(resultat.getString("admin_user"));
                u.setAdmin_password(resultat.getString("admin_password"));
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
            PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM admin WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Admin Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }
}
