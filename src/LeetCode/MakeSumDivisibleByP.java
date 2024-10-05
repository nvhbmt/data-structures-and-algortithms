package LeetCode;

public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int[] sums = new int[n];

        sums[0] = nums[0];

        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        

        return 0;
    }
}
