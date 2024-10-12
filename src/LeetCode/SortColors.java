package LeetCode;

public class SortColors {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count[n] > 0) {
                nums[i] = n;
                count[n]--;
            } else {
                n++;
                i--;
            }
        }
    }
}
