package BibliotecaTelacadPartial;

public class Biblioteca implements java.io.Serializable
{

    Carte[] c = new Carte[1000];
    int n;

    public void adaCarte(Carte carte){
        if(n<1000){
            c[n]=carte;
            n++;
        }else {PreaMulteCarti();}
    }

    public void PreaMulteCarti(){
        System.out.println("You need a bigger library!");
    }

    public boolean sterCarte(String nume){
        for(int i=0; i<n; i++){
            if(c[i].getTitlu().equals(nume)){
                for(int j=i;j<n-1;j++){
                    c[j]=c[j+1];
                    c[n-1]=null;
                    System.gc();
                    return true;
                }
            }

        }
        return false;
    }

    public void afiCarti(){
        System.out.println("Am aceste carti in biblioteca");

        for(int i=0;i<n;i++){
            System.out.printf("%s %s %s %s \n",c[i].getTip(), c[i].getTitlu(),c[i].getAutor(),c[i].getNr());
            System.out.println("-------------- \n");

        }

    }

    public void ad(){
        System.out.println("Am aceste dictionare:");
        for(int i=0;i<n;i++){
            if(c[i].getTip().equalsIgnoreCase("dictionar")){
                System.out.printf("%s %s %s \n",c[i].getTitlu(),c[i].getAutor(),c[i].getNr());
                System.out.println("-------------- \n");
            }

        }

    }
}
