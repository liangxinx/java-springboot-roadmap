package D8test;
//建立 `Manager` 和 `Staff` 兩個子類別繼承 `Employee`，各自實作 `calculateSalary()`（邏輯自訂，例如 Manager 有額外津貼）。

public class Manager extends Employee{
    private double baseSalary;
    private double allowance;

    public Manager(String name, double baseSalary, double allowance) {
        super(name);
        this.baseSalary = baseSalary;
        this.allowance = allowance;
    }
    @Override
    public double calculateSalary(){
        return baseSalary + allowance;
    }
}
