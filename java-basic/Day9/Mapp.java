package Day9;
import java.util.HashMap;
import java.util.Map;

public class Mapp {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("小王",85);
        scores.put("小莉",92);
        scores.put("小可",98);

        System.out.println(scores);
        System.out.println(scores.get("小王"));
        scores.put("小王",90);// key已存在，會直接覆蓋原本的value
        System.out.println(scores.get("小王"));

        System.out.println(scores.containsKey("小王"));
        System.out.println(scores.containsValue(100)); // false，是否存在這個value

        scores.remove("小王");
        System.out.println(scores);

        System.out.println(scores.size());

        System.out.println(scores.get("不存在的人"));  // null
//??
        int score = scores.getOrDefault("aaa",0);
        System.out.println(score);

//        遍歷 HashMap 的幾種方式
//      1 :遍歷所有的 key
        for (String name : scores.keySet()){
            System.out.println(scores.get(name));
        }
//      方法二：遍歷所有的 key-value 組合（更常用、更有效率）
        for (Map.Entry<String,Integer> entry : scores.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
