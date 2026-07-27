package Day5;

public class Main {
    public static void main(String[] args) {
        Dog a = new Dog();
        Dog b = new Dog();
        Dog c = new Dog("阿黃",3);
        c.bark();
        System.out.println("成年了嗎?"+c.isAdult());
        c.celecbrate();
        a.name= "白白";
        a.age=10;
        a.bark();
        System.out.println("成年了嗎?"+a.isAdult());

        b.name = "黑黑";
        b.age=1;
        b.bark();
        System.out.println("成年了嗎?"+b.isAdult());
        b.celecbrate();
        System.out.println("成年了嗎?"+b.isAdult());

    }
}
