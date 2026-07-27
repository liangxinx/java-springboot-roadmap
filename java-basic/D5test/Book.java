package D5test;
//建立一個 `Book` class，包含三個屬性：`title`（書名，String）、`author`（作者，String）、`price`（價格，double）。
// 寫一個建構子可以一次傳入這三個資料。再寫一個 `printInfo()` method，印出這本書的完整資訊。
//延續 Q6 的 `Book` class，再新增一個**只有 `title` 一個參數**的建構子，
// `author` 預設為 `"未知"`，`price` 預設為 `0`。在 `Main` 裡分別用兩種方式建立 `Book` 物件並印出資訊，確認兩種建構子都能正常運作。
public class Book {
    String title;
    String author;
    double price;

    public Book (String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public Book(String title){
        this(title,"未知",0);
    }
    public void printInfo(){
        System.out.println("書名:"+title+"作者"+author+"價格"+price);
    }
}
