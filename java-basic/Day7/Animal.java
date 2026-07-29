package Day7;

public class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat (){
        System.out.println(name+"正在吃飯");
    }
    public void sleep() {
        System.out.println(name + " 正在睡覺");
    }
}
