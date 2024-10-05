package Graph;

import java.util.*;

public class MyDijkstra {
    public static void main(String[] args) {
        int n = 5;
        int[][] graph = {
                {0, 6, 0, 1, 0},
                {6, 0, 5, 2, 2},
                {0, 5, 0, 0, 5},
                {1, 2, 0, 0, 1},
                {0, 2, 5, 1, 0}
        };


        Set<Integer> visited = new HashSet<>();
        int[] distance = new int[n];
        int[] previous = new int[n];

        int start = 0;
        int end = 2;
        int oo = Integer.MAX_VALUE;

        // init distance
        Arrays.fill(distance, oo);
        distance[start] = 0;

        while (visited.size() < n) {
            int currentIndex = 0;
            int minDistance = oo;

            // Find the next node with the smallest unvisited distance
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i) && distance[i] < minDistance) {
                    minDistance = distance[i];
                    currentIndex = i;
                }
            }

            // Update the shortest distances to all neighbors of the current node
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i) && graph[currentIndex][i] != 0) {
                    int newDistance = distance[currentIndex] + graph[currentIndex][i];
                    if (newDistance < distance[i]) {
                        distance[i] = newDistance;
                        previous[i] = currentIndex;
                    }
                }
            }

            visited.add(currentIndex);
        }

        System.out.println("Distance from " + start + " to " + end + ": " + distance[end]);

        int run = end;
        while (run != start) {
            System.out.print(run + " <- ");
            run = previous[run];
        }
        System.out.print(run);

    }

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        boolean[] visited = new boolean[n + 1];

        int[][] distances = new int[n + 1][n + 1];

        int[] shortestDistances = new int[n + 1];
        Arrays.fill(shortestDistances, Integer.MAX_VALUE);
        shortestDistances[s] = 0;

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int distance = edge.get(2);
            if (distances[u][v] == 0 || distances[u][v] > distance) {
                distances[u][v] = distance;
                distances[v][u] = distance;
            }
        }

        int current = s;
        while (current != -1) {
            visited[current] = true;


            for (int i = 1; i <= n; i++) {
                if (!visited[i] && distances[current][i] != 0) {
                    int newDistance = shortestDistances[current] + distances[current][i];
                    if (newDistance < shortestDistances[i]) {
                        shortestDistances[i] = newDistance;
                    }
                }
            }

            current = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (shortestDistances[i] < minDistance && !visited[i]) {
                    minDistance = shortestDistances[i];
                    current = i;
                }
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            if (shortestDistances[i] == Integer.MAX_VALUE) {
                result.add(-1);
            } else {
                result.add(shortestDistances[i]);
            }
        }

        return result;
    }


    public static List<Integer> shortestReach2(int n, List<List<Integer>> edges, int s) {
        boolean[] visited = new boolean[n + 1];
        int[][] distances = new int[n + 1][n + 1];
        int[] shortestDistances = new int[n + 1];
        List<Integer>[] neighbors = new LinkedList[n + 1];

        Arrays.fill(shortestDistances, Integer.MAX_VALUE);


        for (int i = 1; i <= n; i++) {
            neighbors[i] = new LinkedList<>();
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int distance = edge.get(2);
            if (distances[u][v] == 0) {
                neighbors[u].add(v);
                neighbors[v].add(u);
            }
            if (distances[u][v] == 0 || distances[u][v] > distance) {
                distances[u][v] = distance;
                distances[v][u] = distance;
            }
        }

        int current = s;
        shortestDistances[s] = 0;
        visited[current] = true;

        while (current != -1) {
            for (int i : neighbors[current]) {
                if (!visited[i] && distances[current][i] != 0) {
                    int newDistance = shortestDistances[current] + distances[current][i];
                    if (newDistance < shortestDistances[i]) {
                        shortestDistances[i] = newDistance;
                    }
                }
            }

            visited[current] = true;

            current = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (shortestDistances[i] < minDistance && !visited[i]) {
                    minDistance = shortestDistances[i];
                    current = i;
                }
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            if (shortestDistances[i] == Integer.MAX_VALUE) {
                result.add(-1);
            } else {
                result.add(shortestDistances[i]);
            }
        }

        return result;
    }

    private static class Node implements Comparable {
        public int index;
        public int shortestPath;
        public List<Integer> neighbors;
        public boolean isVisited;

        public Node(int i) {
            this.index = i;
            this.shortestPath = Integer.MAX_VALUE;
            this.neighbors = new LinkedList<>();
            this.isVisited = false;

        }

        @Override
        public int compareTo(Object o) {
            Node other = (Node) o;
            return Integer.compare(this.shortestPath, other.shortestPath);
        }
    }

    public static List<Integer> shortestReach3(int n, List<List<Integer>> edges, int s) {
        int[][] distances = new int[n + 1][n + 1];
        Node[] nodes = new Node[n + 1];
        Queue<Node> minHeap = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int distance = edge.get(2);
            if (distances[u][v] == 0) {
                nodes[u].neighbors.add(v);
                nodes[v].neighbors.add(u);
            }
            if (distances[u][v] == 0 || distances[u][v] > distance) {
                distances[u][v] = distance;
                distances[v][u] = distance;
            }
        }

        int current = s;
        nodes[current].shortestPath = 0;
        nodes[current].isVisited = true;


        while (current != -1) {
            for (int i : nodes[current].neighbors) {
                if (!nodes[i].isVisited && distances[current][i] != 0) {
                    int newDistance = nodes[current].shortestPath + distances[current][i];
                    if (newDistance < nodes[i].shortestPath) {
                        minHeap.remove(nodes[i]);
                        nodes[i].shortestPath = newDistance;
                        minHeap.add(nodes[i]);
                    }
                }
            }

            nodes[current].isVisited = true;

            current = -1;

            while (!minHeap.isEmpty() && minHeap.peek().isVisited) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                current = minHeap.poll().index;
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            if (nodes[i].shortestPath == Integer.MAX_VALUE) {
                result.add(-1);
            } else {
                result.add(nodes[i].shortestPath);
            }
        }

        return result;
    }

}
