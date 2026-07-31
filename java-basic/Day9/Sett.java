package Day9;
import java.util.HashSet;
import java.util.ArrayList;
public class Sett {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>();

        names.add("小明");
        names.add("小華");
        names.add("小明"); // 重複加入，會被自動忽略

        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.contains("小明"));
        names.remove("小明");
        System.out.println(names.size());
        System.out.println(names.isEmpty());

        //    用 for-each 遍歷
        for(String name:names){
            System.out.println(name);
        }

        //實用場景：去除陣列/清單裡的重複資料
        ArrayList<String> ns = new ArrayList<>();
        ns.add("a");
        ns.add("a");
        ns.add("c");
        ns.add("c");
        ns.add("b");
        ns.add("b");
        HashSet<String> uns = new HashSet<>(ns);
        System.out.println(uns);
    }
}
