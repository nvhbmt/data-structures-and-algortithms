package LeetCode;

import java.util.Arrays;

public class _3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int result = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < diff) {
                    result = sum;
                    diff = Math.abs(sum - target);
                }
                if (sum < target) {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
