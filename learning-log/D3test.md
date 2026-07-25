# Java 練習考題 — Day 3

---

## 第一部分：基礎觀念題（不用寫程式，用想的或口頭回答）

**Q1.** 下面這段程式碼會印出什麼？請先推算再上機驗證。

```java
public static int mystery(int n) {
    n = n * 2;
    return n;
}

public static void main(String[] args) {
    int x = 5;
    int y = mystery(x);
    System.out.println("x = " + x);
    System.out.println("y = " + y);
}
```
5 10 

**Q2.** 下面哪一組是合法的 Method Overloading？哪一組會編譯錯誤？請說明原因。

```java
// 組合A
public static int calc(int a, int b) { return a + b; }
public static double calc(int a, int b) { return a + b; }
double裡面也要是double， 不能只有回傳型態相同

// 組合B
public static int calc(int a, int b) { return a + b; }
public static int calc(int a, int b, int c) { return a + b + c; }
正確

// 組合C
public static int calc(int a, double b) { return (int)(a + b); }
public static int calc(double a, int b) { return (int)(a + b); }
正確
```

**Q3.** 下面這段程式碼執行時會發生什麼事？

```java
int[] nums = {10, 20, 30};
System.out.println(nums[3]);
```
錯誤 ArrayIndexOutOfBoundsException

**Q4.** 有一個二維陣列 `int[][] grid = {{1,2,3},{4,5,6}};`，請問：
- `grid.length` 是多少？  2
- `grid[0].length` 是多少？  3
- `grid[1][2]` 是多少？  6

---

## 第二部分：動手寫程式

### Q5. 寫一個簡單的 void method
寫一個叫 `printStars` 的 method，參數是一個 `int count`，功能是印出 `count` 個 `*` 符號在同一行（例如傳入 5，印出 `*****`）。在 `main` 裡呼叫三次，分別傳入 3、5、7。

---

### Q6. 寫一個有回傳值的 method
寫一個叫 `isEven` 的 method，參數是一個 `int number`，回傳 `boolean`，判斷這個數字是不是偶數。在 `main` 裡用 Scanner 讀取一個數字，呼叫這個 method 並印出結果。

---

### Q7. Overloading 練習
寫一個叫 `getArea` 的 method，需要兩個版本：
1. 傳入一個 `int side`（正方形邊長），回傳正方形面積
2. 傳入 `int width` 和 `int height`（長方形），回傳長方形面積

在 `main` 裡分別呼叫兩個版本並印出結果。

---

### Q8. 找出程式碼的錯誤
下面這段程式碼有 **2 個錯誤**，請找出並修正：

```java
public class FindBug {

    public static int square(int n) {
        int result = n * n;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(nums[4]);

        int result = square(5);
        System.out.println(result);
    }
}
```

---

### Q9. 陣列基礎：找最大值
寫一個叫 `findMax` 的 method，參數是一個 `int[] arr`，回傳陣列中最大的數字。在 `main` 裡建立一個陣列 `{23, 67, 12, 89, 45}`，呼叫這個 method 並印出結果。

（提示：可以先假設第一個元素是最大值，再用迴圈跟後面的每一個比較）

---

### Q10. 陣列基礎：計算平均分數
寫一個叫 `average` 的 method，參數是 `int[] scores`，回傳這個陣列的平均值（`double`）。在 `main` 裡用陣列 `{88, 92, 76, 100, 65}` 呼叫並印出結果。

---

### Q11. 二維陣列：印出整個表格 + 列總分
建立一個二維陣列代表 3 個學生、各 4 科的成績（自己隨意填數字），用巢狀迴圈：
1. 印出整個成績表格
2. 印出每個學生（每一列）的總分

---

### Q12. 挑戰題：每一欄的總分（今天教過的難題，自己重新寫一次加深印象）
承 Q11 的成績表格，寫出計算**每一欄（每一科）**總分的程式碼。

---

### Q13. 綜合挑戰：整合 method + 二維陣列
延續 Q11 的表格，寫一個叫 `sumRow` 的 method，參數是 `int[] row`（一維陣列），回傳總分。在 `main` 裡用巢狀迴圈或一般迴圈，把二維陣列的每一列丟給 `sumRow`，印出每個學生的總分（提示：這題在今天的教學內容中出現過類似寫法，可以回去對照）。

