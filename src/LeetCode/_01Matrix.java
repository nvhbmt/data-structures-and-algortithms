package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _01Matrix {
    private class Pair {
        public int row;
        public int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean isValid(int i, int j, int row, int column) {
        return i >= 0 && j >= 0 && i < row && j < column;
    }

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] result = new int[row][col];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Pair(i, j));
                    result[i][j] = 0; // distance of the nearest 0 is 0
                } else {
                    result[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            int i = currentPair.row, j = currentPair.col;

            if (isValid(i + 1, j, row, col) && result[i + 1][j] == -1) {
                queue.add(new Pair(i + 1, j));
                result[i + 1][j] = result[i][j] + 1;
            }

            if (isValid(i - 1, j, row, col) && result[i - 1][j] == -1) {
                queue.add(new Pair(i - 1, j));
                result[i - 1][j] = result[i][j] + 1;
            }

            if (isValid(i, j + 1, row, col) && result[i][j + 1] == -1) {
                queue.add(new Pair(i, j + 1));
                result[i][j + 1] = result[i][j] + 1;
            }

            if (isValid(i, j - 1, row, col) && result[i][j - 1] == -1) {
                queue.add(new Pair(i, j - 1));
                result[i][j - 1] = result[i][j] + 1;
            }
        }

        return result;
    }
}
