package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestReach {
    private static class Node implements Comparable {
        public int index;
        public int shortestPath;
        public boolean isVisited;
        public List<Integer> neighbors;

        Node(int index) {
            this.index = index;
            this.shortestPath = Integer.MAX_VALUE;
            this.isVisited = false;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public int compareTo(Object o) {
            Node other = (Node) o;
            return Integer.compare(this.shortestPath, other.shortestPath);
        }
    }

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        List<Integer> result = new ArrayList<>();
        Node[] nodes = new Node[n + 1];
        int[][] distance = new int[n + 1][n + 1];
        Queue<Node> queue = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (List<Integer> egde : edges) {
            int u = egde.get(0);
            int v = egde.get(1);
            int length = egde.get(2);
            if (distance[u][v] == 0) {
                nodes[u].neighbors.add(v);
                nodes[v].neighbors.add(u);
            }
            if (distance[u][v] == 0 || distance[u][v] > length) {
                distance[u][v] = length;
                distance[v][u] = length;
            }
        }

        int current = s;
        nodes[current].isVisited = true;
        nodes[current].shortestPath = 0;

        while (current != -1) {
            for (int i : nodes[current].neighbors) {
                if (!nodes[i].isVisited && distance[current][i] != 0) {
                    int newDistance = nodes[current].shortestPath + distance[current][i];
                    if (newDistance < nodes[i].shortestPath) {
                        queue.remove(nodes[i]);
                        nodes[i].shortestPath = newDistance;
                        queue.add(nodes[i]);
                    }
                }
            }

            nodes[current].isVisited = true;

            current = -1;
            while (!queue.isEmpty() && queue.peek().isVisited) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                current = queue.poll().index;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (s == i) continue;
            if (nodes[i].shortestPath != Integer.MAX_VALUE) {
                result.add(nodes[i].shortestPath);
            } else {
                result.add(-1);
            }
        }

        return result;
    }
}
