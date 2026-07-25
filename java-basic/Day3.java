//method
//public class Day3 {
//    public static void sayHello() {
//        System.out.println("hello");
//    }
//    public static void divider(){
//        System.out.println("---------");
//    }
//    public static void main(String[] args) {
//        sayHello();
//        divider();
//    }
//}

//Parameter

//public class Day3 {
//    public static void sayHello(String name,int age){
//        System.out.println("hello "+name+",your age is:"+age);
//    }
//
//    public static void printSum(int a , int b){
//        System.out.println(a+b);
//    }
//
//    public static void main(String[] args) {
//        sayHello("baby",10);
//        sayHello("honey",30);
//        printSum(4,6);
//    }
//}
//return
//
//public class Day3 {
//
//    public static double add(int a,int b){
//        return a+b;
//    }
//    public static boolean isAdult(int age){
//        return age >=18;
//    }
//    public static boolean isEvent(int num){
//        return num%2 == 0;
//    }
//    public static void main(String[] args) {
//        double result = add(3,5);
//        double result2=add(3,4)/2;
//        System.out.println(result);
//        System.out.println(result2);
//        boolean a = isAdult(20);
//        System.out.println(a);
//        System.out.println(isAdult(10));
//
//        boolean b =isEvent(7);
//        System.out.println(b);
//    }
//}

////mothod 呼叫流程
//
//public class Day3 {
//
//    public static int square(int n) {
//        return n * n;
//    }
//
//    public static int sumOfSquares(int a, int b) {
//        int s1 = square(a); // 呼叫 square
//        int s2 = square(b); // 再呼叫一次 square
//        return s1 + s2;
//    }
//
//    public static void main(String[] args) {
//        int result = sumOfSquares(3, 4);
//        System.out.println("結果: " + result); // 9 + 16 = 25
//    }
//}

// method Overloading

//public class Day3 {
//    public static int add(int a , int b ){
//        return a+b;
//    }
//    public static double add(double a , double b ){
//        return a+b;
//    }
//    public static int add(int a , int b ,int c){
//        return a+b+c;
//    }
//
//    public static String miltiply(String s,int times){
//        String result="";
//        for (int i=0;i<times;i++){
//            result +=s;
//        }
//        return result;
//    }
//    public static void main(String[] args) {
//        System.out.println(add(3,5));
//        System.out.println(add(3,5,6));
//        System.out.println(add(3.6,5.3));
//        System.out.println(miltiply("hhh",2));
//    }
//}

//array

//public class Day3 {
//    public static void main(String[] args) {
//        int[] scores={90,88,40,50,86};
////        System.out.println(scores[0]);
////        System.out.println(scores[4]);
////        System.out.println(scores.length);
//        for (int i=0;i<scores.length;i++){
//            System.out.println("第"+(i+1)+"項是:"+scores[i]);
//        }
//    }
//}
//for each
//public class Day3 {
//
//    public static void main(String[] args) {
//        int[] scores={90,88,40,50,86};
////        System.out.println(scores[0]);
////        System.out.println(scores[4]);
////        System.out.println(scores.length);
////        for (int score:scores){
////            System.out.println(score);
////        }//從 scores 裡 一個一個拿元素放進 score
//    }
//}

//public class Day3 {
//    public static int sumArray(int[] arr){
//        int sum = 0;
//        for (int num : arr){
//            sum += num;
//        }
//        return sum;
//    }
//    public static void main(String[] args) {
//        System.out.println(sumArray(new int[]{1,2,3,4,5}));
//    }
////}
//
//public class Day3 {
//    public static int sumArray(int[] arr){
//        int sum = 0;
//        for (int num : arr){
//            sum += num;
//        }
//        return sum;
//    }
//    public static void main(String[] args) {
//        int[] scores={90,88,40,50,86};
//        for (int i=0;i<scores.length;i++){
//            System.out.println("第"+(i+1)+"項是:"+scores[i]);
//        }
//        int total=sumArray(scores);
//        double avg=(double)total/scores.length;
//
//        System.out.println(total);
//        System.out.println(avg);
//    }
//}

//二維陣列
//public class Day3 {
//
//    public static void main(String[] args) {
//        int [][] scores={
//                {90,40,50,60},
//                {89,47,88,53},
//                {20,59,69,75}
//        };
//        System.out.println(scores.length);
//        System.out.println(scores[0].length);//代表第 0 列裡有 ? 個元素（? 欄）
//        System.out.println(scores[0][0]);
//        //輸出整個陣列
//        for(int i=0;i<scores.length;i++){
//            for(int j=0;j<scores[0].length;j++){
//                System.out.print(scores[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
//}

//列出每一列的總分
//public class Day3 {
//    public static int sumRow(int [] row){
//        int sum =0;
//        for(int num : row){
//            sum+=num;
//        }
//        return sum;
//    }
//    public static void main(String[] args) {
//        int [][]scores={
//                {20,30,40},
//                {50,60,70},
//                {80,90,100}
//        };
//        for (int i = 0; i < scores.length; i++) {
//            int rowTotal=sumRow(scores[i]);
//            System.out.println(rowTotal);
//        }
//    }
//}

//public class Day3 {
//
//    public static int sumRow(int[] row) {
//        int sum = 0;
//        for (int num : row) {
//            sum += num;
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) {
//        int[][] scores = {
//                {90, 85, 78},
//                {88, 76, 95},
//                {70, 82, 91},
//        };

        // 印出整個表格
//        for (int i = 0; i < scores.length; i++) {
//            for (int j = 0; j < scores[i].length; j++) {
//                System.out.print(scores[i][j] + "\t");//t=tab
//            }
//            System.out.println();
//        }
//        System.out.println("------");
//        // 每列的總分
//        for (int i = 0; i < scores.length; i++) {
//            System.out.println(sumRow(scores[i]));
//        }
//    }
//}

public class Day3 {
    public static void main(String[] args) {
        int[][] scores={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int numCols = scores[0].length;

        for (int j = 0; j < numCols; j++) {
            int colTotal=0;
            for (int i=0;i<scores.length;i++){
                colTotal+=scores[i][j];
                System.out.println("i=" + i + ", j=" + j);
            }
            System.out.println(colTotal);
        }
    }
}





