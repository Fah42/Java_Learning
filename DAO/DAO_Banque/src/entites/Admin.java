package entites;

public class Admin {
    private int id;
    private String admin_user;
    private String admin_password;

    public Admin() {
    }

    public Admin(int id, String admin_user, String admin_password) {
        this.id = id;
        this.admin_user = admin_user;
        this.admin_password = admin_password;
    }

    public Admin(String admin_user, String admin_password) {
        this.admin_user = admin_user;
        this.admin_password = admin_password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin_user() {
        return this.admin_user;
    }

    public void setAdmin_user(String admin_user) {
        this.admin_user = admin_user;
    }

    public String getAdmin_password() {
        return this.admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public Admin id(int id) {
        setId(id);
        return this;
    }

    public Admin admin_user(String admin_user) {
        setAdmin_user(admin_user);
        return this;
    }

    public Admin admin_password(String admin_password) {
        setAdmin_password(admin_password);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", admin_user='" + getAdmin_user() + "'" +
            ", admin_password='" + getAdmin_password() + "'" +
            "}";
    }
}
