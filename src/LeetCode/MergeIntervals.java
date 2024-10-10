package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[1]);
        result.add(intervals[0]);
        for (int[] interval : intervals) {
            int lastInterval[] = result.getLast();
            if (lastInterval[1] >= interval[0]) {
                int newEnd = Math.max(lastInterval[1], interval[1]);
                result.set(result.size() - 1, new int[]{lastInterval[0], newEnd});
            } else {
                lastInterval = interval;
                result.add(lastInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
