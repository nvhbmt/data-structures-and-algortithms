package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> currentArray = new ArrayList<>();
    private boolean[] visited;
    private int[] candidates;
    private int target;


    public void dfs(int index, int currentSum) {
        if (currentSum > target) return;
        if (currentSum == target) {
            result.add(List.copyOf(currentArray));
            return;
        }
        for (int j = index; j < candidates.length; j++) {
            if (visited[j] || j > index && candidates[j - 1] == candidates[j] && !visited[j - 1]) continue;
            int candidate = candidates[j];
            currentArray.add(candidate);
            visited[j] = true;
            dfs(j, currentSum + candidate);
            visited[j] = false;
            currentArray.remove(currentArray.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        this.visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(0, 0);
        return result;
    }
}
