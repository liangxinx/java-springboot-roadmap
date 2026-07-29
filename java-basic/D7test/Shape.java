package D7test;
//建立一個 `Shape`（形狀）父類別，屬性 `name`（String），建構子傳入 `name`，
//有一個 `void draw()` method，印出「畫一個 [name]」。
public class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }
    public void draw(){
        System.out.println("劃一個"+name);
    }
}
