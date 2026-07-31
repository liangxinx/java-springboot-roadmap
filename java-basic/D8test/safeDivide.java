package D8test;
import java.util.Scanner;

//寫一個 method `safeDivide(int a, int b)`，回傳 `double`：
//        - 如果 `b` 是 0，用 `try/catch` 攔截 `ArithmeticException`，印出「不能除以0」，回傳 `0`
//        - 否則正常回傳 `(double) a / b`
public class safeDivide {
    public static double safeDivide(int a, int b) {
        try {
            return (double) a / b;
        } catch (ArithmeticException e) {
            System.out.println("不能除以0");
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入被除數：");
        int a = scanner.nextInt();
        System.out.println("請輸入除數：");
        int b = scanner.nextInt();

        double result = safeDivide(a, b);
        System.out.println("結果: " + result);
    }
}
