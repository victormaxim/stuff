package BibliotecaTelacadPartial;

public class Carte implements java.io.Serializable
{
    public String tip;
    private String titlu;
    private String autor;
    private int nr;

    public Carte(String tip, String titlu,String autor,int nr)
    {
        this.tip=tip;
        this.titlu=titlu;
        this.autor=autor;
        this.nr=nr;
    }

    public String getTip()
    {return tip;}

    public String getTitlu()
    {return titlu;}

    public String getAutor()
    {return autor;}

    public int getNr()
    {return nr;}

}
