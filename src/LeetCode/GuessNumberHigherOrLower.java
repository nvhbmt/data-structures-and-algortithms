package LeetCode;

public class GuessNumberHigherOrLower {
    private int guess(int num) {
        return 1;
    }

    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int num = guess(mid);
            if (num == 0) return mid;
            if (num == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
