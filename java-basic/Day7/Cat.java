package Day7;

public class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }

    public void meow(){
        System.out.println(name+"喵");
    }
}
