package Punct;

public class Program3
{

    public static void main(String[] args){
    Punct p1 = new Punct(5,10);
    System.out.println(p1.x + " " + p1.y);
    int newx= p1.miscaPunct(15);
    System.out.println(newx);
    
    Punct p2 = new Punct();
    System.out.println(p2.x + " " + p2.y);
    
System.out.println(p2.getZ());


    
    }
    
}
