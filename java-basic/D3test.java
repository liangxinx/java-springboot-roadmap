
//### Q5. 寫一個簡單的 void method
//寫一個叫 `printStars` 的 method，參數是一個 `int count`，功能是印出 `count` 個 `*` 符號在同一行（例如傳入 5，印出 `*****`）。
//public class D3test {
//
//    public static String  printStars(int b){
//        String stars="";
//        for (int i = 0; i < b; i++) {
//            stars += "*";
//        }
//        return stars;
//    }
//    public static void main(String[] args) {
//        System.out.println(printStars(2));
//        System.out.println(printStars(5));
//    }
//}
//        ### Q6. 寫一個有回傳值的 method
//寫一個叫 `isEven` 的 method，參數是一個 `int number`，回傳 `boolean`，判斷這個數字是不是偶數。在 `main` 裡用 Scanner 讀取一個數字，呼叫這個 method 並印出結果。
import java.util.Scanner;
//
//public class D3test {
//    public static boolean isEven(int number){
//        return number%2==0;
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("輸入數字");
//        int input = scanner.nextInt();
//        System.out.println("是偶數嗎?"+isEven(input));
//    }
//}
//  ### Q7. Overloading 練習
//寫一個叫 `getArea` 的 method，需要兩個版本：
//        1. 傳入一個 `int side`（正方形邊長），回傳正方形面積
//2. 傳入 `int width` 和 `int height`（長方形），回傳長方形面積
//
//在 `main` 裡分別呼叫兩個版本並印出結果。
//public class D3test {
//    public static int getArea(int side){
//        return side*side;
//    }
//    public static int getArea(int width,int height){
//        return width*height;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getArea(2));
//        System.out.println(getArea(3,5));
//    }
//}
//        ### Q8. 找出程式碼的錯誤
//下面這段程式碼有 **2 個錯誤**，請找出並修正：
//
//        ```java
//public class D3test {
//
//    public static int square(int n) {
//        int result = n * n;
//        return result;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        System.out.println(nums[2]);
//
//        int result = square(5);
//        System.out.println(result);
//    }
//}
//        ### Q9. 陣列基礎：找最大值
//寫一個叫 `findMax` 的 method，參數是一個 `int[] arr`，回傳陣列中最大的數字。
//  在 `main` 裡建立一個陣列 `{23, 67, 12, 89, 45}`，呼叫這個 method 並印出結果。
// （提示：可以先假設第一個元素是最大值，再用迴圈跟後面的每一個比較）
//public class D3test {
//    public static int findMax(int[] arr){
//        int max = arr[0];
//        for (int num : arr) {
//            if(num>max){
//                max = num;
//            }
//        }
//        return max;
//    }
//    public static void main(String[] args) {
//        int [] a ={23, 67, 12, 89, 45};
//        System.out.println(findMax(a));
//    }
//}
//        ### Q10. 陣列基礎：計算平均分數
//寫一個叫 `average` 的 method，參數是 `int[] scores`，回傳這個陣列的平均值（`double`）。
// 在 `main` 裡用陣列 `{88, 92, 76, 100, 65}` 呼叫並印出結果。
//public class D3test {
//    public static double average(int[] scores) {
//        int total = 0;
//        for (int num : scores) {
//            total += num;
//        }
//        return (double)total / scores.length;
//    }
//    public static void main(String[] args) {
//        int[] arr = {88, 92, 76, 100, 65};
//        System.out.println(average(arr));
//    }
//}

//        ### Q11. 二維陣列：印出整個表格 + 列總分
//建立一個二維陣列代表 3 個學生、各 4 科的成績（自己隨意填數字），用巢狀迴圈：
//        1. 印出整個成績表格
//2. 印出每個學生（每一列）的總分
//public class D3test {
//    public static void main(String[] args) {
//        int[][] scores ={
//                {11,22,33,44},
//                {33,44,55,66},
//                {66,77,88,99}
//        };
//        for (int i = 0; i < scores.length; i++) {
//            int sum =0;
//            for (int j = 0; j < scores[0].length; j++) {
//                System.out.print(scores[i][j]+"\t");
//                sum += scores[i][j];
//            }
//            System.out.println("這一列的總分是");
//            System.out.println(sum);
//        }
//    }
//}
//public class D3test {
//    public static int sum(int[] arr){
//        int sum =0;
//        for(int num : arr){
//            sum += num;
//        }
//        return sum;
//    }
//    public static int sumcol(int[][] arr,int col){
//        int sum = 0 ;
//        for (int i = 0 ;i<arr.length;i++){
//            sum += arr[i][col];
//        }
//        return sum;
//    }
//    public static void main(String[] args) {
//        int[][] scores ={
//                {11,22,33,44},
//                {33,44,55,66},
//                {66,77,88,99}
//        };
//        for (int i = 0; i < scores.length; i++) {
//            for (int j = 0; j < scores[0].length; j++) {
//                System.out.print(scores[i][j]+"\t");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i <scores.length; i++) {
//            System.out.println("每列的成績是:"+sum(scores[i]));
//        }
//        System.out.println();
//// Q12. 挑戰題：每一欄的總分
//        for (int i = 0; i <scores[0].length; i++) {
//            System.out.println("每欄的成績是:"+sumcol(scores,i));
//        }
//    }
//}


//        ### Q13. 綜合挑戰：整合 method + 二維陣列
//延續 Q11 的表格，寫一個叫 `sumRow` 的 method，參數是 `int[] row`（一維陣列），回傳總分。
// 在 `main` 裡用巢狀迴圈或一般迴圈，把二維陣列的每一列丟給 `sumRow`，印出每個學生的總分（提示：這題在今天的教學內容中出現過類似寫法，可以回去對照）。
//
//        ---
