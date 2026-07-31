package D8test;

public class Freelancer implements Payable{
    private double hourlyRate;
    private int hours;

    public Freelancer(double hourlyRate, int hours) {
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    @Override
    public double calculatePayment(){
        return hourlyRate * hours;
    }
}
