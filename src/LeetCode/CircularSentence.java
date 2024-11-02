package LeetCode;

public class CircularSentence {
    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        for (int i = 0; i < n; i++) {
            if (i == n - 1 && sentence.charAt(0) != sentence.charAt(n - 1)) return false;
            if (sentence.charAt(i) == ' ') {
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) return false;
            }
        }
        return true;
    }
}
