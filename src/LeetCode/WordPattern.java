package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] strArr = s.split("\\s");
        if (strArr.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = strArr[i];
            if (!map.containsKey(c) && !map.containsValue(strArr[i])) {
                map.put(c, str);
            } else if (map.containsKey(c) && !map.get(c).equals(str)) {
                return false;
            } else if (map.containsValue(str) && !map.containsKey(c)) {
                return false;
            }
        }

        return true;
    }
}
