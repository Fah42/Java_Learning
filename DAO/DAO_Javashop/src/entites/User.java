package entites;

public class User {
    private int id;
    private String username;
    private String password;

    public User() {

    }

    public User(int id, String username, String password) {
        setId(id);
        setUsername(username);
        setPassword(password);
    }

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

}
