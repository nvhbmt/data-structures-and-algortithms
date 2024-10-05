package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0, start = 0;
        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            if (!set.contains(c)) {
                set.add(c);
                max = Math.max(max, set.size());
            } else {
                while (s.charAt(start) != s.charAt(end)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            int count = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (set.contains(c)) break;
                count++;
                set.add(c);
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
