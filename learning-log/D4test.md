# Java 練習考題 — Day 4
---

## 第一部分：基礎觀念題

**Q1.** 下面這段程式碼會印出什麼？

```java
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");

System.out.println(s1 == s2);
System.out.println(s1 == s3);
System.out.println(s1.equals(s3));
```
t f t 

**Q2.** 下面這段程式碼哪裡有問題？執行結果會是什麼？

```java
String name = "hello world";
name.toUpperCase();
System.out.println(name);
```
沒有return回去 所以會印出沒改過的name

**Q3.** `"HelloWorld".substring(0, 5)` 會回傳什麼？請說明為什麼不是 `"HelloW"`。
hello 因為不包括5
**Q4.** 下面這段程式碼會不會出錯？如果會，是什麼錯誤？

```java
String input = null;
if (input.equals("stop")) {
    System.out.println("停止");
}
```
如果改成 `if ("stop".equals(input))`，結果會怎樣？
本來的會出錯 因為null不能呼叫equals
改了就不會報錯會出現 f

**Q5.** `Arrays.sort()` 執行完之後，原本傳進去的陣列會發生什麼事？
會排序然後改掉原本的陣列
---

## 第二部分：動手寫程式

### Q6. 字串基本操作
用 Scanner 讀取使用者輸入的一句話，印出：
1. 這句話的長度
2. 轉成全大寫
3. 去除頭尾空白後的版本

---

### Q7. 判斷回文（不分大小寫）
寫一個叫 `isPalindrome` 的 method，參數是 `String s`，回傳 `boolean`，判斷這個字串正著讀和反著讀是否相同（例如 "level"、"Level" 都算回文，不用管大小寫）。

提示：可以用 `StringBuilder` 的 `.reverse()` 幫忙，記得先把字串轉成同樣大小寫再比較。

---

### Q8. 字串切割練習
有一個字串 `"小明,20,175.5"`，代表姓名、年齡、身高，用逗號分隔。寫一支程式：
1. 用 `.split(",")` 切割
2. 把切割出來的年齡、身高分別轉成 `int` 和 `double`（提示：`Integer.parseInt()` 和 `Double.parseDouble()`，這是新方法，可以先查查看怎麼用）
3. 印出一句組合好的自我介紹句子

---

### Q9. 用 StringBuilder 組字串
寫一支程式，用 `StringBuilder` 和一個 `for` 迴圈，組出以下字串並印出：
```
1-2-3-4-5
```
（提示：迴圈跑 1 到 5，每個數字後面接 "-"，除了最後一個數字後面不用接）

---

### Q10. 找出程式碼的錯誤
下面這段程式碼有 **2 個問題**（不一定是編譯錯誤，也可能是邏輯錯誤），請找出並修正：

```java
public class FindBug {
    public static void main(String[] args) {
        String status = "完成";

        if (status == "完成") {
            System.out.println("任務已完成");
        }

        int[] scores = {85, 92, 78, 65, 90};
        Arrays.sort(scores);
        System.out.println("最高分: " + scores[0]);
    }
}
```

---

### Q11. Arrays 綜合練習
寫一支程式：
1. 建立一個 `int[]` 陣列，內容為 `{45, 12, 78, 3, 99, 27}`
2. 用 `Arrays.toString()` 印出原始陣列
3. 用 `Arrays.sort()` 排序後印出
4. 用 `Arrays.copyOf()` 複製一份長度為 3 的陣列（只保留排序後最小的三個），印出結果

---

### Q12. 挑戰題：計算某字元出現次數
寫一個叫 `countChar` 的 method，參數是 `String text` 和 `char target`，回傳這個字元在字串中出現的次數（不分大小寫）。

例如 `countChar("Hello World", 'o')` 應該回傳 `2`。

提示：可以用 `for` 迴圈搭配 `.charAt(i)` 逐一檢查，記得比較前先統一轉成同樣大小寫。

---

## 參考答案

<details>
<summary>點我展開答案（寫完再看喔！）</summary>

**A1.**
```
true
false
true
```
`s1` 跟 `s2` 都是雙引號直接寫的字串，會共用字串池裡同一個物件，所以 `==` 是 `true`。`s3` 用 `new String()` 強制建立新物件，`==` 比較的是不同記憶體位置，所以 `false`。`.equals()` 一律比較內容，所以是 `true`。

