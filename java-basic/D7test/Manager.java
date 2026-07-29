package D7test;
//建立 `Manager` 子類別繼承 `Employee`：
//        - 額外屬性：`bonus`（獎金，double）
//        - 建構子多接收 `bonus`，用 `super(...)` 處理 `name`、`baseSalary`
//        - **覆寫** `calculateSalary()`，回傳 `baseSalary + bonus`
//
public class Manager extends Employee{
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double calculateSalary(){
        return baseSalary+bonus;
    }
}
