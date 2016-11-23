package beans;

public class Carte implements java.io.Serializable {

    private String nume;
    private String autor;

    public Carte() {

    }

    public Carte(String nume, String autor) {
        this.nume = nume;
        this.autor = autor;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return nume + " " + autor;
    }

}
