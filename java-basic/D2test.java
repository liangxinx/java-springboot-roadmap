import java.util.Scanner;
//Q5. 及格判斷機
//用 Scanner 讀取使用者輸入的一個整數分數，用 `if / else if / else` 判斷等第：
//        - 90 分以上：A
//- 80~89：B
//- 70~79：C
//- 60~69：D
//- 60 分以下：F
//---
//public class D2test {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("輸入你的成績:");
//        int score = scanner.nextInt();
//
//        if (score>=90){
//            System.out.println("A");
//        } else if (score>=80) {
//            System.out.println("B");
//        } else if (score>=70) {
//            System.out.println("C");
//        } else if (score>=60) {
//            System.out.println("D");
//        }else {
//            System.out.println("Bad");
//        }
//    }
//}
//
// Q6. switch 星期問候
//用 Scanner 讀取一個 1~3 的數字，用 `switch`（箭頭語法）印出對應的星期幾中文名稱，若輸入超出 1~3 範圍，印出「輸入錯誤」。
//public class D2test {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("輸入:");
//        int input = scanner.nextInt();
//
//        switch (input){
//            case 1 -> System.out.println("一");
//            case 2 -> System.out.println("二");
//            case 3 -> System.out.println("三");
//            default -> System.out.println("輸入錯誤");
//        }
//    }
//}
//
//        ### Q7. 找出程式碼的錯誤
//下面這段程式碼有 **2 個錯誤**，請找出並修正：
//
//        ```java
//public class D2test {
//    public static void main(String[] args) {
//        int score = 50;
//
//        if (score >= 60){
//            System.out.println("及格");
//            System.out.println("恭喜通過");
//
//            String status = "及格";
//            if (status.equals("及格")) {
//                System.out.println("狀態正確");
//            }
//        }
//        System.out.println("哈哈哈");
//
//    }
//}
// Q8. for 迴圈：九九乘法表（其中一行）
//用 `for` 迴圈印出 9 乘法表中「7 的乘法」
//public class D2test {
//    public static void main(String[] args) {
//        for (int i = 1;i<10;i++){
//            System.out.println(i*7);
//        }
//    }
//}
// Q9. 累加與計數
//用 `for` 迴圈計算 1 到 50 之間**所有偶數**的總和，並印出總共有幾個偶數（提示：需要兩個變數，一個累加總和，一個計數）。
//public class D2test {
//    public static void main(String[] args) {
//        int count = 0;
//        int sum = 0;
//        for (int i = 1;i<51;i++){
//            if (i%2==0){
//                sum+=i;
//                count++;
//            }
//        }
//        System.out.println(sum);
//        System.out.println(count);
//    }
//}
//        ### Q10. while + break：猜數字（簡化版）
//        1. 設定一個固定的答案 `int answer = 7;`
//        2. 用 `while(true)` 搭配 Scanner，不斷讓使用者輸入猜測的數字
//3. 如果猜對了，印出「答對了！」並用 `break` 跳出迴圈
//4. 如果猜錯，印出「再試一次」，繼續迴圈
//public class D2test {
//    public static void main(String[] args) {
//        int answer=0;
//        Scanner scanner = new Scanner(System.in);
//        while (answer!=7){
//            System.out.println("猜測數字");
//            answer = scanner.nextInt();
//            if (answer==7){
//                System.out.println("答對");
//                break;
//            }
//            System.out.println("錯誤");
//        }
//    }
//}
//
//---
//
//        ### Q11. continue 練習：跳過某個數字
//用 `for` 迴圈印出 1 到 20 之間的所有數字，但**跳過所有 3 的倍數**（提示：用 `continue`）。
//public class D2test {
//    public static void main(String[] args) {
//        for (int i=1;i<21;i++){
//            if(i%3==0){
//                continue;
//            }
//            System.out.println(i);
//        }
//    }
//}
//        Q12. 挑戰題：綜合應用
//寫一支程式，用 `while` 迴圈讓使用者可以連續輸入多個整數分數（直到輸入 `-1` 結束），程式需要：
//        1. 統計輸入了幾筆分數
//2. 計算這些分數的總分與平均
//3. 每輸入一筆，立刻用 `if/else` 印出這筆分數的及格與否（60 分以上及格）
//
//        （不用処理平均到小數點幾位，能算出來、方向正確即可）

public class D2test {
    public static void main(String[] args) {
        int input=0;
        int count=0;
        int avg=0;
        int sum=0;
        Scanner scanner = new Scanner(System.in);
        while (input!=-1){
            System.out.println("輸入分數");
            input = scanner.nextInt();
            if (input == -1){
                break;
            }else if (input>=60) {
                System.out.println("及格");
            }else {
                System.out.println("不及格");
            }
            if (input != -1){
                count ++;
                sum += input;
                avg = sum/count;
            }

        }
        System.out.println("共輸入"+count+"筆資料");
        System.out.println("總合:"+sum);
        System.out.println("平均:"+avg);
        System.out.println("結束");

    }
}


