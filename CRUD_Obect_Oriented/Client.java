package CRUD_object;

public class Client {

    static int c;
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private int age;

    public Client() {
        c++;
        this.id = c;
    }

    public Client(String firstName, String lastName, String city, int age) {
        c++;
        this.id = c;
        setFirstName(firstName);
        setLastName(lastName);
        setCity(city);
        setAge(age);
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", city='" + getCity() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }

    
}
