package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        int i = 0, j = 0;
        while (j < n) {
            if (j < n - 1 && nums[j] == nums[j + 1] - 1) {
                j++;
            } else {
                if (i == j) {
                    result.add(String.valueOf(nums[i]));
                } else {
                    result.add(nums[i] + "->" + nums[j]);
                }
                j++;
                i = j;
            }
        }
        return result;
    }
}
