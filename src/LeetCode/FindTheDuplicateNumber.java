package LeetCode;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        boolean[] visited = new boolean[nums.length + 1];
        for (int n : nums) {
            if (visited[n]) {
                return n;
            }
            visited[n] = true;
        }
        return -1;
    }
}
