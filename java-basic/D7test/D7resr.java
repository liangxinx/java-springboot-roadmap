//### Q6. 建立基礎的繼承關係
//建立一個 `Shape`（形狀）父類別，屬性 `name`（String），建構子傳入 `name`，
//有一個 `void draw()` method，印出「畫一個 [name]」。
//
//建立 `Circle` 和 `Square` 兩個子類別繼承 `Shape`，建構子呼叫 `super(name)`，
//並且**覆寫** `draw()`，各自印出更具體的訊息（例如「畫一個圓形，用圓規」、「畫一個正方形，用尺」）。
//
//在 `Main` 裡分別建立這兩個物件並呼叫 `draw()`。
//
//        ### Q7. super 呼叫父類別方法練習
//延續 Q6，讓 `Circle` 的 `draw()` 在印出自己的訊息**之前**，先呼叫 `super.draw()`（印出父類別原本那句「畫一個 [name]」），再印出自己額外的內容。
//
//        ---
//
//        ### Q8. 多型陣列練習
//延續 Q6、Q7，在 `Main` 裡建立一個 `Shape[]` 陣列，裡面放 2 個 `Circle` 和 2 個 `Square`（順序自訂），
//用 `for-each` 迴圈呼叫每個物件的 `draw()`，確認每個都印出各自覆寫過的版本。
//
//        ---
//
//        ### Q9. instanceof 練習
//延續 Q8 的陣列，在同一個迴圈裡，用 `instanceof`（可以用 Java 14+ 的新寫法）判斷：如果是 `Circle`，額外印出「這是圓形」；如果是 `Square`，額外印出「這是正方形」。
//
//        ---
//
//        ### Q10. 找出程式碼的錯誤
//下面這段程式碼有 **2 個問題**，請找出並修正：
//
//        ```java
//public class Vehicle {
//    protected String brand;
//
//    public Vehicle(String brand) {
//        this.brand = brand;
//    }
//
//    public void honk() {
//        System.out.println(brand + " 按喇叭");
//    }
//}
//
//public class Car extends Vehicle {
//    private int doors;
//
//    public Car(String brand, int doors) {
//        this.doors = doors;
//    }
//
//    private void honk() {
//        System.out.println(brand + " 汽車按喇叭，共有" + doors + "個門");
//    }
//}

//建構子沒有suoer
//```
//
//        ---
//
//        ### Q11. 挑戰題：員工薪資系統（綜合應用）
//建立一個 `Employee` 父類別：
//        - `protected` 屬性：`name`、`baseSalary`（底薪，double）
//        - 建構子傳入兩者
//- `double calculateSalary()` method：回傳 `baseSalary`（一般員工薪水就是底薪）
//
//建立 `Manager` 子類別繼承 `Employee`：
//        - 額外屬性：`bonus`（獎金，double）
//        - 建構子多接收 `bonus`，用 `super(...)` 處理 `name`、`baseSalary`
//        - **覆寫** `calculateSalary()`，回傳 `baseSalary + bonus`
//
//建立 `Intern`（實習生）子類別繼承 `Employee`：
//        - 建構子只傳入 `name`，`baseSalary` 固定是 `20000`（用 `super(name, 20000)`）
//        - 不用覆寫 `calculateSalary()`（沿用父類別的邏輯即可）
//
//在 `Main` 裡：
//        1. 建立一個 `Employee[]` 陣列，放 1 個 `Manager`、1 個一般 `Employee`、1 個 `Intern`
//        2. 用 for-each 迴圈，印出每個人的名字和 `calculateSalary()` 的結果
//3. 用 `instanceof` 判斷，如果是 `Manager`，額外印出「這位是主管，獎金是 [bonus]」
//
//        ---