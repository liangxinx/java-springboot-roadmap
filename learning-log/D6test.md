# Java 練習考題 — Day 6

## 第一部分：基礎觀念題

**Q1.** 下面這段程式碼會編譯錯誤，請說明原因並修正：

```java
public class Cat {
    private String name;
}

public class Main {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.name = "小咪";
        System.out.println(c.name);
    }
}
```
private的不可以被更改，要加getset


**Q2.** 請說明「屬性設 `private`、方法設 `public`」這個設計原則為什麼比「屬性直接設 `public`」更安全，請舉一個具體例子。

因為方法藥可以被呼叫，屬性不要隨便變動比較好，而且set 可以設定阻擋讓人不要填樹不正確的數值

**Q3.** 下面這段程式碼會印出什麼？

```java
public class Counter {
    static int total = 0;

    public Counter() {
        total++;
    }
}

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        System.out.println(Counter.total);
    }
}
```
3
**Q4.** 下面這段程式碼哪裡會編譯錯誤？為什麼？

```java
public class Test {
    private int score;

    public static void printScore() {
        System.out.println(score);
    }
}
```
不允許在 static method 裡直接使用非 static 的屬性

**Q5.** `final` 變數必須在什麼時候被賦值？賦值後可以再修改嗎？

宣告的時候 不能
---

## 第二部分：動手寫程式

### Q6. 封裝練習：Person class
建立一個 `Person` class：
- `private` 屬性：`name`（String）、`age`（int）
- 建構子傳入兩個屬性
- 幫 `age` 寫 Setter，加入檢查：如果傳入的年齡小於 0 或大於 150，印出「年齡不合理」，不進行賦值
- 幫兩個屬性都寫 Getter

在 `Main` 裡建立一個 `Person`，測試合法跟不合理的年齡設定。

---

### Q7. static 計數器練習
建立一個 `Order`（訂單）class：
- `private` 屬性：`orderId`（int）
- `static` 屬性：`orderCount`（記錄目前總共建立了幾筆訂單）
- 建構子：每次建立新訂單，`orderId` 就設成目前的 `orderCount + 1`，然後 `orderCount` 累加

在 `Main` 裡連續建立 3 個訂單，印出每筆訂單的 `orderId`，確認是 1、2、3。

---

### Q8. static final 常數練習
建立一個 `Rectangle`（矩形）class：
- `static final` 常數：不需要，這題其實不需要常數，改成建立一個 `TaxCalculator` class
- `static final double TAX_RATE = 0.05;`（稅率5%）
- `static` method：`calculateTax(double price)`，回傳 `price * TAX_RATE`

在 `Main` 裡呼叫 `TaxCalculator.calculateTax(1000)`，印出結果。

---

### Q9. 找出程式碼的錯誤
下面這段程式碼有 **2 個問題**，請找出並修正：

```java
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {
        Product p = new Product("筆記本", 50.0);
        p.price = 100.0;
        System.out.println(p.getPrice());
    }
}
```

---

### Q10. 綜合挑戰：圖書館系統
建立一個 `Book` class：
- `private` 屬性：`title`（書名）、`isBorrowed`（是否已被借出，boolean，預設 `false`）
- `static` 屬性：`totalBooks`（記錄總共建立了幾本書）
- 建構子：只需要傳入 `title`，`isBorrowed` 一律從 `false` 開始，`totalBooks` 累加
- method `borrow()`：如果 `isBorrowed` 是 `true`，印出「已被借出，無法借閱」；否則把 `isBorrowed` 設成 `true`，印出「借閱成功」
- method `returnBook()`：把 `isBorrowed` 設回 `false`，印出「歸還成功」
- Getter：`getTitle()`、`isBorrowed()`

在 `Main` 裡建立 2 本書，測試借閱、重複借閱（應該失敗）、歸還後再借閱（應該成功），最後印出 `Book.totalBooks` 確認總數正確。

---

## 參考答案

<details>
<summary>點我展開答案（寫完再看喔！）</summary>

**A1.** `c.name` 這裡編譯錯誤，因為 `name` 是 `private`，只有 `Cat` 這個 class 內部能存取，`Main` 是外部的 class，不能直接讀取或修改。修正方式是幫 `Cat` 加上 Getter/Setter：
```java
public class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```
然後在 `Main` 裡改用 `c.setName("小咪")` 和 `c.getName()`。

