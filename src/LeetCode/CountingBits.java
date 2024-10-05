package LeetCode;

import java.util.Arrays;

public class CountingBits {
    private static int countBit(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) count++;
            n /= 2;
        }
        return count;
    }

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = countBit(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
