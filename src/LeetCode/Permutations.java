package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private void backtracking(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int num : nums) {
            if (tempList.contains(num)) continue;
            tempList.add(num);
            backtracking(result, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums);
        return result;
    }
}
