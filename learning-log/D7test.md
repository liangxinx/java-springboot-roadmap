# Java 練習考題 — Day 7

---

## 第一部分：基礎觀念題

**Q1.** 下面這段程式碼會編譯錯誤，請說明原因並修正：

```java
public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}

public class Dog extends Animal {
    private String breed;

    public Dog(String name, String breed) {
        spuer(name)
        this.breed = breed; // 沒有呼叫 super
    }
}
```

**Q2.** 下面這段程式碼，哪一個是 Override，哪一個只是普通的新方法（甚至可能編譯錯誤）？請說明原因。

```java
public class Animal {
    public void makeSound() {
        System.out.println("動物叫聲");
    }
}

public class Dog extends Animal {
    // 版本A
    public void makeSound() {
        System.out.println("汪汪");
    }

    // 版本B（假設這是另一個獨立的Dog class）
    public void makeSound(String volume) {
        System.out.println("汪汪，音量: " + volume);
    }
}
```

**Q3.** 下面這段程式碼會印出什麼？請說明為什麼。

```java
public class Animal {
    public void speak() {
        System.out.println("動物發出聲音");
    }
}

public class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("狗說汪汪");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.speak();
    }
}
```

狗說汪汪

**Q4.** 承 Q3 的 `Dog` class，如果新增一個 `Dog` 專屬的方法 `fetch()`，下面這行會不會編譯錯誤？為什麼？

```java
Animal a = new Dog();
a.fetch();
```
會錯 因為aninmal裡面沒有fetch

**Q5.** 沒有先用 `instanceof` 檢查就直接向下轉型，會發生什麼事？請舉例說明。

. 會拋出 ClassCastException（執行時錯誤）

---

## 第二部分：動手寫程式

### Q6. 建立基礎的繼承關係
建立一個 `Shape`（形狀）父類別，屬性 `name`（String），建構子傳入 `name`，有一個 `void draw()` method，印出「畫一個 [name]」。

建立 `Circle` 和 `Square` 兩個子類別繼承 `Shape`，建構子呼叫 `super(name)`，並且**覆寫** `draw()`，各自印出更具體的訊息（例如「畫一個圓形，用圓規」、「畫一個正方形，用尺」）。

在 `Main` 裡分別建立這兩個物件並呼叫 `draw()`。

---

### Q7. super 呼叫父類別方法練習
延續 Q6，讓 `Circle` 的 `draw()` 在印出自己的訊息**之前**，先呼叫 `super.draw()`（印出父類別原本那句「畫一個 [name]」），再印出自己額外的內容。

---

### Q8. 多型陣列練習
延續 Q6、Q7，在 `Main` 裡建立一個 `Shape[]` 陣列，裡面放 2 個 `Circle` 和 2 個 `Square`（順序自訂），用 `for-each` 迴圈呼叫每個物件的 `draw()`，確認每個都印出各自覆寫過的版本。

---

### Q9. instanceof 練習
延續 Q8 的陣列，在同一個迴圈裡，用 `instanceof`（可以用 Java 14+ 的新寫法）判斷：如果是 `Circle`，額外印出「這是圓形」；如果是 `Square`，額外印出「這是正方形」。

---

### Q10. 找出程式碼的錯誤
下面這段程式碼有 **2 個問題**，請找出並修正：

```java
public class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void honk() {
        System.out.println(brand + " 按喇叭");
    }
}

public class Car extends Vehicle {
    private int doors;

    public Car(String brand, int doors) {
        this.doors = doors;
    }

    private void honk() {
        System.out.println(brand + " 汽車按喇叭，共有" + doors + "個門");
    }
}
```

---

### Q11. 挑戰題：員工薪資系統（綜合應用）
建立一個 `Employee` 父類別：
- `protected` 屬性：`name`、`baseSalary`（底薪，double）
- 建構子傳入兩者
- `double calculateSalary()` method：回傳 `baseSalary`（一般員工薪水就是底薪）

建立 `Manager` 子類別繼承 `Employee`：
- 額外屬性：`bonus`（獎金，double）
- 建構子多接收 `bonus`，用 `super(...)` 處理 `name`、`baseSalary`
- **覆寫** `calculateSalary()`，回傳 `baseSalary + bonus`

建立 `Intern`（實習生）子類別繼承 `Employee`：
- 建構子只傳入 `name`，`baseSalary` 固定是 `20000`（用 `super(name, 20000)`）
- 不用覆寫 `calculateSalary()`（沿用父類別的邏輯即可）

