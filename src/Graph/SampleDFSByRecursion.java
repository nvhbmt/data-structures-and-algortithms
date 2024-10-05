package Graph;

import java.util.HashSet;
import java.util.Set;

public class SampleDFSByRecursion {

    public static void DFS(int u, int[][] graph, Set<Integer> setLooped) {
        System.out.print(u + " ");

        for (int v = graph.length - 1; v >= 0; v--) {
            if (graph[u][v] == 1 && !setLooped.contains(v)) {
                setLooped.add(v);
                DFS(v, graph, setLooped);
            }
        }
    }

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

        Set<Integer> setLooped = new HashSet<>();

        setLooped.add(0);

        DFS(0, graph, setLooped);
    }
}
