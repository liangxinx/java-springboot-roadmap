package Day7;

public class Main {
    public static void main(String[] args) {
//        Dog a = new Dog("a",3,"a");
//        a.brak();
//        a.eat();
//        a.sleep();
//        Cat b = new Cat("咪咪",5);
//        b.eat();

        //多型的寫法
//        Animal a = new Dog("阿福",3,"柴犬");
//        Animal b = new Cat("咪咪",4);
//        a.eat();
//        b.sleep();

        //多型的迴圈陣列
        Animal [] animals = new Animal[3];
        animals[0]=new Dog("阿福",5,"柯基");
        animals[1]=new Dog("阿凱",2,"柯基");
        animals[2]=new Cat("咪咪",2);

        for (Animal a : animals){
            a.eat();
            if(a instanceof Dog dog){
                dog.brak();
            }
        }
        //instanceof
//        Animal a = new Dog("阿奇",6,"馬爾濟斯");
//        System.out.println(a instanceof Dog);
//        if (a instanceof Dog){
//            Dog dog1 = (Dog) a;// 向下轉型：把 Animal 型態強制轉回 Dog 型態
//            dog1.brak();
//        }
//        //Pattern Matching for instanceof
//        Animal b = new Dog("阿標",6,"馬爾濟斯");
//        if (b instanceof Dog dog2){
//            dog2.brak();
//        }
    }
}
