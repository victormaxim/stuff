import java.io.*;

public class Serializare {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		//SerializarePisica p1 = new SerializarePisica("Modjo",11);
		//ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pisica.dat"));
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("pisicaa.dat"));
		//out.writeObject(p1);
		SerializarePisica p2 = (SerializarePisica)in.readObject();
		System.out.println(p2.nume + "" + p2.varsta + " " + p2.numar);
		
		
	

		}
}