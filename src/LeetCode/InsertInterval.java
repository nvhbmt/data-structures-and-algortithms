package LeetCode;

import java.util.*;

public class InsertInterval {
    private static class Interval implements Comparable<Interval> {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.start, o.start);
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Queue<Interval> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            queue.add(new Interval(interval[0], interval[1]));
        }
        queue.add(new Interval(newInterval[0], newInterval[1]));
        List<int[]> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Interval interval = queue.poll();
            System.out.println("Current: " + "[" + interval.start + "," + interval.end + "]");
            if (!queue.isEmpty()) {
                Interval nextInterval = queue.peek();
                if (interval.end >= nextInterval.start) {
                    if (interval.end >= nextInterval.end) {
                        Interval removedInterval = queue.poll();
                        System.out.println("Remove: " + "[" + removedInterval.start + "," + removedInterval.end + "]");
                        queue.add(interval);
                        System.out.println("Add back: " + "[" + interval.start + "," + interval.end + "]");
                        continue;
                    } else {
                        queue.poll();
                        System.out.println("Duplicate: " + "[" + interval.start + "," + interval.end + "]" + " - "
                                + "[" + nextInterval.start + "," + nextInterval.end + "]");
                        Interval mergeInterval = new Interval(Math.min(interval.start, nextInterval.start), Math.max(interval.end, nextInterval.end));

                        queue.add(mergeInterval);
                        System.out.println("Add: " + "[" + mergeInterval.start + "," + mergeInterval.end + "]");
                        continue;
                    }
                }
            }
            result.add(new int[]{
                    interval.start, interval.end
            });
        }
        int[][] output = new int[result.size()][];
        int index = 0;
        for (int[] item : result) {
            output[index++] = item;
        }

        return output;
    }

    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<int[]> result = new ArrayList<>();
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && newInterval[0] >= intervals[i][1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
}
