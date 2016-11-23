package BibliotecaTelacadPartial;

import java.io.*;

public class BookApp
{
    static Biblioteca biblio = new Biblioteca();
    static BufferedReader cons;
    static ObjectOutputStream out;
    static ObjectInputStream in;

    public BookApp()
    {

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{

        cons = new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while(true){
            System.out.println("Comenzi biblioteca: \n AC <tip> <titlu> <autor> <nr> - adauga o CARTE \n afisare - afiseaza toate cartile \n ad - arata toate dictionarele \n salvare <fisier> - salveaza biblioteca intr-un fisier \n open <fisier> - deschide fisier \n X - inchide aplicatia \n");
            line = cons.readLine();
            String[] v = line.split(" ");

            if(v[0].equalsIgnoreCase("X")){
                System.out.println("Ciao!");
                System.exit(0);

            }
            if(v[0].equalsIgnoreCase("ac")){
                try{
                    String tip=v[1];
                    String titlu=v[2];
                    String autor=v[3];
                    int nr = Integer.parseInt(v[4]);
                    Carte c = new Carte(tip, titlu, autor, nr);
                    biblio.adaCarte(c);
                    System.out.println("Carte adaugata!");
                }
                catch(Exception e){}
            }

            if(v[0].equalsIgnoreCase("afisare")){
                System.out.println("afisez");
                biblio.afiCarti();
            }

            if(v[0].equalsIgnoreCase("ad")){
                //                System.out.println("afisez");
                biblio.ad();
            }

            if(v[0].equalsIgnoreCase("salvare")){
                //String fisier = v[1];
                out = new ObjectOutputStream(new FileOutputStream(v[1]));
                out.writeObject(BookApp.biblio);
                out.close();
                System.out.print("Salvare efectuata!");
            }
            if(v[0].equalsIgnoreCase("open")){
                try{
                    in = new ObjectInputStream(new FileInputStream(v[1]));
                    biblio = (Biblioteca) in.readObject();
                    in.close();
                    System.out.print("Open");
                }
                catch(Exception e){
                       System.out.print("Nu exista acest fisier! \n \n ");  
                }
                /*
                try{
                biblio = (Biblioteca) in.readObject();
                }catch(Exception e){};
                 */

            }
        }    

    }
}
