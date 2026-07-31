package Day9;
import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.HashMap;
public class CollectionDemo {
    public static void main(String[] args) {
        // ArrayList：管理所有學生名字（有順序、可能重複姓名
        ArrayList<String> studentNames = new ArrayList<>();
        studentNames.add("小黃");
        studentNames.add("小華");
        studentNames.add("小美");
        //HashMap：用學生名字查成績
        HashMap<String,Integer> scores = new HashMap<>();
        scores.put("小黃",90);
        scores.put("小華",87);
        scores.put("小美",82);
        //HashSet：記錄有出席的學生（不會重複點名）
        HashSet<String> attendance = new HashSet<>();
        attendance.add("小黃");
        attendance.add("小美");
        attendance.add("小黃");

        System.out.println("學生成績單");

        for (String name : studentNames){
            int score = scores.getOrDefault(name,0);
            boolean present = attendance.contains(name);
            System.out.println(name+"成績:"+score+"有沒有出席"+present);
        }
        System.out.println("今日出席人數"+attendance.size());

    }
}
