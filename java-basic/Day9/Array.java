package Day9;
import java.util.ArrayList;

public class Array {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("aa");
        names.add("bb");
        names.add("cc");

//        用 for 迴圈遍歷 ArrayList
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        for (String name : names){
            System.out.println(name);
        }
//        裝物件的 ArrayList
//        ArrayList<Dog> dogs = new ArrayList<>();
//        dogs.add(new Dog("小白", 2, "柴犬"));
//        dogs.add(new Dog("阿黃", 3, "米克斯"));
//
//        for (Dog dog : dogs) {
//            dog.bark();
//        }

//        System.out.println(names);
//        System.out.println(names.size());//取得目前有幾個元素
//        System.out.println(names.get(0));//取得指定索引的元素
//        names.remove(1);// 移除索引1的元素（小華)
//        System.out.println(names);
//        names.set(0,"ff");// 把索引0的元素換成"阿明"
//        System.out.println(names);
//        System.out.println(names.contains("ff"));//判斷是否包含某個元素
//        names.clear();// 清空整個清單
//        System.out.println(names.isEmpty());//判斷是否為空
    }
}
