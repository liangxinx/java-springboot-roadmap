package Day7;

public class Dog extends Animal{
    private String breed;
    public Dog(String name, int age,String breed) {
        super(name, age);
        this.breed=breed;
    }
    public void brak(){
        System.out.println(name+"汪");
    }

    @Override
    public void eat(){
        super.eat();
        System.out.println("吃狗飼料");
    }
}