**A2.** `name.toUpperCase()` 這行呼叫了 method，但**沒有把回傳值存起來**，所以這行等於白做了。`String` 是不可變的，原本的 `name` 完全沒有被改變。執行結果會印出 `hello world`（還是原本的小寫）。正確寫法應該是 `name = name.toUpperCase();` 或用另一個變數接住。

**A3.** 會回傳 `"Hello"`。`substring(start, end)` 是**不包含 end 那個索引**的，索引 0 到 4（共5個字元 H-e-l-l-o）就是 `"Hello"`，索引 5 的 `W` 不會被包含進去。

**A4.** 第一段會出錯，因為 `input` 是 `null`，呼叫 `input.equals(...)` 會拋出 `NullPointerException`（在還沒 null 的物件上呼叫 method 才行）。改成 `"stop".equals(input)` 後，因為 `"stop"` 這個字串本身不是 null，可以安全呼叫 `.equals()`，即使 `input` 是 `null`，也只會回傳 `false`，不會出錯。

**A5.** `Arrays.sort()` 會**直接修改原本傳進去的陣列**，讓它變成排序後的順序，不會回傳一個新的陣列，也不會保留原本未排序的版本。

**A6.**
```java
import java.util.Scanner;

public class StringPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入一句話：");
        String sentence = scanner.nextLine();

        System.out.println("長度: " + sentence.length());
        System.out.println("大寫: " + sentence.toUpperCase());
        System.out.println("去空白: '" + sentence.trim() + "'");
    }
}
```

**A7.**
```java
public class PalindromeChecker {

    public static boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        String reversed = new StringBuilder(lower).reverse().toString();
        return lower.equals(reversed);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("level"));  // true
        System.out.println(isPalindrome("Level"));  // true
        System.out.println(isPalindrome("hello"));  // false
    }
}
```

**A8.**
```java
public class SplitDemo {
    public static void main(String[] args) {
        String data = "小明,20,175.5";
        String[] parts = data.split(",");

        String name = parts[0];
        int age = Integer.parseInt(parts[1]);
        double height = Double.parseDouble(parts[2]);

        System.out.println("我叫" + name + "，今年" + age + "歲，身高" + height + "公分");
    }
}
```

**A9.**
```java
public class BuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 5; i++) {
            sb.append(i);
            if (i < 5) {
                sb.append("-");
            }
        }

        System.out.println(sb.toString()); // 1-2-3-4-5
    }
}
```

**A10.** 兩個問題：
1. `status == "完成"` 用 `==` 比較字串內容不可靠，應改成 `status.equals("完成")`（這題剛好因為字串池關係可能會印出正確結果，但寫法本身是錯誤的，不應該依賴這種巧合）。
2. 缺少 `import java.util.Arrays;`，會編譯錯誤。另外邏輯上 `Arrays.sort()` 是由小到大排序，`scores[0]` 排序後會是**最低分**，不是最高分，如果要拿最高分應該是 `scores[scores.length - 1]`。

修正後：
```java
import java.util.Arrays;

public class FindBug {
    public static void main(String[] args) {
        String status = "完成";

        if (status.equals("完成")) {
            System.out.println("任務已完成");
        }

        int[] scores = {85, 92, 78, 65, 90};
        Arrays.sort(scores);
        System.out.println("最高分: " + scores[scores.length - 1]);
    }
}
```

**A11.**
```java
import java.util.Arrays;

public class ArraysPractice {
    public static void main(String[] args) {
        int[] nums = {45, 12, 78, 3, 99, 27};
        System.out.println("原始: " + Arrays.toString(nums));

        Arrays.sort(nums);
        System.out.println("排序後: " + Arrays.toString(nums));

        int[] smallestThree = Arrays.copyOf(nums, 3);
        System.out.println("最小三個: " + Arrays.toString(smallestThree));
    }
}
```

**A12.**
```java
public class CountChar {

    public static int countChar(String text, char target) {
        String lowerText = text.toLowerCase();
        char lowerTarget = Character.toLowerCase(target);
        int count = 0;

        for (int i = 0; i < lowerText.length(); i++) {
            if (lowerText.charAt(i) == lowerTarget) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countChar("Hello World", 'o')); // 2
        System.out.println(countChar("Hello World", 'L')); // 3
    }
}
```

</details>