import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alexandru.dima on 11/17/2016.
 */
public class Snippets {
    public static void main(String[] args) {
//TIME
        Date data = new Date();
        System.out.println(data);

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        System.out.println(dateFormat.format(data)); //2014/08/06 15:59:48

//BIT OPERATIONS
        int x = 42;
        int y = 15;
        System.out.println(x ^ y);



    }
}

class Threader {
    static int x=20;
    public static void main(String[] args) {

        Runner run = new Runner(1043);
        run.run(x);
    }

}

class Runner extends Thread{
    int timp;

    Runner(int timp){
        this.timp = timp;
    }

    public void run(int x){

        for(int i =0; i<10; i++){
            System.out.println(i);
            try {
                x++;
                System.out.println(x);
                Thread.sleep(timp);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }

    }


}
