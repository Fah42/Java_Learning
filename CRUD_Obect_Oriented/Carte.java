package CRUD_object;

public class Carte {
    
    static int c;
    private int id;
    private String num;
    private int aexp;
    private int idCompte;


    public Carte() {
        c++;
        this.id = c;
    }

    public Carte(String num, int aexp, int idCompte) {
        c++;
        this.id = c;
        this.num = num;
        this.aexp = aexp;
        this.idCompte = idCompte;
    }

    public int getId() {
        return this.id;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getAexp() {
        return this.aexp;
    }

    public void setAexp(int aexp) {
        this.aexp = aexp;
    }

    public int getIdCompte() {
        return this.idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", num='" + getNum() + "'" +
            ", aexp='" + getAexp() + "'" +
            ", idCompte='" + getIdCompte() + "'" +
            "}";
    }
    
}
