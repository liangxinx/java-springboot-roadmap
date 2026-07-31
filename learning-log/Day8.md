# Java — Day 8 筆記

## Interface（介面）

Interface 定義的是「這個東西必須能做到什麼」，但**不提供具體怎麼做**。可以想成一份「合約」：任何 class 只要簽了這份合約（實作這個 interface），就保證會提供合約上規定的所有方法。

### 基本語法

```java
public interface Flyable {
    void fly(); // 只有方法簽名，沒有方法內容（沒有大括號 { }）
}
```

- 用 `interface` 關鍵字（不是 `class`）
- 裡面的方法只寫簽名，不寫實作內容（連 `{}` 都沒有，直接用分號結尾）
- 這代表「任何實作這個 interface 的 class，都必須自己提供 `fly()` 的具體內容」

### 用 implements 讓 class 實作 interface

```java
public class Duck implements Flyable {
    @Override
    public void fly() { // 必須提供 fly() 的具體實作，否則編譯錯誤
        System.out.println("鴨子拍打翅膀飛起來");
    }
}
```

`Duck implements Flyable` 的意思是：「`Duck` 保證會提供 `Flyable` 合約裡規定的所有方法」。如果 `Duck` 沒有寫 `fly()` 的內容，會直接編譯錯誤——這就是 Interface 的「強制力」。

> 一個 class 可以實作「多個」Interface（這就是解決單一繼承限制的關鍵）

### Interface 也能拿來做多型

```java
Flyable f = new Duck(); // 用 interface 型態，裝一個實作它的物件
f.fly(); // 呼叫 Duck 實際實作的版本
```

這跟「用父類別型態裝子類別物件」的多型概念一模一樣，只是這次「父類別」換成了「interface」。

### 為什麼 Interface 不能寫實作內容

Interface 裡「什麼都不能寫」正是它的重點——它不提供實作，只強制規定「有這個能力」，用意是讓一群原本毫無關係的 class，可以被貼上同一個標籤（型態），進而享受多型的好處。如果 Interface 也能寫實作內容，那它就沒辦法達成這個「統一標籤」的效果了（這也是為什麼傳統上規定它不能有實作內容）。

---

## Abstract Class（抽象類別）

### 基本語法

```java
public abstract class Animal { // class前面加abstract
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sleep() { // 一般方法，有實作內容
        System.out.println(name + " 正在睡覺");
    }

    public abstract void makeSound(); // 抽象方法：只有簽名，沒有內容
}
```

- **抽象類別的核心規則：不能直接 `new`**
- **子類別必須實作所有抽象方法**，否則子類別本身也會被視為抽象的，一樣不能 `new`

```java
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() { // 必須實作
        System.out.println(name + " 說: 汪汪!");
    }
}
```

### Abstract Class vs Interface 對比

| | Abstract Class | Interface |
|---|---|---|
| 關鍵字 | `abstract class` + `extends` | `interface` + `implements` |
| 一個 class 能有幾個 | 只能繼承一個 | 可以實作多個 |
| 可以有一般方法（含實作內容）嗎 | ✅ 可以 | 傳統上不行（現代 Java 有例外，之後有機會再提） |
| 可以有屬性嗎 | ✅ 可以（`protected`、`private` 都行） | 只能是 `public static final` 常數 |
| 建構子 | ✅ 可以有 | ❌ 不能有 |
| 表達的關係 | "是一種"，且有共同的部分實作邏輯 | "具備某種能力"，通常來自不相關的類別 |
| 適合的情境 | 一群東西本質上很相似，有共用邏輯，只有少部分行為不同 | 一群東西彼此不相關，但都需要具備某個特定能力 |

### 判斷原則（實務上怎麼選）

- 如果子類別之間血緣關係很近（都是「動物」的一種），而且有共用的邏輯可以寫在父類別裡 → 用 **Abstract Class**
- 如果一群東西彼此完全不相關，只是剛好都需要具備某個能力 → 用 **Interface**
- 兩者也可以同時使用：一個 class 可以 `extends` 一個 abstract class，同時 `implements` 多個 interface

---

## Exception（例外）

