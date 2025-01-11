package LeetCode;

public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int countOfCharactorFreqOld = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) countOfCharactorFreqOld++;
        }

        return !(countOfCharactorFreqOld > k);
    }
}
