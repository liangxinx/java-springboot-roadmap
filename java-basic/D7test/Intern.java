package D7test;
//建立 `Intern`（實習生）子類別繼承 `Employee`：
//        - 建構子只傳入 `name`，`baseSalary` 固定是 `20000`（用 `super(name, 20000)`）
//        - 不用覆寫 `calculateSalary()`（沿用父類別的邏輯即可）
public class Intern extends Employee{
    public Intern(String name) {
        super(name, 20000);
    }
}
