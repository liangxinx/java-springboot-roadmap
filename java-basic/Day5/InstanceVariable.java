package Day5;
//看預設的實例變數
public class InstanceVariable {
    public static class Dog{
        String name;
        int age;
        boolean isVaccinated;
    }

    public static void main(String[] args) {
        Dog a = new Dog();
        System.out.println(a.name);
        System.out.println(a.age);
        System.out.println(a.isVaccinated);
    }
}


