## 第一部分：基礎觀念題（不用寫程式，用想的或口頭回答）

**Q1.** 下面這段程式碼會印出什麼？

```java
int a = 7;
int b = 2;
System.out.println(a / b);
System.out.println(a % b);
System.out.println((double) a / b);
```
3、1、3.5

**Q2.** 下面兩行哪一行會編譯錯誤？為什麼？

```java
int x = 5;
if (x = 5) {
    System.out.println("相等");
}
```
要用 ==
**Q3.** 判斷下面邏輯運算式的結果

```java
boolean p = true;
boolean q = false;

System.out.println(p && q);
System.out.println(p || q);
System.out.println(!p && !q);
```
f t f

**Q4.** 下面這段 `switch` 印出的結果會是什麼？請說明原因。

```java
int num = 1;
switch (num) {
    case 1:
        System.out.println("一");
    case 2:
        System.out.println("二");
        break;
    default:
        System.out.println("其他");
}
```
一、二(因為一後面沒有break)

---

## 第二部分：動手寫程式

### Q5. 及格判斷機
用 Scanner 讀取使用者輸入的一個整數分數，用 `if / else if / else` 判斷等第：
- 90 分以上：A
- 80~89：B
- 70~79：C
- 60~69：D
- 60 分以下：F

---

### Q6. switch 星期問候
用 Scanner 讀取一個 1~7 的數字，用 `switch`（箭頭語法）印出對應的星期幾中文名稱，若輸入超出 1~7 範圍，印出「輸入錯誤」。

---

### Q7. 找出程式碼的錯誤
下面這段程式碼有 **2 個錯誤**，請找出並修正：

```java
public class FindBug {
    public static void main(String[] args) {
        int score = 75;

        if (score >= 60)
            System.out.println("及格");
            System.out.println("恭喜通過");

        String status = "及格";
        if (status = "及格") {
            System.out.println("狀態正確");
        }
    }
}
```

---

### Q8. for 迴圈：九九乘法表（其中一行）
用 `for` 迴圈印出 9 乘法表中「7 的乘法」，也就是：
```
7 x 1 = 7
7 x 2 = 14
...
7 x 9 = 63
```

---

### Q9. 累加與計數
用 `for` 迴圈計算 1 到 50 之間**所有偶數**的總和，並印出總共有幾個偶數（提示：需要兩個變數，一個累加總和，一個計數）。

---

### Q10. while + break：猜數字（簡化版）
寫一支程式：
1. 設定一個固定的答案 `int answer = 7;`
2. 用 `while(true)` 搭配 Scanner，不斷讓使用者輸入猜測的數字
3. 如果猜對了，印出「答對了！」並用 `break` 跳出迴圈
4. 如果猜錯，印出「再試一次」，繼續迴圈

---

### Q11. continue 練習：跳過某個數字
用 `for` 迴圈印出 1 到 20 之間的所有數字，但**跳過所有 3 的倍數**（提示：用 `continue`）。

---

### Q12. 挑戰題：綜合應用
寫一支程式，用 `while` 迴圈讓使用者可以連續輸入多個整數分數（直到輸入 `-1` 結束），程式需要：
1. 統計輸入了幾筆分數
2. 計算這些分數的總分與平均
3. 每輸入一筆，立刻用 `if/else` 印出這筆分數的及格與否（60 分以上及格）

（不用処理平均到小數點幾位，能算出來、方向正確即可）

---

## 參考答案

<details>
<summary>點我展開答案（寫完再看喔！）</summary>

**A1.**
```
3
1
3.5
```
`7 / 2` 是 int 除法，捨去小數變成 3；`7 % 2` 餘數是 1；`(double) 7 / 2` 先轉型再除，得到 3.5。

**A2.** 會編譯錯誤。`x = 5` 是賦值（把 5 存進 x），結果型態是 `int`，但 `if()` 裡面需要 `boolean`，型態不符所以編譯器會直接報錯。正確寫法應該是 `if (x == 5)`。

**A3.**
```
false   // p && q → true && false
true    // p || q → true || false
false   // !p && !q → false && true
```

**A4.**
```
一
二
```
因為 `case 1` 底下沒有加 `break`，會發生 fall-through（貫穿），繼續往下執行 `case 2` 的內容，直到遇到 `case 2` 裡的 `break` 才停止。

**A5.**
```java
import java.util.Scanner;

public class GradeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入分數：");
        int score = scanner.nextInt();

        if (score >= 90) {
            System.out.println("等第: A");
        } else if (score >= 80) {
            System.out.println("等第: B");
        } else if (score >= 70) {
            System.out.println("等第: C");
        } else if (score >= 60) {
            System.out.println("等第: D");
        } else {
            System.out.println("等第: F");
        }
    }
}
```

**A6.**
```java
import java.util.Scanner;

public class DaySwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入 1~7：");
        int day = scanner.nextInt();

        switch (day) {
            case 1 -> System.out.println("星期一");
            case 2 -> System.out.println("星期二");
            case 3 -> System.out.println("星期三");
            case 4 -> System.out.println("星期四");
            case 5 -> System.out.println("星期五");
            case 6 -> System.out.println("星期六");
            case 7 -> System.out.println("星期日");
            default -> System.out.println("輸入錯誤");
        }
    }
}
```

**A7.** 兩個錯誤：
1. `if (score >= 60)` 沒加大括號，導致 `System.out.println("恭喜通過");` 其實不受 if 控制，永遠都會被印出。應該加上 `{ }` 把兩行都包起來。
2. `if (status = "及格")` 用了 `=` 而不是 `==`（字串應該用 `.equals()`），應改成 `if (status.equals("及格"))`。

**A8.**
```java
public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            System.out.println("7 x " + i + " = " + (7 * i));
        }
    }
}
```

**A9.**
```java
public class EvenSum {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;

        for (int i = 1; i <= 50; i++) {
            if (i % 2 == 0) {
                sum += i;
                count++;
            }
        }

        System.out.println("偶數總和: " + sum);
        System.out.println("偶數個數: " + count);
    }
}
```

**A10.**
```java
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = 7;

        while (true) {
            System.out.println("請猜一個數字：");
            int guess = scanner.nextInt();

            if (guess == answer) {
                System.out.println("答對了！");
                break;
            } else {
                System.out.println("再試一次");
            }
        }
    }
}
```

**A11.**
```java
public class SkipMultiples {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}
```

**A12.**
```java
import java.util.Scanner;

public class ScoreTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int total = 0;

        while (true) {
            System.out.println("請輸入分數（輸入 -1 結束）：");
            int score = scanner.nextInt();

            if (score == -1) {
                break;
            }

            count++;
            total += score;

            if (score >= 60) {
                System.out.println("及格");
            } else {
                System.out.println("不及格");
            }
        }

        if (count > 0) {
            System.out.println("共輸入 " + count + " 筆");
            System.out.println("總分: " + total);
            System.out.println("平均: " + (total / count));
        } else {
            System.out.println("沒有輸入任何分數");
        }
    }
}
```

</details>