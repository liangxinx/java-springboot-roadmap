# Java 練習考題 — Day 1
---

## 第一部分：基礎觀念題（不用寫程式，用想的或口頭回答）

**Q1.** 下面這段程式碼有一個錯誤，請找出來並說明為什麼錯：

```java
public class Student {
    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}
```
檔案名稱是 `Hello.java`。

class名稱要跟檔名一樣 所以要改成Hello

**Q2.** `int`、`double`、`boolean`、`char` 這四個型態，請各自舉一個生活中適合用它們儲存的例子（例如：`int` 可以儲存「一個人的年齡」）。

int 歲數  double 身高  boolean 是否已結婚  char 成績例如ABC

**Q3.** 下面兩行程式碼哪一個會出錯？為什麼？

```java
char grade = 'A';
char grade2 = "A";
```

第二個因為不能用"

---

## 第二部分：動手寫程式

### Q4. 自我介紹小程式
寫一支程式，宣告以下變數並印出一句完整的自我介紹句子：
- `name`（String，你的名字）
- `age`（int）
- `height`（double，身高）
- `isStudent`（boolean）

輸出範例：
```
我叫小明，今年20歲，身高175.5公分，是學生：true
```

---

### Q5. 找出程式碼的錯誤
下面這段程式碼有 **3 個編譯錯誤**，請找出並修正：

```java
public class Practice {
    public static void main(String[] args) {
        int score = 95.5;
        Boolean passed = true
        char letter = "A";
        System.out.println("Score: " + score);
    }
}
```
int 是整數
char 要用''
true後面要有;
---

### Q6. Scanner 基礎練習：BMI 小計算機
寫一支程式：
1. 用 `Scanner` 讓使用者輸入身高（公尺，例如 1.75）
2. 用 `Scanner` 讓使用者輸入體重（公斤，例如 65.5）
3. 印出使用者輸入的身高與體重（先不用算 BMI，只要能正確讀取並印出即可）

提示：身高體重都是小數，該用哪個 `scanner` 方法？

---

### Q7. 讀取多種型態
寫一支程式，依序用 Scanner 讀取：
1. 使用者的姓名（整行，可能包含空白，例如 "王小明"）
2. 使用者的年齡（整數）
3. 使用者的星座（一個字，不含空白，例如 "獅子座"）

讀取後把三個資訊組成一句話印出來。

> 提醒：這題會踩到我們筆記裡提過的那個「陷阱」，看看你能不能自己發現問題並排除它！

---

### Q8. 挑戰題：簡易加法機
寫一支程式：
1. 用 `Scanner` 讀取兩個整數（分兩次輸入）
2. 把兩數相加
3. 印出類似這樣的結果：
```
5 + 3 = 8
```

（提示：需要宣告一個新的變數來儲存相加後的結果）

---

## 參考答案

<details>
<summary>點我展開答案（寫完再看喔！）</summary>

**A1.** 類別名稱 `Student` 跟檔案名稱 `Hello.java` 不一致。Java 規定 public class 的名稱必須跟檔案名稱完全相同（含大小寫），所以這裡會編譯錯誤。

**A2.**（參考範例，答案不唯一）
- `int`：一個人的年齡、一箱雞蛋的數量
- `double`：身高、體重、商品價格
- `boolean`：燈是不是開著（開/關）、是不是已婚
- `char`：性別代碼（'M'/'F'）、考試等第（'A'）

**A3.** 第二行 `char grade2 = "A";` 會出錯，因為 `char` 只能用**單引號**裝「一個字元」，`"A"` 用雙引號代表這是 `String`（字串），型態不符會編譯錯誤。

**A4.**
```java
public class Introduce {
    public static void main(String[] args) {
        String name = "小明";
        int age = 20;
        double height = 175.5;
        boolean isStudent = true;

        System.out.println("我叫" + name + "，今年" + age + "歲，身高" + height + "公分，是學生：" + isStudent);
    }
}
```

**A5.** 三個錯誤：
1. `int score = 95.5;` → `95.5` 是小數，不能存進 `int`，應改成 `double score = 95.5;`
2. `Boolean passed = true` → 少了分號 `;`，應改成 `boolean passed = true;`（另外 `Boolean` 大寫是物件型態，寫小寫 `boolean` 才是 primitive type，這裡用小寫即可）
3. `char letter = "A";` → 應改成單引號 `char letter = 'A';`

**A6.**
```java
import java.util.Scanner;

public class BmiInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("請輸入身高(公尺)：");
        double height = scanner.nextDouble();

        System.out.println("請輸入體重(公斤)：");
        double weight = scanner.nextDouble();

        System.out.println("身高: " + height + " 公尺, 體重: " + weight + " 公斤");
    }
}
```

**A7.**
```java
import java.util.Scanner;

public class MultiInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("請輸入姓名：");
        String name = scanner.nextLine();

        System.out.println("請輸入年齡：");
        int age = scanner.nextInt();
        scanner.nextLine(); // 吃掉 nextInt() 留下的換行符號

        System.out.println("請輸入星座：");
        String zodiac = scanner.next();

        System.out.println(name + "，" + age + "歲，" + zodiac);
    }
}
```
陷阱說明：如果沒有加 `scanner.nextLine();` 這行去清掉換行符號，第三個輸入可能會被跳過或讀到空白。這就是筆記裡提到的 `nextInt()` 接 `nextLine()` 的經典 bug。

**A8.**
```java
import java.util.Scanner;

public class AddMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("請輸入第一個數字：");
        int num1 = scanner.nextInt();

        System.out.println("請輸入第二個數字：");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + sum);
    }
}
```

</details>