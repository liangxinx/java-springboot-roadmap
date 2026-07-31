package D8test;

public class Staff extends Employee{
    private double baseSalary;

    public Staff(String name, double baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }
    @Override
    public double calculateSalary(){
        return baseSalary;
    }
}