在 `Main` 裡：
1. 建立一個 `Employee[]` 陣列，放 1 個 `Manager`、1 個一般 `Employee`、1 個 `Intern`
2. 用 for-each 迴圈，印出每個人的名字和 `calculateSalary()` 的結果
3. 用 `instanceof` 判斷，如果是 `Manager`，額外印出「這位是主管，獎金是 [bonus]」

---

## 參考答案

<details>
<summary>點我展開答案（寫完再看喔！）</summary>

**A1.** `Dog` 的建構子沒有呼叫 `super(name)`，而 `Animal` 只有一個「需要參數」的建構子，沒有無參數版本可以讓 Java 自動補上 `super()`，所以編譯錯誤。修正：
```java
public Dog(String name, String breed) {
    super(name);
    this.breed = breed;
}
```

**A2.** 版本A是合法的 **Override**：方法名稱 `makeSound`、參數列表（無參數）跟父類別完全一致。版本B**不是 Override**，因為參數列表不同（多了一個 `String volume`），這其實是在 `Dog` 裡新增了一個獨立的 Overloading 方法，跟父類別的 `makeSound()` 沒有覆寫關係，兩個方法會同時存在。

**A3.** 印出 `狗說汪汪`。雖然 `a` 宣告的型態是 `Animal`，但實際物件是 `new Dog()`，多型會讓 `a.speak()` 執行**實際物件（Dog）覆寫過的版本**，而不是 `Animal` 原本的版本。

**A4.** 會編譯錯誤。因為 `a` 宣告的型態是 `Animal`，編譯器只認得 `Animal` 裡定義過的方法，`fetch()` 是 `Dog` 專屬的方法，`Animal` 沒有，所以即使 `a` 實際上是 `Dog`，也不能直接用 `a.fetch()` 呼叫，必須先用 `instanceof` 確認並轉型成 `Dog` 才能呼叫。

**A5.** 會拋出 `ClassCastException`（執行時錯誤），程式會直接當掉。例如：
```java
Animal a = new Cat("咪咪");
Dog d = (Dog) a; // ❌ ClassCastException，因為a實際上是Cat，不是Dog
```
正確做法應該先用 `instanceof` 確認 `a` 真的是 `Dog`，才進行轉型。

**A6.**
```java
public class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public void draw() {
        System.out.println("畫一個 " + name);
    }
}

public class Circle extends Shape {
    public Circle(String name) {
        super(name);
    }

    @Override
    public void draw() {
        System.out.println("畫一個圓形，用圓規");
    }
}

public class Square extends Shape {
    public Square(String name) {
        super(name);
    }

    @Override
    public void draw() {
        System.out.println("畫一個正方形，用尺");
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle("圓形");
        Square s = new Square("正方形");
        c.draw();
        s.draw();
    }
}
```

**A7.**
```java
public class Circle extends Shape {
    public Circle(String name) {
        super(name);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("畫一個圓形，用圓規");
    }
}
```
輸出會是：
```
畫一個 圓形
畫一個圓形，用圓規
```

**A8.**
```java
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle("圓形1");
        shapes[1] = new Square("正方形1");
        shapes[2] = new Circle("圓形2");
        shapes[3] = new Square("正方形2");

        for (Shape s : shapes) {
            s.draw();
        }
    }
}
```

**A9.**
```java
for (Shape s : shapes) {
    s.draw();

    if (s instanceof Circle) {
        System.out.println("這是圓形");
    } else if (s instanceof Square) {
        System.out.println("這是正方形");
    }
}
```

**A10.** 兩個問題：
1. `Car` 的建構子沒有呼叫 `super(brand)`，`brand` 這個屬性完全沒被賦值，`Vehicle` 只有需要參數的建構子，沒有無參數版本可以讓 Java 自動補。
2. `Car` 覆寫 `honk()` 時把權限從 `public`（父類別）縮小成 `private`，違反 Override 規則（不能比父類別更嚴格），會編譯錯誤。

修正後：
```java
public class Car extends Vehicle {
    private int doors;

    public Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
    }

    @Override
    public void honk() {
        System.out.println(brand + " 汽車按喇叭，共有" + doors + "個門");
    }
}
```

**A11.**
```java
public class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }
}

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    public double getBonus() {
        return bonus;
    }
}

public class Intern extends Employee {
    public Intern(String name) {
        super(name, 20000);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Manager("王經理", 50000, 15000);
        employees[1] = new Employee("陳員工", 35000);
        employees[2] = new Intern("小李");

        for (Employee e : employees) {
            System.out.println(e.name + " 的薪水: " + e.calculateSalary());

            if (e instanceof Manager manager) {
                System.out.println("這位是主管，獎金是 " + manager.getBonus());
            }
        }
    }
}
```

</details>