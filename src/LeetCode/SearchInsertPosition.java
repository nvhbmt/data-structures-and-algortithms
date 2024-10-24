package LeetCode;

public class SearchInsertPosition {
    private int binarySearch(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (mid > 0 && nums[mid - 1] < target && target < nums[mid]) return mid;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        return binarySearch(nums, target);
    }
}
