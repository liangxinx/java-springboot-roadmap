# Java 練習考題 — Day 5


## 第一部分：基礎觀念題

**Q1.** 請用自己的話說明 Class 跟 Object 的差異，並舉一個生活化的例子（不要用課堂上教的車子例子）。
Class 是一個設計規範，用來描述物件有哪些屬性和行為，它本身不是實際存在的物件。Object 則是根據 Class 建立出來的實體，可以擁有自己的資料。

例如：Class 可以是「學生」，定義學生有姓名、年齡、學號等資料，以及上課、吃飯、睡覺等行為。而 Object 可以是「小明這位學生」，他就是根據學生這個 Class 建立出來的實際物件，並且有自己的姓名、年齡和學號。

**Q2.** 下面這段建構子有一個經典的 bug，請找出來並說明為什麼：

```java
public class Cat {
    String name;
    int age;

    public Cat(String name, int age) {
        name = name;
        age = age;
    }
}
```
沒有用this會不知道相同的那個變數是個啥

**Q3.** 下面這段程式碼會印出什麼？

```java
public class Counter {
    int count;
}

public class Main {
    public static void main(String[] args) {
        Counter c = new Counter();
        System.out.println(c.count);
    }
}
```
印出0

**Q4.** 下面兩個 method，哪一個屬於「物件」、哪一個屬於「class 本身」？呼叫方式會有什麼不同？

```java
public static int square(int n) {
    return n * n;
}

public void bark() {
    System.out.println(name + " 汪汪");
}
```
第一個屬於class本身 因為她有static 下面那屬於物件
第一個的呼叫方式直接用square.就好
下面要new

**Q5.** 一個 class 如果自己寫了建構子，還會不會有 Java 提供的預設建構子可以用？請舉例說明。
不會，除非它裡面什麼都沒有填寫

---

## 第二部分：動手寫程式

### Q6. 建立第一個 Class：Book
建立一個 `Book` class，包含三個屬性：`title`（書名，String）、`author`（作者，String）、`price`（價格，double）。寫一個建構子可以一次傳入這三個資料。再寫一個 `printInfo()` method，印出這本書的完整資訊。

在 `Main` 裡建立兩本不同的書，分別呼叫 `printInfo()`。

---

### Q7. this 練習
建立一個 `Student` class，屬性有 `name`、`score`。建構子的參數名稱要跟屬性**完全同名**（練習用 `this` 正確賦值）。再寫一個 `isPassing()` method，回傳 `boolean`，判斷 `score` 是否大於等於 60。

在 `Main` 裡建立兩個學生物件，測試看看。

---

### Q8. 找出程式碼的錯誤
下面這段程式碼有 **2 個問題**，請找出並修正：

```java
public class Product {
    String name;
    double price;

    public Product(String name, double price) {
        name = name;
        price = price;
    }

    void showPrice() {
        System.out.println(name + " 價格: " + price);
    }
}
```
（提示：一個是今天教過的經典陷阱，另一個是關於權限修飾詞的建議寫法）

---

### Q9. 物件陣列（進階挑戰，結合前幾天學的陣列）
建立一個 `Fruit` class，屬性有 `name`、`price`。在 `Main` 裡建立一個 `Fruit[]` 陣列，裡面放 3 個不同的水果物件，用 `for` 迴圈把每個水果的名稱和價格印出來。

（提示：陣列裡放的不再是 `int` 或 `String`，而是 `Fruit` 物件，宣告方式是 `Fruit[] fruits = new Fruit[3];`）

---

### Q10. 建構子 Overloading 練習
延續 Q6 的 `Book` class，再新增一個**只有 `title` 一個參數**的建構子，`author` 預設為 `"未知"`，`price` 預設為 `0`。在 `Main` 裡分別用兩種方式建立 `Book` 物件並印出資訊，確認兩種建構子都能正常運作。

---

### Q11. 挑戰題：銀行帳戶模擬
建立一個 `BankAccount` class：
- 屬性：`owner`（帳戶名稱）、`balance`（餘額，double）
- 建構子：傳入 `owner`，`balance` 一律從 0 開始
- method `deposit(double amount)`：存錢，把 `amount` 加進 `balance`
- method `withdraw(double amount)`：領錢，如果 `amount` 大於 `balance`，印出「餘額不足」，不執行扣款；否則扣款成功
- method `showBalance()`：印出目前餘額

