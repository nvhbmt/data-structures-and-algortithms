package LeetCode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int length = right - left;
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, length * minHeight);
            while (left < right && height[left] <= minHeight) {
                left++;
            }

            while (left < right && height[right] <= minHeight) {
                right--;
            }
        }

        return max;
    }
}
