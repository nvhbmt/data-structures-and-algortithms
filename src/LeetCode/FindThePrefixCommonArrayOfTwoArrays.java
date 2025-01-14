package LeetCode;

public class FindThePrefixCommonArrayOfTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] frequency = new int[A.length + 1];
        int[] result = new int[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            frequency[A[i]]++;
            if (frequency[A[i]] == 2) sum++;
            frequency[B[i]]++;
            if (frequency[B[i]] == 2) sum++;
            result[i] = sum;
        }

        return result;
    }
}
