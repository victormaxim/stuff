
public class Aleator {
public static void main(String[] args) {
	double bla = Math.random()*100;
	System.out.println(bla+1);
	double[] vec = new double[3];
	for (int i=0; i<vec.length;i++ )
		{
		vec[i] = Math.random()*100;
		System.out.format("%.0f%n", vec[i]);
		//System.out.println(vec[i]);
	System.out.println(i+1);}
}
}
