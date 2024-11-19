package LeetCode;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones ^= num & (~twos);
            twos ^= num & (~ones);
        }
        return ones;
    }
}
