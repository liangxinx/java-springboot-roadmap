//public class D1test {
//    public static void main(String[] args) {
//        String name = "梁欣渝";
//        int age = 21;
//        double height = 163.9;
//        boolean isStudent = true;
//
//        System.out.println("我叫"+name+"今年"+age+"歲，身高"+height+"cm，isStudent:"+isStudent);
//    }
//
//}
//import java.util.Scanner;
//
//public class D1test {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("輸入身高:");
//        double height = scanner.nextDouble();
//        System.out.println("輸入體重:");
//        double weight = scanner.nextDouble();
//
//        System.out.println("身高:"+height+"體重:"+weight);
//        }
//    }

import java.util.Scanner;

//public class D1test {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("輸入姓名:");
//        String name = scanner.nextLine();
//        System.out.println("輸入年齡:");
//        int age = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("輸入星座");
//        String start = scanner.next();
//
//        System.out.println(name+age+start);
//        }
//    }
import java.util.Scanner;
public class D1test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a:");
        int a = scanner.nextInt();

        System.out.println("b:");
        int b = scanner.nextInt();

        int c = a+b;

        System.out.println(a+"+"+b+"="+c);
    }
}

