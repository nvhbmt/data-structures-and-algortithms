package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> currentArray = new ArrayList<>();
    private int[] candidates;
    private int target;


    public void dfs(int index, int currentSum) {
        if (currentSum > target) return;
        if (currentSum == target) {
            result.add(List.copyOf(currentArray));
            return;
        }
        for (int j = index; j < candidates.length; j++) {
            int candidate = candidates[j];
            currentArray.add(candidate);
            dfs(j, currentSum + candidate);
            currentArray.remove(currentArray.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        dfs(0, 0);
        return result;
    }
}
