package diverse;

public class Program
{
public static void main(String [] args){
Pisica p1 = new Pisica("Modjo",11);
System.out.println(p1.greutate + p1.culoare);
Pisica p2 = new Pisica("aaa");
p2.greutate =1;

System.out.println(p2.greutate + p2.culoare);
System.out.println(p1.miauna());


}
}
