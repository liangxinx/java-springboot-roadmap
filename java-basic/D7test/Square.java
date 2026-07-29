package D7test;

public class Square extends Shape{
    public Square(String name) {
        super(name);
    }
    //並且**覆寫** `draw()`，各自印出更具體的訊息（例如「畫一個圓形，用圓規」、「畫一個正方形，用尺」）。
    @Override
    public void draw(){
        super.draw();
        System.out.println("畫一個正方形，用尺");
    }

    public void showName(){
        System.out.println("這是一個正方形");
    }
}
