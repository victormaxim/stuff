package beans;

public class User implements java.io.Serializable {

    private String user, parola;

    public User() {
    }

    public User(String user, String parola) {
        this.user = user;
        this.parola = parola;
    }

    public String getNume() {
        return user;
    }

    public void setNume(String user) {
        this.user = user;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

}
