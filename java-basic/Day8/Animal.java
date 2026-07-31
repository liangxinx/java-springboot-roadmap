package Day8;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sleep(){
        System.out.println(name+"正在睡覺");
    }

    public abstract void makeSound();
}
