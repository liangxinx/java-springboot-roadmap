package Day8;

public class TryCatch {
    public static void main(String[] args){
        System.out.println("=== 測試1: 除以0 ===");
        try {
            int result = 10/0;
            System.out.println("結果"+result);
        }catch (ArithmeticException e){
            System.out.println("發生錯誤"+e.getMessage());
        }

        System.out.println("=== 測試2: 陣列越界 ===");
        try {
            int[] nums = {1,2,3};
            System.out.println(nums[5]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("發生錯誤:"+e.getMessage());
        }
        System.out.println("正常結束");
    }
}
