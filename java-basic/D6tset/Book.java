package D6tset;
//建立一個 `Book` class：
//        - `private` 屬性：`title`（書名）、`isBorrowed`（是否已被借出，boolean，預設 `false`）
//        - `static` 屬性：`totalBooks`（記錄總共建立了幾本書）
//        - 建構子：只需要傳入 `title`，`isBorrowed` 一律從 `false` 開始，`totalBooks` 累加
//- method `borrow()`：如果 `isBorrowed` 是 `true`，印出「已被借出，無法借閱」；否則把 `isBorrowed` 設成 `true`，印出「借閱成功」
//        - method `returnBook()`：把 `isBorrowed` 設回 `false`，印出「歸還成功」
//        - Getter：`getTitle()`、`isBorrowed()`
//
//在 `Main` 裡建立 2 本書，測試借閱、重複借閱（應該失敗）、歸還後再借閱（應該成功），最後印出 `Book.totalBooks` 確認總數正確。
//
public class Book {
    private String title;
    private boolean isBorrowed;

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    static int totalBooks=0;

    public Book(String title){
        totalBooks++;
        this.title=title;
        this.isBorrowed=false;
    }
    public void borrow(){
        if(isBorrowed){
            System.out.println("已被借出，無法借閱");
        }else {
            isBorrowed = true;
            System.out.println(title+"借閱成功");
        }
    }
    public void returnBook(){
        isBorrowed = false;
        System.out.println(title+"歸還成功");
    }

}
