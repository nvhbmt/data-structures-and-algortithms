package LeetCode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        int[] merge = new int[n];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                merge[k++] = nums1[i++];
            } else {
                merge[k++] = nums2[j++];
            }
        }
        while (i < n1) merge[k++] = nums1[i++];
        while (j < n2) merge[k++] = nums2[j++];

        if (n % 2 == 0) {
            return (merge[n / 2] + merge[n / 2 - 1]) / 2.0;
        } else {
            return (double) merge[n / 2];
        }
    }
}
