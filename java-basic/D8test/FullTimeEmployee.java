package D8test;

public class FullTimeEmployee implements Payable{
    private double monthlySalary;

    public FullTimeEmployee(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePayment(){
        return monthlySalary;
    }
}
