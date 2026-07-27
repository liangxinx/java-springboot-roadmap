# Java — Day 5 筆記

## Class 類別 vs Object 物件

- **Class（類別）**：是一張「設計圖」或「模板」，定義了「這種東西會有哪些屬性、能做哪些事」，但它本身不是真實存在的東西
- **Object（物件）**：是根據 Class 這張設計圖，實際做出來的東西，是真實存在、可以使用的實體

### 生活化例子

「車子的設計圖」跟「實際的一台車」：

- **Class** = 車子設計圖（規定：每台車都要有顏色、品牌、能發動、能煞車）
- **Object** = 根據設計圖做出來的實際車輛（一台紅色的 Toyota、一台藍色的 BMW），每一台都是分開的實體，顏色可以不一樣，但都遵循同一張設計圖的規則

### 承接程式碼 Dog

```java
public class Dog {
    String name;
    int age;

    void bark() {
        System.out.println(name + " 說: 汪汪!");
    }
}
```

---

## 屬性與方法

### 為什麼 `bark()` 沒有 `static`？

- **有 `static` 的 method**：屬於「class 本身」，不需要建立物件就能呼叫，例如之前寫的 `add(a, b)` 這種工具型 method
- **沒有 `static` 的 method**：屬於「每一個物件」，必須先 `new` 出一個物件，才能呼叫這個 method

---

## Constructor 建構子

每次要建立一個物件，都要手動一行一行把屬性填進去，很囉嗦，而且容易漏填。**Constructor（建構子）** 可以讓你在 `new` 的當下，就一次把所有初始資料傳進去。

建構子長得很像 method，但有兩個關鍵特徵：

1. 名稱必須跟 class 名稱完全一樣
2. 沒有回傳型態（連 `void` 都不寫）

---

## this 關鍵字

### this 的作用：明確指出「我是指這個物件自己的屬性」

`this` 代表「當前這個正在被建立/操作的物件本身」。用 `this.屬性名稱`，可以明確告訴 Java：我要指的是屬性，不是參數。

---

## Instance Variable（實例變數）

**Instance Variable** 就是寫在 class 裡面、但在任何 method（包括建構子）**外面**的變數。它是「屬性」的正式名稱：

```java
public class Dog {
    String name;  // Instance Variable
    int age;      // Instance Variable
    String breed; // Instance Variable
}
```