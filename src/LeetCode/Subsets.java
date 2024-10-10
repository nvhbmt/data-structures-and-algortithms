package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            backtracking(list, tempList, nums, i + 1);
            tempList.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), nums, 0);
        return list;
    }
}
