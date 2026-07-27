package D5test;

public class Main {
    public static void main(String[] args) {
//        Book a = new Book("pig","Mr.wang",350.78);
//        Book b = new Book("aaa");
//        a.printInfo();
//        b.printInfo();
// 在 `Main` 裡建立一個 `Fruit[]` 陣列，裡面放 3 個不同的水果物件，用 `for` 迴圈把每個水果的名稱和價格印出來。
//        Fruit [] fruits = new Fruit[3];
//        fruits[0]=new Fruit("apple",20);
//        fruits[1]=new Fruit("banana",50);
//        fruits[2]=new Fruit("orange",15);
//        for (Fruit fruit : fruits){
//            System.out.println("水果"+fruit.name+"，價格"+fruit.price);
//        }
// 在 `Main` 裡建立一個帳戶，測試存錢、領錢（包含餘額不足的情況）、查詢餘額。
        BankAccount a = new BankAccount("liang");
        a.showBalance();
        a.deposit(300);
        a.showBalance();
        a.withdraw(700);
        a.withdraw(200);
        a.showBalance();
    }
}
