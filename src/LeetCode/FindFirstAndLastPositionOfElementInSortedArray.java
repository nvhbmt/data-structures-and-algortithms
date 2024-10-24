package LeetCode;

public class FindFirstAndLastPositionOfElementInSortedArray {
    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target);
        int end = start;
        while (start > 0 && nums[start] == nums[start - 1]) start--;
        while (end > 0 && end < nums.length - 1 && nums[end] == nums[end + 1]) end++;
        return new int[]{start, end};
    }
}
