package Day8;

public class Throws {
    public static double divide(double a,double b){
        if (b==0){
            throw new ArithmeticException(("除數不能是0"));
        }
        return a/b;
    }

    public static void checkAge(int age){
        if (age<0 || age>150){
            throw new IllegalArgumentException("年齡不合理:"+age);
        }
        System.out.println("年齡合法:"+age);
    }

    public static void main(String[] args) {
        try {
            double result = divide(10,0);
            System.out.println(result);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }

        try {
            checkAge(-5);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println("結束");
    }
}
