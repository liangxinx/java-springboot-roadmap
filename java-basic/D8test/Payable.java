package D8test;
//建立一個 `Payable` interface，裡面有一個方法 `double calculatePayment()`。
//建立兩個 class：`Freelancer`（自由接案者，依工時計費）和 `FullTimeEmployee`（正職員工，固定月薪），都實作 `Payable`，各自提供合理的 `calculatePayment()` 邏輯（屬性、建構子自訂）。

public interface Payable {
    double calculatePayment();
}
