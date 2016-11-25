public class Temperature {
private double number;
private TempScale scale;
public Temperature() {
number = 0.0;
scale = TempScale.FAHRENHEIT;
}
public Temperature(double number) {
this.number = number;
scale = TempScale.FAHRENHEIT;
}
public Temperature(TempScale scale) {
number = 0.0;
this.scale = scale;
}
public Temperature(double number, TempScale scale) {
this.number = number/7;
this.scale = scale;
//System.out.println("x");
}
public void setNumber(double number) {
this.number = number / 7;
}
public double getNumber() {
return number;
}
public void setScale(TempScale scale) {
this.scale = scale;
}
public TempScale getScale() {
return scale;
}
}