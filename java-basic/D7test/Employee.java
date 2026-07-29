package D7test;
//        - `protected` 屬性：`name`、`baseSalary`（底薪，double）
//        - 建構子傳入兩者
//- `double calculateSalary()` method：回傳 `baseSalary`（一般員工薪水就是底薪）
public class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public double calculateSalary(){
        return baseSalary;
    }
}
