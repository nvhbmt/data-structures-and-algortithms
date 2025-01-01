package LeetCode;

public class MaximumScoreAfterSplittingAString {
    private int countZero(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += c == '0' ? 1 : 0;
        }
        return count;
    }

    private int countOne(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += c == '1' ? 1 : 0;
        }
        return count;
    }

    public int maxScore(String s) {
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            result = Math.max(result, countZero(s.substring(0, i)) + countOne(s.substring(i)));
        }
        return result;
    }
}