Exception 是指程式執行過程中發生的非預期狀況，導致程式無法繼續正常執行下去。

- **Unchecked Exception（執行時期例外）**：編譯器不會強制你一定要處理，程式可以編譯過，但執行時如果真的發生就會當掉（例如陣列越界、除以0）
- **Checked Exception（受檢例外）**：編譯器會強制你一定要處理（用 try/catch 或宣告 throws），否則直接編譯不過，常見於檔案讀寫、網路連線這類「本來就預期可能會失敗」的操作

---

## try / catch

```java
try {
    // 可能會出錯的程式碼
} catch (例外型態 變數名稱) {
    // 如果 try 裡面真的出錯了，跳來這裡執行
}
```

### 例外物件常用的方法

```java
catch (ArithmeticException e) {
    System.out.println(e.getMessage()); // 取得錯誤訊息文字
    e.printStackTrace(); // 印出完整的錯誤追蹤路徑（除錯時很有用）
}
```

> 更好的做法是盡量寫明確的例外型態（例如 `ArrayIndexOutOfBoundsException`），這樣可以針對不同錯誤給出更精確的處理，而不是全部混在一起用一句籠統的話帶過。

### 常見 Exception 分類

**🔢 數值運算類**
- `ArithmeticException`（除以0等數學錯誤）
- `NumberFormatException`（字串轉數字失敗）

**📦 陣列 / 索引類**
- `ArrayIndexOutOfBoundsException`（陣列越界）
- `StringIndexOutOfBoundsException`（字串索引越界，例如 `.charAt()` 給錯位置）

**🕳️ 空值類**
- `NullPointerException`（物件是 `null` 卻被使用）

**🔄 型態轉換類**
- `ClassCastException`（向下轉型失敗）

**⌨️ 使用者輸入類**
- `InputMismatchException`（Scanner 讀取格式不符）
- `NumberFormatException`（也常跟輸入處理有關，例如讀一整行文字再手動轉數字時打錯）

---

## finally

`try/catch` 已經學會「出錯時要做什麼」，但如果有一段程式碼**不管有沒有出錯，都一定要執行**呢？例如「不管檔案讀取成功還是失敗，最後都要把檔案關閉」——這就是 `finally` 要解決的問題。

```java
try {
    // 可能出錯的程式碼
} catch (例外型態 e) {
    // 出錯時執行
} finally {
    // 不管有沒有出錯，最後都一定會執行
}
```

### 為什麼需要 finally：典型使用情境

`finally` 最常見的用途是**資源清理**——例如開啟檔案、建立資料庫連線、開啟網路連線，這些「用完一定要記得關閉」的資源，不管程式執行過程中有沒有出錯，都應該要確保被關閉，避免資源一直被佔用。

> 沒有 `finally` 也完全合法，`finally` 只在真的有「不管如何都要執行的收尾動作」時才需要加。

---

## throws / throw

`throws`：明確宣告「這個 method 可能會丟出例外，但我不在這裡處理，交給呼叫我的人去處理」。`throw`：真正執行「丟出」這個例外的動作。

```java
public static double divide(double a, double b) {
    if (b == 0) {
        throw new ArithmeticException("除數不能是0"); // 主動丟出例外
    }
    return a / b;
}
```

呼叫端可以自己決定要不要用 try/catch 接住：

```java
try {
    double result = divide(10, 0);
} catch (ArithmeticException e) {
    System.out.println("計算錯誤: " + e.getMessage());
}
```

### try/catch vs throws：什麼時候用哪個

| | try/catch | throws |
|---|---|---|
| 誰負責處理 | 自己這個 method 內部處理掉 | 交給呼叫這個 method 的人處理 |
| 適合情境 | 這個 method 知道、也適合決定怎麼應對錯誤 | 這個 method 只負責偵測問題，不確定呼叫端想怎麼處理 |

實務上，這兩者常常會**搭配使用**：底層的 method 用 `throw` 往外丟，上層真正的進入點（例如 `main`）再用 `try/catch` 統一接住、決定怎麼呈現給使用者。

---

# SQL

`inner join` 是交集