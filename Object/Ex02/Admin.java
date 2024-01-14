package Day_8Objet;
/* le passage de utilisateur vers administrateur c'est la specialisation l'inverse s'apelle la generalisation */
public class Admin extends Utilisateur {
    private String privileges;

    public Admin() {

    }

    public Admin(String email, String password, String privileges) {
        super(email, password);
        setPrivileges(privileges);
    }


    public String getPrivileges() {
        return this.privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    /*
     * Il existe 2 type de polymorphisme static et dynamique 
     * - Le polymorphisme Static on appel ca la surcharge, c'est le fait de redeclarer une methode dans la meme classe qui a le meme nom mais pas la meme signature. 
     * - Le polymorphisme Dynamique on appel ca l'Override, c'est le fait de redeclarer une methode d'une classe differente qui a le meme nom et la meme signature (Uniquement lorsqu'on a un extend).
    */
    @Override
    public String toString() {
        return super.toString() + "{" +
            " privileges='" + getPrivileges() + "'" +
            "}";
    }
}
