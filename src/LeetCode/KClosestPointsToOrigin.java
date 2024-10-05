package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    private class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return Double.compare(distanceToOrigin(this), distanceToOrigin(o));
        }
    }

    private static double distanceToOrigin(Point point) {
        return Math.sqrt(point.x * point.x + point.y * point.y);
    }

    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> queue = new PriorityQueue<>();
        List<int[]> result = new ArrayList<>();
        for (int[] point : points) {
            queue.add(new Point(point[0], point[1]));
        }

        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            Point point = queue.poll();
            result.add(new int[]{point.x, point.y});
        }

        return result.toArray(new int[result.size()][]);
    }
}
