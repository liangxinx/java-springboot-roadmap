package D6tset;
//建立一個 `Rectangle`（矩形）class：
//- `static final` 常數：不需要，這題其實不需要常數，改成建立一個 `TaxCalculator` class
//- `static final double TAX_RATE = 0.05;`（稅率5%）
//        - `static` method：`calculateTax(double price)`，回傳 `price * TAX_RATE`
//
//在 `Main` 裡呼叫 `TaxCalculator.calculateTax(1000)`，印出結果。
public class Rectangle {
    static final double TAX_RATE=0.05;

    public static double calculateTax(double price){
        return price * TAX_RATE;
    }
}
