package Day6;

public class Circle {
    static final double PI = 3.14;
    private double radius;

    public Circle(double radius){
        this.radius=radius;
    }
    public double getAre(){
        return PI*radius*radius;
    }
    public  double getCircumference(){
        return 2*radius*PI;
    }
}
