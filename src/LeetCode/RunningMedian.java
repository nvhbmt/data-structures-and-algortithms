package LeetCode;

import java.util.*;

public class RunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> result = new ArrayList<>();
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // Write your code here
        result.add(a.get(0) * 1.0);
        maxHeap.add(a.get(0));
        for (int i = 1; i < a.size(); i++) {
            int current = a.get(i);

            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(current);
            } else {
                maxHeap.add(current);
            }

            // validate
            if (maxHeap.peek() > minHeap.peek()) {
                int smaller = minHeap.poll();
                int bigger = maxHeap.poll();
                maxHeap.add(smaller);
                minHeap.add(bigger);
            }

            if (maxHeap.size() > minHeap.size()) {
                result.add(maxHeap.peek() * 1.0);
            } else {
                result.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            }
        }
        return result;
    }
}