在 `Main` 裡建立一個帳戶，測試存錢、領錢（包含餘額不足的情況）、查詢餘額。

---

## 參考答案

<details>
<summary>點我展開答案（寫完再看喔！）</summary>

**A1.** Class 是設計圖，定義了資料跟行為的規則；Object 是根據設計圖實際建立出來的東西，每個都有自己獨立的資料。舉例（參考答案）：「手機的設計規格」是 Class（規定要有品牌、型號、能打電話），實際店裡賣的每一支手機是 Object（一支黑色的 iPhone、一支白色的 iPhone，各自獨立）。

**A2.** `name = name;` 跟 `age = age;` 都是把**參數指派給參數自己**（Java 優先抓最近的變數，也就是參數），並沒有真正把值存進屬性裡。建構子跑完，這個物件的屬性 `name` 和 `age` 其實還是預設值（`null` 和 `0`）。應該改成 `this.name = name;` 和 `this.age = age;`，明確指定左邊是屬性。

**A3.** 印出 `0`。因為 `Counter` 沒有寫建構子，Java 會提供預設建構子，屬性 `count` 是 `int`，沒賦值時的預設值就是 `0`。

**A4.** `square(int n)` 有 `static`，屬於「class 本身」，呼叫方式是 `ClassName.square(5)`，不需要建立物件。`bark()` 沒有 `static`，屬於「物件」，必須先 `new` 出一個物件，用 `物件名稱.bark()` 才能呼叫。

**A5.** 不會。只要 class 自己寫了任何一個建構子（不管有沒有參數），Java 就不會再提供預設建構子。如果想要「無參數版本」也能用，必須自己額外再寫一個無參數的建構子（利用 Overloading）。

**A6.**
```java
public class Book {
    String title;
    String author;
    double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("書名: " + title + ", 作者: " + author + ", 價格: " + price);
    }
}

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java入門", "王小明", 350.0);
        Book book2 = new Book("演算法解析", "陳大華", 480.0);

        book1.printInfo();
        book2.printInfo();
    }
}
```

**A7.**
```java
public class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public boolean isPassing() {
        return score >= 60;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("小美", 85);
        Student s2 = new Student("小強", 45);

        System.out.println(s1.name + " 及格嗎: " + s1.isPassing());
        System.out.println(s2.name + " 及格嗎: " + s2.isPassing());
    }
}
```

**A8.** 兩個問題：
1. `name = name;` 和 `price = price;` 沒有用 `this`，參數只是指派給自己，屬性沒有被真正賦值。應改成 `this.name = name;` 和 `this.price = price;`。
2. `void showPrice()` 沒有加 `public`，雖然在同一個資料夾能動，但業界慣例建議明確標示權限修飾詞，避免之後搬到不同 package 時出問題。

修正後：
```java
public class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void showPrice() {
        System.out.println(name + " 價格: " + price);
    }
}
```

**A9.**
```java
public class Fruit {
    String name;
    double price;

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[3];
        fruits[0] = new Fruit("蘋果", 25.0);
        fruits[1] = new Fruit("香蕉", 15.0);
        fruits[2] = new Fruit("橘子", 20.0);

        for (Fruit fruit : fruits) {
            System.out.println(fruit.name + ": " + fruit.price + " 元");
        }
    }
}
```

**A10.**
```java
public class Book {
    String title;
    String author;
    double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(String title) {
        this(title, "未知", 0);
    }

    public void printInfo() {
        System.out.println("書名: " + title + ", 作者: " + author + ", 價格: " + price);
    }
}

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java入門", "王小明", 350.0);
        Book book2 = new Book("神秘書籍");

        book1.printInfo();
        book2.printInfo();
    }
}
```

**A11.**
```java
public class BankAccount {
    String owner;
    double balance;

    public BankAccount(String owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("存款成功，存入: " + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("餘額不足");
        } else {
            balance -= amount;
            System.out.println("提款成功，提出: " + amount);
        }
    }

    public void showBalance() {
        System.out.println(owner + " 的餘額: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("小明");
        account.showBalance();
        account.deposit(1000);
        account.showBalance();
        account.withdraw(300);
        account.showBalance();
        account.withdraw(5000); // 餘額不足
        account.showBalance();
    }
}
```

</details>