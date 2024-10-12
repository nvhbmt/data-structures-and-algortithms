package LeetCode;

import java.util.*;

public class AccountsMerge {

    private void dfs(Map<String, Set<String>> graph, String email, List<String> list, Set<String> visited) {
        list.add(email);
        visited.add(email);
        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, list, visited);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> owner = new HashMap<>();

        // build graph
        for (List<String> account : accounts) {
            String username = account.getFirst();
            Set<String> neighbors = new HashSet<>(account);
            neighbors.remove(username);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                graph.computeIfAbsent(email, k -> new HashSet<>()).addAll(neighbors);
                owner.put(email, username);
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> results = new ArrayList<>();

        // DFS search
        for (String email : owner.keySet()) {
            if (!visited.contains(email)) {
                List<String> result = new ArrayList<>();
                dfs(graph, email, result, visited);
                Collections.sort(result);
                result.addFirst(owner.get(email));
                results.add(result);
            }
        }

        return results;
    }
}
