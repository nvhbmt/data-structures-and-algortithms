package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();
        for (String word : words) {
            for (String w : words) {
                if (!word.equals(w) && word.contains(w)) {
                    result.add(w);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
