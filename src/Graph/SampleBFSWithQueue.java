package Graph;

import java.util.*;

public class SampleBFSWithQueue {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0}
        };

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> setLooped = new HashSet<>();

        queue.add(0);
        setLooped.add(0);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] == 1 && !setLooped.contains(v)) {
                    queue.add(v);
                    setLooped.add(v);
                }
            }
        }
    }

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        int[][] distances = new int[n + 1][n + 1];
        int[] bfsDistances = new int[n + 1];

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            distances[u][v] = 6;
            distances[v][u] = 6;
        }

        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        bfsDistances[s] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && distances[currentNode][i] != 0) {
                    visited[i] = true;
                    bfsDistances[i] = bfsDistances[currentNode] + distances[currentNode][i];
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            if (bfsDistances[i] != 0)
                result.add(bfsDistances[i]);
            else
                result.add(-1);
        }


        return result;
    }
}
