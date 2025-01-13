package LeetCode;

public class MinimumLengthOfStringAfterOperations {
    public int minimumLength(String s) {
        int count[] = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int minimum = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] >= 3) {
                count[i] = count[i] % 2 == 1 ? 1 : 2;
            }
            minimum += count[i];
        }
        return minimum;
    }
}
