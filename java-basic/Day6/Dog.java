package Day6;

public class Dog {
    private String name;
    private int age;
    static int dogCount;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name){//Setter
        this.name=name;
    }
    public void setAge(int age){
        if(age<0){
            System.out.println("負數不能當年齡");
            return;
        }
        this.age=age;
    }

    public Dog(String name,int age){
        this.name=name;
        this.age=age;
        dogCount++;// 每建立一隻狗，共用的計數器就+1
    }
    public void brak(){
        System.out.println(name + "汪，目前有"+Dog.dogCount+"隻狗");
    }
    public boolean isAdult(){
        return age > 2;
    }
}
