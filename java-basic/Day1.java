import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.in：代表標準輸入串流，也就是指「從鍵盤接收使用者輸入的資料」。
        System.out.println("請輸入名字:");
        String name = scanner.nextLine();
        //nextLine()：用來讀取使用者輸入的一整行文字（包含空白），直到按下 Enter 為止。
        System.out.println("請輸入年紀");
        int age = scanner.nextInt();

        System.out.println("你好!"+age+"歲的"+ name+"~");
    }
}

//public class hello {
//    public static void main(String[] args) {
//        int age=20;
//        double height = 175.5;
//        boolean isStudent = true;
//        char grade = 'A';
//
//        System.out.println("年齡"+age);
//        System.out.println("身高"+height);
//        System.out.println("是學生嗎"+isStudent);
//        System.out.println("成績"+grade);
//    }
//            }