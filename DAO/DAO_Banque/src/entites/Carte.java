package entites;

public class Carte {
    private int id;
    private String numero;
    private String typeC;
    private int an_exp;
    private int id_compte;

    public Carte() {
    }

    public Carte(String numero, String typeC, int an_exp, int id_compte) {
        this.numero = numero;
        this.typeC = typeC;
        this.an_exp = an_exp;
        this.id_compte = id_compte;
    }
    
    public Carte(int id, String numero, String typeC, int an_exp, int id_compte) {
        this.id = id;
        this.numero = numero;
        this.typeC = typeC;
        this.an_exp = an_exp;
        this.id_compte = id_compte;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTypeC() {
        return this.typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC;
    }

    public int getAn_exp() {
        return this.an_exp;
    }

    public void setAn_exp(int an_exp) {
        this.an_exp = an_exp;
    }

    public int getId_compte() {
        return this.id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public Carte id(int id) {
        setId(id);
        return this;
    }

    public Carte numero(String numero) {
        setNumero(numero);
        return this;
    }

    public Carte typeC(String typeC) {
        setTypeC(typeC);
        return this;
    }

    public Carte an_exp(int an_exp) {
        setAn_exp(an_exp);
        return this;
    }

    public Carte id_compte(int id_compte) {
        setId_compte(id_compte);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", numero='" + getNumero() + "'" +
            ", typeC='" + getTypeC() + "'" +
            ", an_exp='" + getAn_exp() + "'" +
            ", id_compte='" + getId_compte() + "'" +
            "}";
    }
}
