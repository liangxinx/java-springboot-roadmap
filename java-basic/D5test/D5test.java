//## 第二部分：動手寫程式
//
//### Q6. 建立第一個 Class：Book
//建立一個 `Book` class，包含三個屬性：`title`（書名，String）、`author`（作者，String）、`price`（價格，double）。寫一個建構子可以一次傳入這三個資料。再寫一個 `printInfo()` method，印出這本書的完整資訊。
//
//在 `Main` 裡建立兩本不同的書，分別呼叫 `printInfo()`。
//
//        ---
//
//        ### Q7. this 練習
//建立一個 `Student` class，屬性有 `name`、`score`。建構子的參數名稱要跟屬性**完全同名**（練習用 `this` 正確賦值）。再寫一個 `isPassing()` method，回傳 `boolean`，判斷 `score` 是否大於等於 60。
//
//在 `Main` 裡建立兩個學生物件，測試看看。
//  上面那題一起做掉了
//        ---
//        ### Q8. 找出程式碼的錯誤
//下面這段程式碼有 **2 個問題**，請找出並修正：
//
//        ```java
//public class D5test {
//    String name;
//    double price;
//
//    public D5test(String name, double price) {
//        this.name = name;
//        this.price = price;
//    }
//
//    void showPrice() {
//        System.out.println(name + " 價格: " + price);
//    }
//}
//        ### Q9. 物件陣列（進階挑戰，結合前幾天學的陣列）
//建立一個 `Fruit` class，屬性有 `name`、`price`。在 `Main` 裡建立一個 `Fruit[]` 陣列，裡面放 3 個不同的水果物件，用 `for` 迴圈把每個水果的名稱和價格印出來。
//
//        （提示：陣列裡放的不再是 `int` 或 `String`，而是 `Fruit` 物件，宣告方式是 `Fruit[] fruits = new Fruit[3];`）
//
//        ---
//
//        ### Q10. 建構子 Overloading 練習
//延續 Q6 的 `Book` class，再新增一個**只有 `title` 一個參數**的建構子，`author` 預設為 `"未知"`，`price` 預設為 `0`。在 `Main` 裡分別用兩種方式建立 `Book` 物件並印出資訊，確認兩種建構子都能正常運作。

//        ### Q11. 挑戰題：銀行帳戶模擬
//建立一個 `BankAccount` class：
//        - 屬性：`owner`（帳戶名稱）、`balance`（餘額，double）
//        - 建構子：傳入 `owner`，`balance` 一律從 0 開始
//- method `deposit(double amount)`：存錢，把 `amount` 加進 `balance`
//        - method `withdraw(double amount)`：領錢，如果 `amount` 大於 `balance`，印出「餘額不足」，不執行扣款；否則扣款成功
//- method `showBalance()`：印出目前餘額
//
//在 `Main` 裡建立一個帳戶，測試存錢、領錢（包含餘額不足的情況）、查詢餘額。
//
//        ---
