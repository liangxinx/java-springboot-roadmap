package Day8;

public class Finally {
    public static void divid(int a, int b) {
        try {
            System.out.println("嘗試計算"+a+"/"+b);
            int result = a/b;
            System.out.println("結果:"+result);
        }catch (ArithmeticException e){
            System.out.println("錯誤");
        }finally {
            System.out.println("本次計算結束");
        }
    }

    public static void main(String[] args){
        divid(10,2);
        divid(10,0);
    }
}
