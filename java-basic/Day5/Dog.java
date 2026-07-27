package Day5;

public class Dog {
    //屬性 描述物件有什麼資料 寫在class裡面，method外面。
    String name;
    int age;
    String breed;
    //建構子
//    public Dog(String dName,int dAge,String dBreed){
//        name=dName;
//        age=dAge;
//        breed=dBreed;
//    }
    //this 作用
    public Dog(String name,int age){
        this.name=name;// this.name 是屬性，右邊的 name 是參數
        this.age=age;
    }
    public Dog(){

    }
    // 沒有static 為什麼?  看筆記
    public void bark (){
        System.out.println(name+"汪汪");
    }

    public boolean isAdult(){
        return age>=2;
    }

    public void celecbrate(){
        age = age+1;
        System.out.println("生日快樂!"+age+"歲了呢");
    }
}


//Constructor Chaining
//public class Dog {
//    String name;
//    int age;
//    String breed;
//
//    public Dog(String name, int age, String breed) {
//        this.name = name;
//        this.age = age;
//        this.breed = breed;
//    }
//
//    public Dog(String name, int age) {
//        this(name, age, "未知"); // 呼叫上面三個參數的版本，補上預設品種
//    }
//
//    public Dog() {
//        this("未命名", 0, "未知"); // 呼叫三個參數的版本，全部用預設值
//    }
//}
