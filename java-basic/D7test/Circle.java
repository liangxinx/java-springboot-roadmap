package D7test;

public class Circle extends Shape{
    public Circle(String name) {
        super(name);
    }

    @Override
    public void draw(){
        super.draw();
        System.out.println("畫一個圓形形，用圓規");
    }
    public void showName(){
        System.out.println("這是一個圓形");
    }
}
