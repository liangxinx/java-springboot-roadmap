package Day9;

import java.util.LinkedList;

public class Linked {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("aa");
        names.add("b");
        names.add("cc");

        System.out.println(names);
        System.out.println(names.get(0));
        names.remove(1);
        System.out.println(names);
    }
}
