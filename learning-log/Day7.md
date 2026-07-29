# Java — Day 7 筆記

## Inheritance 繼承 + extends

### 為什麼需要繼承

如果 `Dog` 跟 `Cat` 有大量重複的屬性和 method（`name`、`age`、`eat()`、`sleep()`），只有少數地方不一樣，**繼承**就是用來解決這種「共同特徵重複寫」的問題。

### 父類別（Parent/Super class）與子類別（Child/Sub class）

把共同的部分抽出來，寫成一個「父類別」，讓其他 class 去**繼承**它：

```java
// 父類別
public class Animal {
    protected String name; // protected，子類別可以直接使用
    private int weight;    // private，子類別不能直接使用

    public void eat() {
        System.out.println(name + " 正在吃東西");
    }

    public void sleep() {
        System.out.println(name + " 正在睡覺");
    }
}
```

```java
// 子類別，用 extends 繼承 Animal
public class Dog extends Animal {
    public void bark() {
        System.out.println(name + " 說: 汪汪!");
    }
}
```

`Dog extends Animal` 的意思是：`Dog` 繼承了 `Animal` 的所有東西（`name`、`eat()`、`sleep()`），不用重新寫一次，再自己額外新增專屬於狗的東西（`bark()`）。

### protected 在繼承中的角色

- 屬性設 `private` → 連子類別都不能直接存取
- 屬性設 `protected` → 父類別、同 package、**以及子類別**都可以直接存取

所以繼承關係中，父類別如果希望子類別可以直接使用某個屬性，通常會設成 `protected`，而不是 `private`。

### 繼承的規則重點

1. Java 只支援**單一繼承**：一個 class 只能 `extends` 一個父類別
2. 但可以**多層繼承**：`A extends B`，`B extends C`
3. 子類別繼承的是父類別 `public` 和 `protected` 的成員，`private` 的不會被繼承

---

## super

如果 `Animal` 有建構子，子類別要怎麼處理？這就是 `super` 要解決的問題。

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
        super(name);      // 呼叫父類別的建構子
        this.breed = breed;
    }
}
```

- **重要規則**：`super(...)` 必須是建構子的**第一行**
- 如果沒有手動寫 `super(...)`，Java 會**自動幫你補上 `super()`**（呼叫父類別的無參數建構子）——但這只有在父類別有無參數建構子時才行得通；如果父類別只有「需要參數」的建構子，子類別就**必須**自己明確寫 `super(參數)`，否則編譯錯誤
- `super` 的另一個用法：呼叫父類別的 method，例如 `super.eat();`

---

## Method Override（覆寫）

子類別重新定義一個跟父類別「一模一樣簽名」的 method，讓它有不同的行為。

### Override 的規則：方法簽名必須完全一致

「方法簽名」指的是：method 名稱 + 參數列表必須跟父類別一模一樣，回傳型態也要相容。如果寫得不一樣，Java 不會當作是 Override，而是變成一個新的、不相關的 method（甚至可能是不小心多載了一個）。

### @Override 註解：不是必要，但一定要加

```java
@Override
public void eat() {
    System.out.println(name + " 正在吃狗飼料");
}
```

`@Override` 這行本身不影響程式執行，但它的作用是：讓編譯器幫你檢查，這個 method 是不是真的有成功覆寫到父類別的東西。如果你手滑打錯字（例如把 `eat` 打成 `eatt`），沒加 `@Override` 的話，Java 只會覺得你在 `Dog` 裡新增了一個叫 `eatt` 的全新 method，不會有任何錯誤警告，但你原本想覆寫 `eat()` 的意圖就完全沒有生效，這個 bug 會很難發現。加了 `@Override`，如果拼錯字或簽名對不上，編譯器會直接報錯提醒你。

### Override 的存取權限規則

覆寫時，子類別的存取權限**不能比父類別更嚴格**（可以一樣或更寬鬆）

### 結合 super：在覆寫的版本裡，還想保留父類別原本的行為

```java
@Override
public void eat() {
    super.eat(); // 先執行父類別原本的行為
    System.out.println("狗狗還吃得津津有味"); // 再加上自己額外的內容
}
```

---

## Polymorphism 多型

用「父類別」的型態，去指向「子類別」的物件，讓同一段程式碼，可以根據實際物件的不同，自動執行不同的行為。

```java
Animal animal1 = new Dog("小白"); // 型態寫 Animal，但實際建立的是 Dog
animal1.eat(); // 會執行 Dog 覆寫過的版本，不是 Animal 籠統的版本
```

### 向上轉型（Upcasting）

`Dog` 是 `Animal` 的子類別，`Dog` 本質上也是一種 `Animal`。所以可以用 `Animal` 這個比較「籠統」的型態，去裝一個 `Dog` 物件，這叫做**向上轉型**，是安全、自動發生的，不需要特別寫轉型語法。

### 多型的威力：用陣列/迴圈統一處理一群不同的物件

```java
Animal[] animals = new Animal[3];
animals[0] = new Dog("小白");
animals[1] = new Cat("咪咪");
animals[2] = new Dog("阿黃");

for (Animal a : animals) {
    a.eat(); // 不管實際是Dog還是Cat，都自動執行對應覆寫過的版本
}
```

完全不需要寫 `if/else` 判斷「這是狗還是貓」，呼叫端統一呼叫 `a.eat()` 就好，Java 會自動處理該執行哪個版本。

### 重要限制

用父類別型態宣告時，**只能呼叫父類別裡有定義的 method**：

```java
Animal animal1 = new Dog("小白");
animal1.eat();  // ✅ Animal 有定義
animal1.bark(); // ❌ 編譯錯誤！Animal 沒有 bark()，即使實際物件是Dog也不行
```

---

## instanceof

上一節提到：用 `Animal` 型態的變數，只能呼叫 `Animal` 裡定義過的方法，就算實際物件是 `Dog`，也不能直接呼叫 `bark()`。`instanceof` 就是用來解決這個限制的工具。

### instanceof：檢查物件的實際型態

```java
Animal animal1 = new Dog("小白");
System.out.println(animal1 instanceof Dog); // true
System.out.println(animal1 instanceof Cat); // false
```

### 向下轉型（Downcasting）：把父類別型態換回子類別型態

```java
if (animal1 instanceof Dog) {
    Dog dog1 = (Dog) animal1; // 強制轉回 Dog 型態
    dog1.bark();
}
```

⚠️ 沒檢查就硬轉型，會拋出 `ClassCastException`（執行時錯誤），所以永遠要**先 `instanceof` 確認，再轉型**。

### Java 14+ 新寫法：Pattern Matching for instanceof（推薦）

```java
if (animal1 instanceof Dog dog1) { // 檢查同時完成轉型
    dog1.bark();
}
```