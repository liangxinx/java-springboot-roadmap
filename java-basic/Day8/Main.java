package Day8;

public class Main {
    public static void main(String[] args) {
//        Duck a = new Duck("aa");
//        a.fly();
//        a.swim();
//
//        Flyable f = a;
//        f.fly();

        Animal[] animals = new Animal[2];
        animals[0] = new Dog("阿凱");
        animals[1] = new Cat("咪咪");

        for(Animal a : animals){
            a.sleep();
            a.makeSound();
        }
    }
}
