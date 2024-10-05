package Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SampleDFSWithStack {
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

        Stack<Integer> stack = new Stack<>();
        Set<Integer> setLooped = new HashSet<>();

        stack.add(0);
        setLooped.add(0);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            System.out.print(u + " ");
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] == 1 && !setLooped.contains(v)) {
                    stack.add(v);
                    setLooped.add(v);
                }
            }
        }
    }
}
