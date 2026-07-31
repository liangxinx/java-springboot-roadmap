# Java — Day 9 筆記

## ArrayList

陣列有一個限制：長度一旦宣告就不能改變。如果你一開始不知道最終會有多少筆資料（例如使用者要新增幾筆訂單），陣列就很難用。**ArrayList 就是用來解決這個問題的——它是一個長度可以動態增減的「清單」。**

### 使用前要先 import

```java
import java.util.ArrayList;
```

### 宣告與建立

```java
ArrayList<String> names = new ArrayList<>();
```

- `ArrayList<String>`：宣告一個 ArrayList，裡面只能裝 `String`
- `<String>` 這種寫法叫**泛型（Generics）**，尖括號裡指定「這個容器裝什麼型態的東西」，之後可以換成 `<Integer>`、`<Dog>` 等等
- `new ArrayList<>()`：建立一個空的 ArrayList（後面的 `<>` 可以留空，Java 會自動判斷要跟前面一樣是 `String`）

> ⚠️ 重要規則：泛型只能用「物件型態」，不能用 primitive type。所以不能寫 `ArrayList<int>`，要用 `ArrayList<Integer>`（`Integer` 是 `int` 的「包裝類別 Wrapper Class」）

### 常用方法

```java
names.add("小明");        // 新增元素到最後面
names.get(0);              // 取得指定索引的元素
names.remove(1);           // 移除指定索引的元素
names.set(0, "阿明");      // 把指定索引的元素換成新值
names.contains("小美");    // 判斷是否包含某個元素
names.size();               // 取得元素數量（注意是 .size()，不是 .length）
names.clear();              // 清空整個清單
names.isEmpty();            // 判斷是否為空
ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 5, 8, 3, 1, 8, 9));//直接寫進去的陣列
```

---

## LinkedList

```java
import java.util.LinkedList;
```

### 背後結構的差異

- **ArrayList**：背後其實是用一個「陣列」在運作，元素是連續存放在記憶體裡的，就像一排連號的置物櫃
- **LinkedList**：背後是用「鏈條」的方式串起來，每個元素都記著「下一個元素在哪裡」，元素不需要連續存放，就像一條鎖鏈，一節接著一節

```
ArrayList（連續存放）:
[小明][小華][小美][小強]  ← 索引連號，直接跳到第N個很快

LinkedList（鏈狀串接）:
[小明]→[小華]→[小美]→[小強]  ← 要找到第N個，得從頭一個一個往後找
```

### 效能上的關鍵差異：什麼情況該選哪一個

| 操作 | ArrayList | LinkedList |
|---|---|---|
| 用索引直接取值 `.get(i)` | ⚡ 快，因為連續存放，直接算位置 | 🐢 慢，要從頭一個一個數過去 |
| 在最前面或最後面新增/刪除 | 🐢 較慢（尤其是最前面，因為後面全部要往前挪一格） | ⚡ 快，鏈條直接接上去/斷開就好 |
| 在中間新增/刪除 | 🐢 慢，中間以後的元素都要往前/往後挪位置 | ⚡ 相對快，只要改變鏈條的連接方式 |

### LinkedList 特有方法

```java
LinkedList<String> tasks = new LinkedList<>();
tasks.addFirst("晨會");   // 加到最前面
tasks.addLast("下班");     // 加到最後面
tasks.getFirst();           // 取得第一個
tasks.getLast();            // 取得最後一個
```

其餘用法（`.add()`、`.get()`、`.remove()`）跟 ArrayList 幾乎一模一樣，因為兩者都實作了同一個 `List` interface。

---

## HashMap

```java
import java.util.HashMap;
```

處理「用一個 key（鍵），對應到一個 value（值）」這種情境的資料結構。

前面學的 `ArrayList`、`LinkedList` 都是用索引（數字）去存取元素。但有時候你會想用「有意義的名稱」去查資料，而不是數字，例如：

