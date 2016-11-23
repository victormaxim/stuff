package diverse;

public class Pisica
{
   String culoare;
   double greutate = 5;
   static String word = "miau!";
   
   
    public Pisica(String c, double g)
    {
        culoare =c;
        greutate =g;
   
    }

    
    public Pisica(String c){
    culoare = c;
    }
    
    
void spune()
    {
System.out.println("Miau");
}

static String miauna(){
return word;
}

}
