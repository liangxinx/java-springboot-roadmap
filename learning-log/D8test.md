# Java 練習考題 — Day 8
---

## 第一部分：Interface / Abstract Class

### Q1. 觀念題：這段程式碼會不會編譯錯誤？

```java
public interface Swimmable {
    void swim();
}

public class Fish implements Swimmable {
    // 沒有寫 swim()
}
```
會

### Q2. 觀念題：這段會不會編譯錯誤？

```java
public abstract class Shape {
    public abstract double getArea();
}

public class Main {
    public static void main(String[] args) {
        Shape s = new Shape();
    }
}
```
會 abstract 不能new

### Q3. 選擇題：下面三種情境，各自比較適合用 Interface 還是 Abstract Class？請說明原因。
1. 「手機」跟「冰箱」都需要「可以連網路」這個能力  Interface
2. 「跑車」、「休旅車」、「貨車」都是「車輛」的一種，有共用的煞車、加油邏輯，但引擎馬力計算方式不同  Abstract
3. 「印表機」跟「掃描機」都需要具備「可以掃描文件」的能力，但兩者本質上是完全不同的裝置 in

### Q4. 動手寫：建立 Interface 並實作
建立一個 `Payable` interface，裡面有一個方法 `double calculatePayment()`。建立兩個 class：`Freelancer`（自由接案者，依工時計費）和 `FullTimeEmployee`（正職員工，固定月薪），都實作 `Payable`，各自提供合理的 `calculatePayment()` 邏輯（屬性、建構子自訂）。

在 `Main` 裡建立一個 `Payable[]` 陣列放兩種員工，用迴圈統一呼叫 `calculatePayment()` 並印出結果。

### Q5. 動手寫：建立 Abstract Class
建立一個 `abstract class Employee`，有 `protected` 屬性 `name`，建構子傳入，一般方法 `void clockIn()` 印出「[name] 打卡上班」，以及一個抽象方法 `double calculateSalary()`。

建立 `Manager` 和 `Staff` 兩個子類別繼承 `Employee`，各自實作 `calculateSalary()`（邏輯自訂，例如 Manager 有額外津貼）。

在 `Main` 裡測試兩者都能呼叫 `clockIn()`（共用邏輯）和各自的 `calculateSalary()`（覆寫邏輯）。

---

## 第二部分：Exception 處理

### Q6. 觀念題：這段程式碼執行後會印出什麼？

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("A");
        try {
            System.out.println("B");
            int result = 10 / 0;
            System.out.println("C");
        } catch (ArithmeticException e) {
            System.out.println("D");
        } finally {
            System.out.println("E");
        }
        System.out.println("F");
    }
}
```
ABDEF
### Q7. 觀念題：`throws` 和 `throw` 有什麼差異？各自用在什麼地方？

**A7.** `throws` 寫在 method 簽名上，用來**宣告**「這個 method 可能會丟出某種例外」，是一種提醒；`throw` 寫在 method 內部，是**真正執行**丟出例外的動作（例如 `throw new ArithmeticException(...)`）。`throws` 用於宣告，`throw` 用於實際觸發。

### Q8. 找出程式碼的錯誤
下面這段程式碼有 **1 個邏輯問題**（不一定是編譯錯誤，而是設計不良），請指出並說明為什麼不好：

```java
public static int parseNumber(String input) {
    try {
        return Integer.parseInt(input);
    } catch (Exception e) {
        return -1; // 用-1代表轉換失敗
    }
}
```
（提示：想想看，如果使用者真的想輸入 `-1` 這個合法數字，呼叫端要怎麼分辨「這是真的-1」還是「其實是轉換失敗」？）

### Q9. 動手寫：安全的除法計算機
寫一個 method `safeDivide(int a, int b)`，回傳 `double`：
- 如果 `b` 是 0，用 `try/catch` 攔截 `ArithmeticException`，印出「不能除以0」，回傳 `0`
- 否則正常回傳 `(double) a / b`

在 `Main` 裡用 Scanner 讀取兩個整數，呼叫這個 method 並印出結果，測試正常輸入跟輸入 0 的情況。

### Q10. 動手寫：finally 練習
寫一個 method `processOrder(int orderId)`：
- 用 `try` 包住「模擬處理訂單」的邏輯：如果 `orderId` 小於 0，用 `throw new IllegalArgumentException("訂單編號不能是負數")` 主動丟出例外；否則印出「訂單 [orderId] 處理成功」
- 用 `catch` 攔截 `IllegalArgumentException`，印出錯誤訊息
- 用 `finally` 印出「訂單處理流程結束」（不管成功失敗都要印）

在 `Main` 裡分別呼叫 `processOrder(5)` 和 `processOrder(-3)`，確認兩種情況下 `finally` 都有執行。

### Q11. 挑戰題：throws 搭配自訂驗證
寫一個 method `validateAge(int age)`，沒有 `try/catch`，而是直接用 `throw` 拋出例外：
- 如果 `age < 0` 或 `age > 150`，`throw new IllegalArgumentException("年齡不合理: " + age)`
- 否則印出「年齡合法: [age]」

在 `Main` 裡用 `try/catch` 呼叫這個 method，分別測試合法跟不合法的年齡，確認例外被正確攔截並印出訊息，程式沒有當掉。

---

## 參考答案

<details>
<summary>點我展開答案（寫完再看喔！）</summary>

**A1.** 會編譯錯誤。`Fish implements Swimmable`，但沒有提供 `swim()` 的具體實作，違反了 Interface 的強制規則（實作 interface 的 class 必須提供合約裡所有方法的內容）。

**A2.** 會編譯錯誤。`Shape` 是 `abstract class`，抽象類別不能直接用 `new` 建立實例，因為 `getArea()` 沒有實際內容，Java 不允許建立這種「未完成」的物件。

**A3.**
1. 用 **Interface**：手機跟冰箱本質上完全不相關（一個是通訊裝置，一個是家電），只是剛好都需要「連網路」這個能力，符合 Interface「彼此不相關但需要共同能力」的情境。
2. 用 **Abstract Class**：跑車、休旅車、貨車血緣關係很近（都是車輛），且有共用邏輯（煞車、加油），只有部分行為（引擎馬力）不同，符合 Abstract Class「本質相似、有共用邏輯」的情境。
3. 用 **Interface**：印表機跟掃描機是不同種類的裝置，只是剛好都需要「掃描」這個能力，彼此不存在「是一種」的血緣關係，適合用 Interface。

**A4.**
```java
public interface Payable {
    double calculatePayment();
}

