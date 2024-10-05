package Hash;

import java.util.HashMap;
import java.util.Map;

public class HashMapJava {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 3);
        map.put(1, 2);
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
