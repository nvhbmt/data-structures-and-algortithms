package LeetCode;

public class BitwiseXOROfAllPairings {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int result = 0;
        int len1 = nums1.length, len2 = nums2.length;
        if (len2 % 2 == 1) {
            for (int num : nums1)
                result ^= num;
        }
        if (len1 % 2 == 1) {
            for (int num : nums2)
                result ^= num;
        }
        return result;
    }
}