public class Freelancer implements Payable {
    private double hourlyRate;
    private int hours;

    public Freelancer(double hourlyRate, int hours) {
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    @Override
    public double calculatePayment() {
        return hourlyRate * hours;
    }
}

public class FullTimeEmployee implements Payable {
    private double monthlySalary;

    public FullTimeEmployee(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePayment() {
        return monthlySalary;
    }
}

public class Main {
    public static void main(String[] args) {
        Payable[] payables = new Payable[2];
        payables[0] = new Freelancer(500, 40);
        payables[1] = new FullTimeEmployee(45000);

        for (Payable p : payables) {
            System.out.println("應付金額: " + p.calculatePayment());
        }
    }
}
```

**A5.**
```java
public abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public void clockIn() {
        System.out.println(name + " 打卡上班");
    }

    public abstract double calculateSalary();
}

public class Manager extends Employee {
    private double baseSalary;
    private double allowance;

    public Manager(String name, double baseSalary, double allowance) {
        super(name);
        this.baseSalary = baseSalary;
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + allowance;
    }
}

public class Staff extends Employee {
    private double baseSalary;

    public Staff(String name, double baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        employees[0] = new Manager("王經理", 50000, 8000);
        employees[1] = new Staff("小陳", 32000);

        for (Employee e : employees) {
            e.clockIn();
            System.out.println("薪水: " + e.calculateSalary());
        }
    }
}
```

**A6.**
```
A
B
D
E
F
```
說明：`10 / 0` 出錯，`try` 裡出錯那行之後的 `C` 不會被印出，直接跳到 `catch` 印出 `D`，接著不管有沒有出錯 `finally` 都會執行印出 `E`，最後回到 `try/catch` 外面繼續印出 `F`。

**A7.** `throws` 寫在 method 簽名上，用來**宣告**「這個 method 可能會丟出某種例外」，是一種提醒；`throw` 寫在 method 內部，是**真正執行**丟出例外的動作（例如 `throw new ArithmeticException(...)`）。`throws` 用於宣告，`throw` 用於實際觸發。

**A8.** 這個設計的問題是：**用一個「合法的回傳值」（-1）去代表「錯誤發生了」，會跟真正合法的輸入資料混淆**。如果使用者原本就想輸入 `"-1"` 這個字串（想轉成合法的 -1），呼叫端會拿到 `-1`，但完全無法分辨「這是真的轉換成功、結果是-1」還是「其實轉換失敗，回傳-1只是個代表錯誤的訊號」。更好的做法應該是讓例外繼續往外拋（用 `throws`），讓呼叫端自己用 `try/catch` 決定怎麼處理，而不是用一個容易混淆的特殊值。

**A9.**
```java
import java.util.Scanner;

public class SafeDivideDemo {

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
```
（註：`double / 0` 其實不會拋例外而是回傳 `Infinity`，但因為分子分母都是 `int` 相除前才轉型，這裡 `b` 若為 0 會先觸發 int 的 `ArithmeticException`，寫法沒問題）

**A10.**
```java
public class OrderDemo {

    public static void processOrder(int orderId) {
        try {
            if (orderId < 0) {
                throw new IllegalArgumentException("訂單編號不能是負數");
            }
            System.out.println("訂單 " + orderId + " 處理成功");
        } catch (IllegalArgumentException e) {
            System.out.println("錯誤: " + e.getMessage());
        } finally {
            System.out.println("訂單處理流程結束");
        }
    }

    public static void main(String[] args) {
        processOrder(5);
        processOrder(-3);
    }
}
```

**A11.**
```java
public class AgeValidator {

    public static void validateAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("年齡不合理: " + age);
        }
        System.out.println("年齡合法: " + age);
    }

    public static void main(String[] args) {
        try {
            validateAge(25);
        } catch (IllegalArgumentException e) {
            System.out.println("錯誤: " + e.getMessage());
        }

        try {
            validateAge(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("錯誤: " + e.getMessage());
        }

        System.out.println("程式正常結束");
    }
}
```

</details>