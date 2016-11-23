/**
 * Created by alexandru.dima on 10/10/2016.
 */
public class Car implements Vitezometru {
//int vit = 99;

//    public Car(int viteza) {
//        System.out.println("bleah " + viteza);
//    }


    public static void main(String[] args) {
        Car bmw = new Car();
        //bmw.vit =10;
        bmw.arataViteza(bmw.vit);


    }

    public void arataViteza(int vit) {
        System.out.println("x:" + vit);

    }


}

