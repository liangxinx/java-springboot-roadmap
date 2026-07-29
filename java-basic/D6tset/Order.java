package D6tset;
//        ### Q7. static 計數器練習
//建立一個 `Order`（訂單）class：
//        - `private` 屬性：`orderId`（int）
//        - `static` 屬性：`orderCount`（記錄目前總共建立了幾筆訂單）
//        - 建構子：每次建立新訂單，`orderId` 就設成目前的 `orderCount + 1`，然後 `orderCount` 累加
//
//在 `Main` 裡連續建立 3 個訂單，印出每筆訂單的 `orderId`，確認是 1、2、3。
//
public class Order {
    private int orderId;
    static int orderCount = 0;

    public Order(){
        orderCount++;
        this.orderId=orderCount;
    }

    public int getOrderId() {
        return orderId;
    }
}
