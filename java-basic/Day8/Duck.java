package Day8;

public class Duck implements Flyable,Swimmable{
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public void fly(){
        System.out.println(name+"非起來");
    }

    @Override
    public void swim(){
        System.out.println(name+"游泳吧");
    }
}
