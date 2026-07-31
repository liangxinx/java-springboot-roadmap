# Java 練習考題 — Day 9

## 第一部分：基礎觀念題

**Q1.** 下面這段程式碼會印出什麼？

```java
ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add("B");
System.out.println(list.size());
```
3

**Q2.** 承 Q1，如果把 `ArrayList` 換成 `HashSet`，`size()` 會變成多少？為什麼？
2

**Q3.** 下面這段程式碼會發生什麼事？

```java
HashMap<String, Integer> map = new HashMap<>();
map.put("apple", 10);
int value = map.get("banana");
System.out.println(value);
```
會錯

**Q4.** 情境判斷：下面四種需求，各自最適合用 `ArrayList`、`LinkedList`、`HashMap`、`HashSet` 哪一種？
1. 記錄一個網站今天有哪些不重複的 IP 造訪過  HashSet
2. 用商品條碼查詢商品價格  HashMap
3. 記錄使用者填寫問卷的所有答案（可能重複，且有填寫順序）ArrayList
4. 實作一個頻繁在佇列前端插入、刪除任務的工作排程器  LinkedList

**Q5.** `ArrayList` 取長度用什麼？`HashSet` 可以用索引取值嗎？
size   不可以

---

## 第二部分：動手寫程式

### Q6. ArrayList 基本操作
建立一個 `ArrayList<String>`，加入 5 個水果名稱。印出：
1. 完整清單
2. 清單長度
3. 移除第 3 個元素（索引2）後的清單
4. 判斷清單裡是否包含「芒果」

---

### Q7. HashMap 應用：單字計數器
寫一支程式，給定一個 `String[]` 陣列（例如 `{"apple", "banana", "apple", "orange", "banana", "apple"}`），用 `HashMap<String, Integer>` 統計每個單字出現的次數，最後印出每個單字跟它的出現次數。

提示：可以用 `getOrDefault()` 搭配 `put()`，例如：
```java
map.put(word, map.getOrDefault(word, 0) + 1);
```

---

### Q8. HashSet 去重練習
給定一個 `ArrayList<Integer>`，內容為 `{5, 3, 5, 8, 3, 1, 8, 9}`，用 `HashSet` 去除重複的數字，印出去重後的結果，以及總共有幾個不重複的數字。

---

### Q9. 找出程式碼的錯誤
下面這段程式碼有 **2 個問題**，請找出並修正：

```java
public class FindBug {
    public static void main(String[] args) {
        ArrayList<int> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);

        System.out.println(numbers.length());
    }
}
```

---

### Q10. 綜合挑戰：學生成績管理
延續今天教學的 `CollectionDemo` 範例，寫一支更完整的程式：
1. 用 `ArrayList<String>` 儲存 5 個學生姓名
2. 用 `HashMap<String, Integer>` 儲存每個學生對應的分數（自訂分數）
3. 用 `HashSet<String>` 記錄「及格」（60分以上）的學生姓名（用迴圈判斷分數後加入）
4. 最後印出：
   - 全班平均分數
   - 及格人數
   - 每個學生的姓名、分數、是否及格

---

### Q11. 挑戰題：找出兩個清單的共同元素
給定兩個 `ArrayList<String>`：
```java
ArrayList<String> classA = new ArrayList<>(); // 假設加入 "小明","小華","小美","小強"
ArrayList<String> classB = new ArrayList<>(); // 假設加入 "小華","小美","小林","小陳"
```
寫一支程式，找出「同時出現在兩個清單裡」的名字（提示：可以把其中一個轉成 `HashSet`，再用迴圈搭配 `.contains()` 判斷）。

---

## 參考答案

<details>
<summary>點我展開答案（寫完再看喔！）</summary>

**A1.** 印出 `3`。`ArrayList` 允許重複元素，`"B"` 被加入了兩次，都會被保留，所以清單裡有 A、B、B 共三個元素。

