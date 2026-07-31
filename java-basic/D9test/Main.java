//## 第二部分：動手寫程式
//
//### Q6. ArrayList 基本操作
//建立一個 `ArrayList<String>`，加入 5 個水果名稱。印出：
//        1. 完整清單
//2. 清單長度
//3. 移除第 3 個元素（索引2）後的清單
//4. 判斷清單裡是否包含「芒果」
//package D9test;
//import java.util.ArrayList;
//public class Main {
//    public static void main(String[] args) {
//        ArrayList<String> fruits = new ArrayList<>();
//        fruits.add("apple");
//        fruits.add("banana");
//        fruits.add("orange");
//        fruits.add("grape");
//        fruits.add("cheery");
//        System.out.println(fruits);
//        System.out.println(fruits.size());
//        fruits.remove(2);
//        System.out.println(fruits.size());
//        System.out.println(fruits.contains("orange"));
//    }
//
//}
//        ---
//
//        ### Q7. HashMap 應用：單字計數器
//寫一支程式，給定一個 `String[]` 陣列（例如 `{"apple", "banana", "apple", "orange", "banana", "apple"}`），
// 用 `HashMap<String, Integer>` 統計每個單字出現的次數，最後印出每個單字跟它的出現次數。
//
//提示：可以用 `getOrDefault()` 搭配 `put()`，例如：
//        ```java
//map.put(word, map.getOrDefault(word, 0) + 1);
//        ```
//package D9test;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Main {
//    public static void main(String[] args) {
//        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};
//        HashMap<String,Integer> wordCount = new HashMap<>();
//
//        for (String word : words){
//            wordCount.put(word,wordCount.getOrDefault(word,0)+1);
//        }
//        for(Map.Entry<String,Integer>  entry : wordCount.entrySet()){
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        }
//    }
//
//}
//
//        ### Q8. HashSet 去重練習
//給定一個 `ArrayList<Integer>`，內容為 `{5, 3, 5, 8, 3, 1, 8, 9}`，用 `HashSet` 去除重複的數字，印出去重後的結果，以及總共有幾個不重複的數字。
package D9test;

//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args) {
//        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5, 3, 5, 8, 3, 1, 8, 9));
//        HashSet<Integer> b = new HashSet<>(a);
//        System.out.println(b);
//        System.out.println(b.size());
//    }
//}

//        ### Q9. 找出程式碼的錯誤
//下面這段程式碼有 **2 個問題**，請找出並修正：
//import java.util.ArrayList;
////        ```java
//public class D9test {
//    public static void main(String[] args) {
//        ArrayList<Integer> numbers = new ArrayList<>();
//        numbers.add(10);
//        numbers.add(20);
//
//        System.out.println(numbers.size());
//    }
//}
//        ### Q10. 綜合挑戰：學生成績管理
//延續今天教學的 `CollectionDemo` 範例，寫一支更完整的程式：
//        1. 用 `ArrayList<String>` 儲存 5 個學生姓名
//2. 用 `HashMap<String, Integer>` 儲存每個學生對應的分數（自訂分數）
//        3. 用 `HashSet<String>` 記錄「及格」（60分以上）的學生姓名（用迴圈判斷分數後加入）
//        4. 最後印出：
//        - 全班平均分數
//   - 及格人數
//   - 每個學生的姓名、分數、是否及格
//    import java.util.ArrayList;
//    import java.util.HashMap;
//    import java.util.HashSet;
//
//public class Main {
//    public static void main(String[] args) {
//        ArrayList<String> students = new ArrayList<>();
//        students.add("小小");
//        students.add("小花");
//        students.add("小凱");
//        students.add("小綠");
//        students.add("小洪");
//
//        HashMap<String,Integer> scores = new HashMap<>();
//        scores.put("小小",100);
//        scores.put("小花",55);
//        scores.put("小凱",90);
//        scores.put("小綠",78);
//        scores.put("小洪",83);

import Day9.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

////        4. 最後印出：
////        - 全班平均分數
////   - 及格人數
////   - 每個學生的姓名、分數、是否及格
//        HashSet<String> isgood = new HashSet<>();
//        int totalscore = 0;
//        for (String student : students){
//            int score = scores.getOrDefault(student,0);
//            totalscore += score;
//            if (score >=60){
//                isgood.add(student);
//            }
//        }
//        double avg = totalscore/students.size();
//        System.out.println("avg:"+avg);
//        System.out.println("及格:"+isgood.size());
//        for (String student : students){
//            int score = scores.get(student);//用key抓value
//            boolean passed = isgood.contains(student);
//            System.out.println(student + " - 分數: " + score + ", 及格: " + passed);
//        }
//    }
//}
//---
//
//        ### Q11. 挑戰題：找出兩個清單的共同元素
//給定兩個 `ArrayList<String>`：
//        ```java
//ArrayList<String> classA = new ArrayList<>(); // 假設加入 "小明","小華","小美","小強"
//ArrayList<String> classB = new ArrayList<>(); // 假設加入 "小華","小美","小林","小陳"
//```

public class Main {
    public static void main(String[] args) {
        ArrayList<String> classA = new ArrayList<>(Arrays.asList("小明","小華","小美","小強"));
        ArrayList<String> classB = new ArrayList<>(Arrays.asList("小華","小美","小林","小陳"));
        HashSet<String> A = new HashSet<>(classA);
        for(String name : classB){
            if(A.contains(name)){
                System.out.println(name);
            }
        }

    }
}
//寫一支程式，找出「同時出現在兩個清單裡」的名字（提示：可以把其中一個轉成 `HashSet`，再用迴圈搭配 `.contains()` 判斷）。


