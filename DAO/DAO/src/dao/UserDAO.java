package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Database;
import entites.User;

public class UserDAO {
	
	public void save(User user) {
		try {
			if(user.getId()!=0) {
				PreparedStatement ps = Database.connexion.prepareStatement("UPDATE users SET username=?,password=? WHERE id=?");
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setInt(3, user.getId());
				ps.executeUpdate();
				System.out.println("UPDATE OK");
			}else {
				PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO users (username,password) VALUES(?,?)");
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.executeUpdate();
				System.out.println("INSERT OK");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}
	}
	
	public User getById(int id) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM users WHERE id=?");
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			resultat.next();
			User u = new User();
			u.setId(resultat.getInt("id"));
			u.setUsername(resultat.getString("username"));
			u.setPassword(resultat.getString("password"));
			return u;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<User> getAll(){
		ArrayList<User> users = new ArrayList<>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM users");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				User u = new User();
				u.setId(resultat.getInt("id"));
				u.setUsername(resultat.getString("username"));
				u.setPassword(resultat.getString("password"));
				users.add(u);
			}
			return users;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public void deleteById(int id) {
		try {
				PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM users WHERE id=?");
				ps.setInt(1, id);
				ps.executeUpdate();
				System.out.println("DELETED OK");
				
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
	
}
