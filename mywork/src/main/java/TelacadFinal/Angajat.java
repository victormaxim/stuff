import java.util.Observable;
public class Angajat extends Observable
{
    String nume, prenume, cnp;

    public Angajat(String nume, String prenume, String cnp)
    {
        this.nume= nume;
        this.prenume=prenume;
        this.cnp = cnp;

    }

    public String toString(){
        return nume + " " + prenume + " " + cnp;
        
    }

    

    
}
