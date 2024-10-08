package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotting = false;

            for (int i = 0; i < size && !queue.isEmpty(); i++) {
                Pair pair = queue.poll();

                if (pair.x + 1 < grid.length && grid[pair.x + 1][pair.y] == 1 && !visited[pair.x + 1][pair.y]) {
                    grid[pair.x + 1][pair.y] = 2;
                    visited[pair.x + 1][pair.y] = true;
                    hasRotting = true;
                    queue.add(new Pair(pair.x + 1, pair.y));
                }

                if (pair.y + 1 < grid[0].length && grid[pair.x][pair.y + 1] == 1 && !visited[pair.x][pair.y + 1]) {
                    grid[pair.x][pair.y + 1] = 2;
                    visited[pair.x][pair.y + 1] = true;
                    hasRotting = true;
                    queue.add(new Pair(pair.x, pair.y + 1));
                }

                if (pair.x - 1 >= 0 && grid[pair.x - 1][pair.y] == 1 && !visited[pair.x - 1][pair.y]) {
                    grid[pair.x - 1][pair.y] = 2;
                    visited[pair.x - 1][pair.y] = true;
                    hasRotting = true;
                    queue.add(new Pair(pair.x - 1, pair.y));
                }

                if (pair.y - 1 >= 0 && grid[pair.x][pair.y - 1] == 1 && !visited[pair.x][pair.y - 1]) {
                    grid[pair.x][pair.y - 1] = 2;
                    visited[pair.x][pair.y - 1] = true;
                    hasRotting = true;
                    queue.add(new Pair(pair.x, pair.y - 1));
                }
            }

            if (hasRotting) {
                count++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }
}
