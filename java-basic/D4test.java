//### Q6. 字串基本操作
//用 Scanner 讀取使用者輸入的一句話，印出：
//        1. 這句話的長度
//2. 轉成全大寫
//3. 去除頭尾空白後的版本
import java.util.Locale;
//import java.util.Scanner;
//public class D4test {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("輸入一句話:");
//        String input = scanner.nextLine();
//        System.out.println(input.length());
//        System.out.println(input.toUpperCase());
//        System.out.println(input.trim());
//    }
//}
//        ### Q7. 判斷回文（不分大小寫）
//寫一個叫 `isPalindrome` 的 method，參數是 `String s`，回傳 `boolean`，
// 判斷這個字串正著讀和反著讀是否相同（例如 "level"、"Level" 都算回文，不用管大小寫）。
//提示：可以用 `StringBuilder` 的 `.reverse()` 幫忙，記得先把字串轉成同樣大小寫再比較。
//public class D4test {
//    public static boolean isPalindrome(String s){
//        String Lows = s.toLowerCase();
//        StringBuilder b = new StringBuilder(Lows);
//        b.reverse();
//        return Lows.equals(b.toString());
//    }
//    public static void main(String[] args) {
//        System.out.println(isPalindrome("Level"));
//    }
//}
//        ### Q8. 字串切割練習
//有一個字串 `"小明,20,175.5"`，代表姓名、年齡、身高，用逗號分隔。寫一支程式：
//        1. 用 `.split(",")` 切割
//        2. 把切割出來的年齡、身高分別轉成 `int` 和 `double`
//        （提示：`Integer.parseInt()` 和 `Double.parseDouble()`，這是新方法，可以先查查看怎麼用）
//        3. 印出一句組合好的自我介紹句子
//public class D4test {
//    public static void main(String[] args) {
//        String a = "小明,20,175.5";
//        String[] newa = a.split(",");
//        String name = newa[0];
//        int age = Integer.parseInt(newa[1]);
//        double height = Double.parseDouble(newa[2]);
//        System.out.println("大家好我叫"+name+"，今年"+age+"歲，身高是"+height);
//    }
//}

//        ### Q9. 用 StringBuilder 組字串
//寫一支程式，用 `StringBuilder` 和一個 `for` 迴圈，組出以下字串並印出：
//        ```
//        1-2-3-4-5
//        ```
//        （提示：迴圈跑 1 到 5，每個數字後面接 "-"，除了最後一個數字後面不用接）
//public class D4test {
//    public static void main(String[] args) {
//        StringBuilder a = new StringBuilder();
//        for (int i = 1; i < 6; i++) {
//            a.append(i);
//            if (i<5){
//                a.append("-");
//            }
//        }
//        System.out.println(a);
//    }
//}
//        ---
//
//        ### Q10. 找出程式碼的錯誤
//下面這段程式碼有 **2 個問題**（不一定是編譯錯誤，也可能是邏輯錯誤），請找出並修正：
//
//        ```java
//import java.util.Arrays;
//public class D4test {
//    public static void main(String[] args) {
//        String status = "完成";
//
//        if (status.equals("完成")) {
//            System.out.println("任務已完成");
//        }
//
//        int[] scores = {85, 92, 78, 65, 90};
//        Arrays.sort(scores);
//        System.out.println("最高分: " + scores[scores.length-1]);
//    }
//}

//        ### Q11. Arrays 綜合練習
//寫一支程式：
//        1. 建立一個 `int[]` 陣列，內容為 `{45, 12, 78, 3, 99, 27}`
//        2. 用 `Arrays.toString()` 印出原始陣列
//3. 用 `Arrays.sort()` 排序後印出
//4. 用 `Arrays.copyOf()` 複製一份長度為 3 的陣列（只保留排序後最小的三個），印出結果
//import java.util.Arrays;
//public class D4test {
//    public static void main(String[] args) {
//        int [] a = {45, 12, 78, 3, 99, 27};
//        System.out.println(Arrays.toString(a));
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
//        int[] copy = Arrays.copyOf(a,3);
//        System.out.println(Arrays.toString(copy));
//    }
//}
//        ### Q12. 挑戰題：計算某字元出現次數
//寫一個叫 `countChar` 的 method，參數是 `String text` 和 `char target`，回傳這個字元在字串中出現的次數（不分大小寫）。
//
//例如 `countChar("Hello World", 'o')` 應該回傳 `2`。
//提示：可以用 `for` 迴圈搭配 `.charAt(i)` 逐一檢查，記得比較前先統一轉成同樣大小寫。
public class D4test {
    public static int countChar(String text,char target){
        String LowText = text.toLowerCase();
        int answer = 0;
        for (int i = 0; i < LowText.length(); i++) {
            if (LowText.charAt(i)==(target)){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countChar("world World",'w'));
    }
}
//        ---
//
