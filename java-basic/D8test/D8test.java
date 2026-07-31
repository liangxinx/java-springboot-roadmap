//### Q4. 動手寫：建立 Interface 並實作
//建立一個 `Payable` interface，裡面有一個方法 `double calculatePayment()`。建立兩個 class：`Freelancer`（自由接案者，依工時計費）和 `FullTimeEmployee`（正職員工，固定月薪），都實作 `Payable`，各自提供合理的 `calculatePayment()` 邏輯（屬性、建構子自訂）。
//
//在 `Main` 裡建立一個 `Payable[]` 陣列放兩種員工，用迴圈統一呼叫 `calculatePayment()` 並印出結果。


//### Q5. 動手寫：建立 Abstract Class
//建立一個 `abstract class Employee`，有 `protected` 屬性 `name`，建構子傳入，一般方法 `void clockIn()` 印出「[name] 打卡上班」，以及一個抽象方法 `double calculateSalary()`。
//建立 `Manager` 和 `Staff` 兩個子類別繼承 `Employee`，各自實作 `calculateSalary()`（邏輯自訂，例如 Manager 有額外津貼）。
//在 `Main` 裡測試兩者都能呼叫 `clockIn()`（共用邏輯）和各自的 `calculateSalary()`（覆寫邏輯）。
//
//### Q9. 動手寫：安全的除法計算機
//寫一個 method `safeDivide(int a, int b)`，回傳 `double`：
//        - 如果 `b` 是 0，用 `try/catch` 攔截 `ArithmeticException`，印出「不能除以0」，回傳 `0`
//        - 否則正常回傳 `(double) a / b`
//
//在 `Main` 裡用 Scanner 讀取兩個整數，呼叫這個 method 並印出結果，測試正常輸入跟輸入 0 的情況。
//
//        ### Q10. 動手寫：finally 練習
//寫一個 method `processOrder(int orderId)`：
//        - 用 `try` 包住「模擬處理訂單」的邏輯：如果 `orderId` 小於 0，用 `throw new IllegalArgumentException("訂單編號不能是負數")` 主動丟出例外；否則印出「訂單 [orderId] 處理成功」
//        - 用 `catch` 攔截 `IllegalArgumentException`，印出錯誤訊息
//- 用 `finally` 印出「訂單處理流程結束」（不管成功失敗都要印）
//
//在 `Main` 裡分別呼叫 `processOrder(5)` 和 `processOrder(-3)`，確認兩種情況下 `finally` 都有執行。
//
//        ### Q11. 挑戰題：throws 搭配自訂驗證
//寫一個 method `validateAge(int age)`，沒有 `try/catch`，而是直接用 `throw` 拋出例外：
//        - 如果 `age < 0` 或 `age > 150`，`throw new IllegalArgumentException("年齡不合理: " + age)`
//        - 否則印出「年齡合法: [age]」
//
//在 `Main` 裡用 `try/catch` 呼叫這個 method，分別測試合法跟不合法的年齡，確認例外被正確攔截並印出訊息，程式沒有當掉。