package obspattern;

import java.util.ArrayList;

public interface SubiectCarti {

    ArrayList<CartiListener> obs = new ArrayList<CartiListener>();

    public void addCartiListener(CartiListener cl);

    public void notifica();

}
