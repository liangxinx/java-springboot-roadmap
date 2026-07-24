
//運算子
//public class Day2 {
//    public static void main(String[] args) {
//        int a = 10;
//        int b = 6;
//
//        System.out.println("加"+(a+b));
//        System.out.println("減"+(a-b));
//        System.out.println("乘"+(a*b));
//        System.out.println("除"+(a/b));
//
//        double c = (double) a/b;
//        System.out.println("強制轉換"+c);
//    }
//}

//比較
//public class Day2 {
//    public static void main(String[] args) {
//        int a = 10;
//        int b = 5;
//
//        System.out.println("a=b:"+(a==b));
//        System.out.println("a!=b:"+(a!=b));
//        System.out.println("a<b:"+(a<b));
//        System.out.println("a>b:"+(a>b));
//        System.out.println("a>=b:"+(a<=b));
//        System.out.println("a<=b:"+(a<=b));
//    }
//}

//邏輯運算子
//public class Day2 {
//    public static void main(String[] args) {
//        boolean isSun = true;
//        boolean isFree = true;
//
////        boolean canPlay = isFree && isSun;
////        boolean canPlay = isFree || isSun;
//        boolean canPlay = !isFree;
//        System.out.println(canPlay);
//    }
//}

//public class Day2 {
//    public static void main(String[] args) {
//        int age = 18;
//        boolean hasId = true;
//
//        boolean canWatch = (age>=18) && hasId;
//        System.out.println("可以看電影嗎?:" + canWatch);
//
//        boolean canWatchor = (age>=18) || hasId;
//        System.out.println("換成or?:" + canWatchor);
//
//        boolean isChild = !(age>=18);
//        System.out.println("還是小孩嗎?:"+isChild);
//    }
//}

// if else
//新開一個 Class 叫 IfElse，做一個簡單的及格判斷 + Scanner 輸入的綜合練習（順便複習昨天教的 Scanner！）：
import java.util.Scanner;
//public class Day2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("請輸入你的成績:");
//        double score = scanner.nextDouble();
//
//        if (score > 90) {
//            System.out.println("你超棒");
//        } else if (score > 70) {
//            System.out.println("你普通");
//        }else {
//            System.out.println("你超爛");
//        }
//
//    }
//}

//switch
//public class Day2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("選擇餐點盲盒(1、2、3):");
//        int chose = scanner.nextInt();
//        switch (chose){
//            case 1 ->System.out.println("西瓜");
//            case 2 ->System.out.println("蘋果");
//            case 3 ->System.out.println("香蕉");
//            default -> System.out.println("沒有得吃");
//        }
//
//    }
//}

//for 迴圈
//public class Day2 {
//    public static void main(String[] args) {
//        for (int i=0; i<10; i+=2){
//            System.out.println(i);
//        }
//    }
//}
//public class Day2 {
//    public static void main(String[] args) {
//        for (int i=0; i<10; i++){
//            if (i%2==0){
//                System.out.println(i);
//            }else {
//                System.out.println("奇數bad");
//            }
//        }
//    }
//}
//public class Day2 {
//    public static void main(String[] args) {
//        int sum = 0 ;
//        for (int i =1; i<=5;i++){
//            sum +=i;
//        }
//        System.out.println("1+到5=" +sum);
//    }
//}

//while
//public class Day2 {
//    public static void main(String[] args) {
//        int i = 0 ;
//        while (i<10){
//            System.out.println(i);
//            i++;
//        }
//    }
//}

//一直問使用者還好嗎，直到使用者說很好才停止
import java.util.Scanner;
//public class Day2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = "";
//        while (!input.equals("很好")){
//            System.out.println("你今天還好嗎?:");
//            input = scanner.nextLine();
//            if (!input.equals("很好")){
//                System.out.println("你好可憐");
//            }
//        }
//        System.out.println("我們結束了");
//    }
//}

// do while

//public class Day2 {
//    public static void main(String[] args) {
//        int i = 0;
//        do {
//            System.out.println(i);
//            i++;
//        }while (i<10);
//    }
//}

//break
//public class Day2 {
//    public static void main(String[] args) {
//        for (int i = 0;i<10;i++){
//            if (i==5){
//                break;
//            }
//            System.out.println(i);
//        }
//    }
//}
//continue
public class Day2 {
    public static void main(String[] args) {
        for (int i = 0;i<10;i++){
            if (i%2==0){
                continue;
            }
            System.out.println(i);
        }
    }
}