**A2.** 因為 Setter 是一個 method，可以在裡面加入驗證邏輯，阻擋不合理的資料進入。例如 `age` 如果是 `public`，任何地方都可以直接寫 `person.age = -100;`，沒有任何機制可以檢查阻止；但如果 `age` 是 `private` 並透過 `setAge()` 修改，就可以在 `setAge()` 裡加上「年齡不能是負數」的檢查，確保物件的資料永遠是合理的狀態。

**A3.** 印出 `3`。`total` 是 `static`，三個 `Counter` 物件共用同一份 `total`，每次呼叫建構子都會讓這個共用的變數 +1，所以建立三個物件後 `total` 會是 3。

**A4.** `System.out.println(score);` 這行會編譯錯誤。因為 `printScore()` 是 `static` method，而 `score` 是非 `static` 的屬性（屬於每一個物件）。`static` method 執行時不知道要用「哪一個物件」的 `score`（可能還沒有任何物件被建立），所以 Java 不允許在 `static` method 裡直接使用非 `static` 的屬性。

**A5.** `final` 變數必須在**宣告時**或**建構子裡**被賦值恰好一次。賦值之後，**不能再被修改**，之後任何地方嘗試重新賦值都會編譯錯誤。

**A6.**
```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("年齡不合理");
            return;
        }
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person("小明", 25);
        System.out.println(p.getName() + ", " + p.getAge());

        p.setAge(200); // 年齡不合理
        System.out.println(p.getAge()); // 還是 25
    }
}
```

**A7.**
```java
public class Order {
    private int orderId;
    static int orderCount = 0;

    public Order() {
        orderCount++;
        this.orderId = orderCount;
    }

    public int getOrderId() {
        return orderId;
    }
}

public class Main {
    public static void main(String[] args) {
        Order o1 = new Order();
        Order o2 = new Order();
        Order o3 = new Order();

        System.out.println(o1.getOrderId());
        System.out.println(o2.getOrderId());
        System.out.println(o3.getOrderId());
    }
}
```

**A8.**
```java
public class TaxCalculator {
    static final double TAX_RATE = 0.05;

    public static double calculateTax(double price) {
        return price * TAX_RATE;
    }
}

public class Main {
    public static void main(String[] args) {
        double tax = TaxCalculator.calculateTax(1000);
        System.out.println("稅金: " + tax); // 50.0
    }
}
```

**A9.** 兩個問題：
1. `p.price = 100.0;` 這行編譯錯誤，因為 `price` 是 `private`，外部不能直接存取。這個 class 沒有寫 `setPrice()`，如果需求上真的需要外部能修改價格，應該補上 Setter；如果價格不該被外部隨意修改，就應該把這行拿掉，改用其他合法管道（例如某個有檢查邏輯的 method）修改。
2. 這其實也提醒了一個設計問題：如果 `Product` 的價格本來就不希望被任意修改，那目前只有 Getter 沒有 Setter 的設計其實是對的，錯誤反而是在 `Main` 裡寫了不該寫的那一行。

修正後（假設允許透過受控的 setter 修改）：
```java
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("價格不能是負數");
            return;
        }
        this.price = price;
    }
}
```
`Main` 裡改成 `p.setPrice(100.0);`

**A10.**
```java
public class Book {
    private String title;
    private boolean isBorrowed;
    static int totalBooks = 0;

    public Book(String title) {
        this.title = title;
        this.isBorrowed = false;
        totalBooks++;
    }

    public void borrow() {
        if (isBorrowed) {
            System.out.println(title + " 已被借出，無法借閱");
        } else {
            isBorrowed = true;
            System.out.println(title + " 借閱成功");
        }
    }

    public void returnBook() {
        isBorrowed = false;
        System.out.println(title + " 歸還成功");
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java入門");
        Book book2 = new Book("SQL基礎");

        book1.borrow();          // 借閱成功
        book1.borrow();          // 已被借出，無法借閱
        book1.returnBook();      // 歸還成功
        book1.borrow();          // 借閱成功

        System.out.println("目前總書量: " + Book.totalBooks); // 2
    }
}
```

</details>