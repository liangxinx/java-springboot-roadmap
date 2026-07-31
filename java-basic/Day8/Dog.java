package Day8;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }
    @Override
    public void makeSound(){
        System.out.println("汪汪");
    }
}
