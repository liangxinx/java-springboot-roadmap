//public class Day4 {
//    public static void main(String[] args) {
//        String name = " liang Xinxin";
////        //取得字串長度
////        System.out.println(name.length());
////        //取得指定位置的字元
////        System.out.println(name.charAt(0));
////        //擷取子字串
////        System.out.println(name.substring(6));//從索引6一路到最後
////        System.out.println(name.substring(0,5));//從0到5，不包括5
////        //轉換大小寫
////        System.out.println(name.toUpperCase());
////        System.out.println(name.toLowerCase());
////        //去頭尾空白
////        System.out.println(name.trim());
////        //取代文字
////        System.out.println(name.replace("xin","yu"));
////        //分隔符號
////        String csv = "apple,banana,orange";
////        String[] fruits=csv.split(",");
////        // fruits[0] = "apple", fruits[1] = "banana", fruits[2] = "orange"
////        for (String fruit : fruits){
////            System.out.println(fruit);
////        }
////        //判斷是否包含某段文字
////        System.out.println(name.contains("xin"));
//        //比較字串是否相同
//        String name2 = new String(" liang Xinxin");
//        System.out.println(name.equals(name2));
//        //忽略大小寫的比較
//        String name3 = new String(" liang xinxin");
//        System.out.println(name.equalsIgnoreCase(name3));
//        //防禦性寫法練習
//        String input = null;
//        System.out.println("安全比較:"+"exit".equals(input));
//    }
//}

public class Day4 {
    public static void main(String[] args) {
        String text = "  Hello World  ";

        System.out.println("原始長度: " + text.length());
        System.out.println("去空白後: '" + text.trim() + "'");
        System.out.println("轉大寫: " + text.trim().toUpperCase());
        System.out.println("第一個字元: " + text.trim().charAt(0));
        System.out.println("擷取 World: " + text.trim().substring(6));
        System.out.println("取代: " + text.trim().replace("World", "Java"));
        System.out.println("是否包含 Hello: " + text.contains("Hello"));

        String csv = "apple,banana,orange";
        String[] fruits = csv.split(",");
        System.out.println("水果數量: " + fruits.length);
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
    }
}
//StringBuilder
//public class Day4 {
//    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("hello");
//        sb.append(" ");
//        sb.append("world");
//        //.append(值)：把內容接到後面，這是直接修改自己，不是建立新物件
//        System.out.println(sb.toString());
//        //.toString()：轉回一般的 String 使用
//
//    }
//}

//用迴圈寫
//public class Day4 {
//    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 5; i++) {
//            sb.append(i);
//        }
//        System.out.println(sb);
//        StringBuilder sb2 = new StringBuilder("Hello World");
//        //其他功能
//        System.out.println(sb2.length());//長度
//        System.out.println(sb2.reverse());//反轉整個字串
//        StringBuilder sb3 = new StringBuilder("Hello World");
//
//        sb3.insert(5,",");//插入逗號
//        System.out.println(sb3);
//
//        sb3.delete(0,7);//刪除0-6(不含)的內容
//        System.out.println(sb3);
//
//    }
//}

//Arrays工具類

//import java.util.Arrays;
//
//public class Day4 {
//    public static void main(String[] args) {
//        int [] a={7,2,9,4,5};
//        //印出好讀的格式
//        System.out.println(Arrays.toString(a));
//        //排序 !直接修改原本的陣列
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
//        //比較兩個陣列內容是否相同
//        int [] b ={1,2,3,4};
//        int [] c ={1,2,3,4};
//        System.out.println(Arrays.equals(b,c));
//        //把一個陣列填滿同個值
//        int[] arr = new int[5];
//        Arrays.fill(arr,7);
//        System.out.println(Arrays.toString(arr));
//        //複製陣列
//        int [] original = {1,2,3};
//        int [] copy = Arrays.copyOf(original,5);//多出來補0
//        System.out.println(Arrays.toString(copy));
//        int [] copy2 = Arrays.copyOf(original,2);
////        System.out.println(Arrays.toString(copy2));
//    }
//}
