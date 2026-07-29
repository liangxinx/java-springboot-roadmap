//### Q6. 封裝練習：Person class
//建立一個 `Person` class：
//        - `private` 屬性：`name`（String）、`age`（int）
//        - 建構子傳入兩個屬性
//- 幫 `age` 寫 Setter，加入檢查：如果傳入的年齡小於 0 或大於 150，印出「年齡不合理」，不進行賦值
//- 幫兩個屬性都寫 Getter
//
//在 `Main` 裡建立一個 `Person`，測試合法跟不合理的年齡設定。
//
//        ---
//
//        ### Q7. static 計數器練習
//建立一個 `Order`（訂單）class：
//        - `private` 屬性：`orderId`（int）
//        - `static` 屬性：`orderCount`（記錄目前總共建立了幾筆訂單）
//        - 建構子：每次建立新訂單，`orderId` 就設成目前的 `orderCount + 1`，然後 `orderCount` 累加
//
//在 `Main` 裡連續建立 3 個訂單，印出每筆訂單的 `orderId`，確認是 1、2、3。
//
//        ---
//
//        ### Q8. static final 常數練習
//建立一個 `Rectangle`（矩形）class：
//        - `static final` 常數：不需要，這題其實不需要常數，改成建立一個 `TaxCalculator` class
//- `static final double TAX_RATE = 0.05;`（稅率5%）
//        - `static` method：`calculateTax(double price)`，回傳 `price * TAX_RATE`
//
//在 `Main` 裡呼叫 `TaxCalculator.calculateTax(1000)`，印出結果。
//
//        ---
//
//        ### Q9. 找出程式碼的錯誤
//下面這段程式碼有 **2 個問題**，請找出並修正：
//
//        ```java
//public class Product {
//    private String name;
//    private double price;
//
//    public Product(String name, double price) {
//        this.name = name;
//        this.price = price;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Product p = new Product("筆記本", 50.0);
//        p.price = 100.0;
//        System.out.println(p.getPrice());
//    }
//}
//```
//
//        ---
//
//        ### Q10. 綜合挑戰：圖書館系統
//建立一個 `Book` class：
//        - `private` 屬性：`title`（書名）、`isBorrowed`（是否已被借出，boolean，預設 `false`）
//        - `static` 屬性：`totalBooks`（記錄總共建立了幾本書）
//        - 建構子：只需要傳入 `title`，`isBorrowed` 一律從 `false` 開始，`totalBooks` 累加
//- method `borrow()`：如果 `isBorrowed` 是 `true`，印出「已被借出，無法借閱」；否則把 `isBorrowed` 設成 `true`，印出「借閱成功」
//        - method `returnBook()`：把 `isBorrowed` 設回 `false`，印出「歸還成功」
//        - Getter：`getTitle()`、`isBorrowed()`
//
//在 `Main` 裡建立 2 本書，測試借閱、重複借閱（應該失敗）、歸還後再借閱（應該成功），最後印出 `Book.totalBooks` 確認總數正確。
//
//        ---