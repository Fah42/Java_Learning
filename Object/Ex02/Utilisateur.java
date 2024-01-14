package Day_8Objet;

public class Utilisateur {
    private String email;
    private String password;

    public Utilisateur(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public Utilisateur() {
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Utilisateur email(String email) {
        setEmail(email);
        return this;
    }

    public Utilisateur password(String password) {
        setPassword(password);
        return this;
    }
    
    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}