---

## 參考答案

<details>
<summary>點我展開答案（寫完再看喔！）</summary>

**A1.**
```
x = 5
y = 10
```
因為 `int` 是 primitive type，傳進 method 的是**值的複製品**，`mystery` 裡面修改的 `n` 只是區域變數，不會影響到 `main` 裡的 `x`。`y` 接收的是 `return` 回傳的計算結果 10。

**A2.**
- **組合A**：❌ 編譯錯誤。兩個 method 的參數列表完全一樣（都是 `int, int`），只有回傳型態不同，Java 無法用回傳型態分辨要呼叫哪一個。
- **組合B**：✅ 合法。參數**數量**不同（2個 vs 3個）。
- **組合C**：✅ 合法。參數**型態的順序**不同（`int, double` vs `double, int`），Java 可以分辨。

**A3.** 程式執行時會拋出 `ArrayIndexOutOfBoundsException`（陣列索引越界例外），因為 `nums` 長度是 3，合法索引只有 `0, 1, 2`，沒有索引 `3`，程式會當掉。

**A4.**
- `grid.length` = `2`（兩列）
- `grid[0].length` = `3`（第0列有3個元素）
- `grid[1][2]` = `6`（第1列第2欄）

**A5.**
```java
public class StarPrinter {

    public static void printStars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printStars(3);
        printStars(5);
        printStars(7);
    }
}
```

**A6.**
```java
import java.util.Scanner;

public class EvenChecker {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入一個數字：");
        int num = scanner.nextInt();
        System.out.println("是偶數嗎: " + isEven(num));
    }
}
```

**A7.**
```java
public class AreaCalculator {

    public static int getArea(int side) {
        return side * side;
    }

    public static int getArea(int width, int height) {
        return width * height;
    }

    public static void main(String[] args) {
        System.out.println("正方形面積: " + getArea(5));
        System.out.println("長方形面積: " + getArea(4, 6));
    }
}
```

**A8.** 兩個錯誤：
1. `square` method 宣告回傳型態是 `int`，但裡面沒有 `return result;`，編譯錯誤：Missing return statement。
2. `nums[4]` 超出陣列範圍（`nums` 長度是 3，合法索引只有 0~2），執行時會拋出 `ArrayIndexOutOfBoundsException`。

修正後：
```java
public class FindBug {

    public static int square(int n) {
        int result = n * n;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(nums[2]); // 改成合法索引

        int result = square(5);
        System.out.println(result);
    }
}
```

**A9.**
```java
public class MaxFinder {

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {23, 67, 12, 89, 45};
        System.out.println("最大值: " + findMax(nums));
    }
}
```

**A10.**
```java
public class AverageCalculator {

    public static double average(int[] scores) {
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        return (double) sum / scores.length;
    }

    public static void main(String[] args) {
        int[] scores = {88, 92, 76, 100, 65};
        System.out.println("平均: " + average(scores));
    }
}
```

**A11.**
```java
public class GradeTable {
    public static void main(String[] args) {
        int[][] scores = {
            {85, 90, 78, 88},
            {70, 65, 80, 75},
            {95, 92, 89, 100}
        };

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("------");

        for (int i = 0; i < scores.length; i++) {
            int rowTotal = 0;
            for (int j = 0; j < scores[i].length; j++) {
                rowTotal += scores[i][j];
            }
            System.out.println("第 " + (i + 1) + " 位學生總分: " + rowTotal);
        }
    }
}
```

**A12.**
```java
int numCols = scores[0].length;

for (int j = 0; j < numCols; j++) {
    int colTotal = 0;
    for (int i = 0; i < scores.length; i++) {
        colTotal += scores[i][j];
    }
    System.out.println("第 " + (j + 1) + " 科總分: " + colTotal);
}
```

**A13.**
```java
public class GradeTableWithMethod {

    public static int sumRow(int[] row) {
        int sum = 0;
        for (int num : row) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] scores = {
            {85, 90, 78, 88},
            {70, 65, 80, 75},
            {95, 92, 89, 100}
        };

        for (int i = 0; i < scores.length; i++) {
            System.out.println("第 " + (i + 1) + " 位學生總分: " + sumRow(scores[i]));
        }
    }
}
```

</details>