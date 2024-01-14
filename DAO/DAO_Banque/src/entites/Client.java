package entites;

public class Client {
    private int id;
    private String name;
    private int age;
    private String city;


    public Client() {
    }

    public Client(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Client(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Client id(int id) {
        setId(id);
        return this;
    }

    public Client name(String name) {
        setName(name);
        return this;
    }

    public Client age(int age) {
        setAge(age);
        return this;
    }

    public Client city(String city) {
        setCity(city);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }
    

}