**A2.** 會變成 `2`。`HashSet` 會自動去除重複元素，`"B"` 加入兩次，第二次會被忽略，所以清單裡只有 A、B 兩個不重複的元素。

**A3.** 程式會拋出 `NullPointerException`。因為 `map` 裡沒有 `"banana"` 這個 key，`map.get("banana")` 會回傳 `null`，但 `value` 宣告的型態是 `int`（primitive type），`int` 沒辦法裝 `null`，所以在把 `null` 賦值給 `int` 型態的變數這一步就會出錯。應該改用 `map.getOrDefault("banana", 0)` 或先用 `containsKey()` 檢查。

**A4.**
1. `HashSet`（只在乎有沒有出現過，不能重複）
2. `HashMap`（用條碼當key，查詢對應的價格value）
3. `ArrayList`（允許重複答案，且需要保留填寫順序）
4. `LinkedList`（頻繁在頭尾新增刪除，很適合鏈狀結構）

**A5.** `ArrayList` 取長度用 `.size()`（method，有括號）。`HashSet` **不能**用索引取值，因為 `HashSet` 裡的元素沒有順序、沒有索引的概念，只能用 `.contains()` 判斷某個元素在不在裡面。

**A6.**
```java
import java.util.ArrayList;

public class ArrayListPractice {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("蘋果");
        fruits.add("香蕉");
        fruits.add("橘子");
        fruits.add("葡萄");
        fruits.add("西瓜");

        System.out.println("完整清單: " + fruits);
        System.out.println("清單長度: " + fruits.size());

        fruits.remove(2);
        System.out.println("移除後: " + fruits);

        System.out.println("包含芒果嗎: " + fruits.contains("芒果"));
    }
}
```

**A7.**
```java
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " 次");
        }
    }
}
```

**A8.**
```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class DedupDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 5, 8, 3, 1, 8, 9));

        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        System.out.println("原始: " + numbers);
        System.out.println("去重後: " + uniqueNumbers);
        System.out.println("不重複的數量: " + uniqueNumbers.size());
    }
}
```

**A9.** 兩個問題：
1. `ArrayList<int>` 編譯錯誤，泛型不能用 primitive type，應改成 `ArrayList<Integer>`
2. `numbers.length()` 編譯錯誤，`ArrayList` 沒有 `.length()`，應該用 `.size()`

修正後：
```java
public class FindBug {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);

        System.out.println(numbers.size());
    }
}
```

**A10.**
```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class StudentGradeManager {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("小明");
        students.add("小華");
        students.add("小美");
        students.add("小強");
        students.add("小林");

        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("小明", 85);
        scores.put("小華", 55);
        scores.put("小美", 92);
        scores.put("小強", 40);
        scores.put("小林", 70);

        HashSet<String> passedStudents = new HashSet<>();
        int totalScore = 0;

        for (String student : students) {
            int score = scores.getOrDefault(student, 0);
            totalScore += score;
            if (score >= 60) {
                passedStudents.add(student);
            }
        }

        double average = (double) totalScore / students.size();

        System.out.println("=== 學生成績單 ===");
        for (String student : students) {
            int score = scores.get(student);
            boolean passed = passedStudents.contains(student);
            System.out.println(student + " - 分數: " + score + ", 及格: " + passed);
        }

        System.out.println("全班平均: " + average);
        System.out.println("及格人數: " + passedStudents.size());
    }
}
```

**A11.**
```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class CommonElements {
    public static void main(String[] args) {
        ArrayList<String> classA = new ArrayList<>(Arrays.asList("小明", "小華", "小美", "小強"));
        ArrayList<String> classB = new ArrayList<>(Arrays.asList("小華", "小美", "小林", "小陳"));

        HashSet<String> setB = new HashSet<>(classB);

        System.out.println("共同出現的名字:");
        for (String name : classA) {
            if (setB.contains(name)) {
                System.out.println(name);
            }
        }
    }
}
```

</details>