package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public void dfs(Node originalNode, Node cloneNode, Node[] visited) {
        visited[cloneNode.val] = cloneNode;
        for (Node neighbor : originalNode.neighbors) {
            if (visited[neighbor.val] == null) {
                Node newNode = new Node(neighbor.val);
                cloneNode.neighbors.add(newNode);
                dfs(neighbor, newNode, visited);
            } else {
                cloneNode.neighbors.add(visited[neighbor.val]);
            }
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        Node cloneNode = new Node(node.val);
        dfs(node, cloneNode, visited);
        return cloneNode;
    }
}
