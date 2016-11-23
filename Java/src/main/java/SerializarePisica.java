import java.io.Serializable;

@SuppressWarnings("serial")
public class SerializarePisica implements Serializable{
	
	//private static final long serialVersionUID = 1L;
	String nume;
	int varsta;
	int numar;
	
	public SerializarePisica(String nume, int varsta){
		this.nume = nume;
		this.varsta = varsta;
		this.numar = 123;
		
	}

}
