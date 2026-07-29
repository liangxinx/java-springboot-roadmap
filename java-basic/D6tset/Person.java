package D6tset;
//建立一個 `Person` class：
//        - `private` 屬性：`name`（String）、`age`（int）
//        - 建構子傳入兩個屬性
//- 幫 `age` 寫 Setter，加入檢查：如果傳入的年齡小於 0 或大於 150，印出「年齡不合理」，不進行賦值
//- 幫兩個屬性都寫 Getter
//
//在 `Main` 裡建立一個 `Person`，測試合法跟不合理的年齡設定。
//
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0 || age>150){
            System.out.println("數值不合理，無法輸入");
            return;
        }
        this.age = age;
    }

    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }
}
