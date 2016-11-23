package telacad;
import java.util.ArrayList;

public interface SubiectProdus {
ArrayList<ProdusListener> obs = new ArrayList<ProdusListener>();
public void addProdusListener(ProdusListener o);
public void notifica();

	
}
