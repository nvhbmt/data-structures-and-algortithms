package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    private boolean isEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        int[] countP = new int[26];
        int[] countS = new int[26];
        if (sLength < pLength) return result;
        for (int i = 0; i < pLength; i++) {
            countP[p.charAt(i) - 'a']++;
            countS[s.charAt(i) - 'a']++;
        }

        if (isEqual(countP, countS)) {
            result.add(0);
        }
        for (int i = pLength; i < sLength; i++) {
            countS[s.charAt(i) - 'a']++;
            countS[s.charAt(i - pLength) - 'a']--;
            if (isEqual(countP, countS)) {
                result.add(i - pLength + 1);
            }
        }
        return result;
    }
}
