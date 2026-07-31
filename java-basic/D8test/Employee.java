package D8test;
//建立一個 `abstract class Employee`，有 `protected` 屬性 `name`，建構子傳入，
// 一般方法 `void clockIn()` 印出「[name] 打卡上班」，以及一個抽象方法 `double calculateSalary()`。
public abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public void clockIn(){
        System.out.println(name+"打卡上班");
    }
    public abstract double calculateSalary();
}
