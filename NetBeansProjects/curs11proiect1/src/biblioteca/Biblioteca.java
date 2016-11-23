package biblioteca;

import beans.Carte;
import java.util.ArrayList;
import obspattern.CartiListener;
import obspattern.SubiectCarti;

public class Biblioteca implements SubiectCarti {

    private ArrayList<Carte> carti = new ArrayList<Carte>();
    private static Biblioteca biblioteca = null;

    private Biblioteca() {
    }

    public static Biblioteca getInstance() {
        if (Biblioteca.biblioteca == null) {
            biblioteca = new Biblioteca();
        }
        return Biblioteca.biblioteca;
    }

    public void addCarte(Carte carte) {
        carti.add(carte);
        notifica();
    }

    public ArrayList<Carte> getCarti() {
        return carti;
    }

    @Override
    public void addCartiListener(CartiListener cl) {
        obs.add(cl);
    }

    @Override
    public void notifica() {
        for (CartiListener cl : obs) {
            cl.carteModificata();
        }
    }

}