- 想用「學號」查到「學生姓名」
- 想用「商品名稱」查到「價格」
- 想用「使用者帳號」查到「密碼」

### 常用方法

```java
HashMap<String, Integer> scores = new HashMap<>();

scores.put("小明", 85);              // 新增/更新一組key-value
scores.get("小明");                   // 用key取得value，查不到回傳null
scores.remove("小明");                // 移除指定key的整組資料
scores.containsKey("小明");           // 是否存在這個key
scores.containsValue(85);             // 是否存在這個value
scores.size();                         // 有幾組key-value
```

- `.getOrDefault(key, 預設值)`：這是 HashMap 的一個 method，作用是「用 key 去查 value，如果找不到，回傳一個你指定的預設值，而不是 `null`」，可以避免對 `null` 做運算導致 `NullPointerException`

### 遍歷 HashMap

```java
import java.util.Map;

for (Map.Entry<String, Integer> entry : scores.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

---

## HashSet

```java
import java.util.HashSet;
```

一種資料結構，**保證裡面的元素不會重複**，例如：「記錄有哪些使用者登入過系統」、「記錄有哪些商品被加入過購物車」——這種只在乎「這個東西存不存在」、不需要重複記錄的情境，就適合用 HashSet。

`.add()` 如果加入的元素已經存在，會直接被忽略，不會出現重複，也不會報錯。

> ⚠️ 注意：HashSet **沒有** `.get(index)` 這個方法！因為 HashSet 裡的元素沒有順序、沒有索引的概念，你只能問「這個東西在不在裡面」，不能問「第幾個是什麼」。

### 實用場景：快速去重

```java
ArrayList<String> withDuplicates = new ArrayList<>();
withDuplicates.add("小明");
withDuplicates.add("小明"); // 重複

HashSet<String> unique = new HashSet<>(withDuplicates); // 直接丟進去，自動去重
```

### HashSet vs ArrayList 對照表

| | ArrayList | HashSet |
|---|---|---|
| 允許重複元素 | ✅ 允許 | ❌ 自動去重 |
| 有順序（照加入順序排列） | ✅ 有 | ❌ 沒有固定順序 |
| 可以用索引存取 `.get(i)` | ✅ 可以 | ❌ 不行 |
| 適合情境 | 需要保留順序、允許重複、需要用索引查找 | 只在乎「有沒有」、需要保證不重複 |

---

## Collection 使用情境（總整理）

### 總表

| 資料結構 | 有順序 | 允許重複 | 用什麼存取 | 核心特性 |
|---|---|---|---|---|
| `ArrayList` | ✅ 有 | ✅ 允許 | 索引（數字） | 查找快、通用性最高 |
| `LinkedList` | ✅ 有 | ✅ 允許 | 索引（數字） | 頭尾新增/刪除快 |
| `HashMap` | ❌ 不保證 | key不可重複，value可重複 | key（有意義的名稱） | key-value 對應查找 |
| `HashSet` | ❌ 不保證 | ❌ 不允許 | 只能問「在不在」 | 自動去重 |

### 決策流程

**問題一：我需要「用名稱/鍵去查值」的對應關係嗎？**
是 → 用 `HashMap`（例如：學號查姓名、商品名稱查價格、帳號查密碼）

**問題二：我需要保證「不能有重複」嗎？**
是 → 用 `HashSet`（例如：記錄不重複的訪客IP、記錄使用者按過的標籤）

**問題三：我只是想要一份「有順序、可以重複」的清單嗎？**
是 → 用 `ArrayList`（預設優先選這個；例如：購物車商品清單、待辦事項清單）

**問題四：我會「非常頻繁」在清單開頭/中間新增刪除，很少用索引查找？**
是 → 才考慮 `LinkedList`（少數情況；例如：實作佇列 Queue、堆疊 Stack）

> **90% 的情況：先選 `ArrayList`，有特殊需求再換**