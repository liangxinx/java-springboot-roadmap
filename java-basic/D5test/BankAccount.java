package D5test;
//建立一個 `BankAccount` class：
//        - 屬性：`owner`（帳戶名稱）、`balance`（餘額，double）
//        - 建構子：傳入 `owner`，`balance` 一律從 0 開始
//- method `deposit(double amount)`：存錢，把 `amount` 加進 `balance`
//- method `withdraw(double amount)`：領錢，如果 `amount` 大於 `balance`，印出「餘額不足」，不執行扣款；否則扣款成功
//- method `showBalance()`：印出目前餘額
public class BankAccount {
    String owner;
    double balance;
    public BankAccount(String owner){
        this.owner=owner;
        this.balance=0;
    }
    public double deposit(double amount){
        balance += amount;
        System.out.println("存款成功");
        return balance;
    }
    public double withdraw(double amount){
        if (amount>balance){
            System.out.println("餘額不足，不能扣款");
        }else{
            balance -= amount;
            System.out.println("扣款成功");
        }
        return balance;
    }
    public void showBalance(){
        System.out.println("您的餘額為:"+balance);
    }
}
