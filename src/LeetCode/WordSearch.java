package LeetCode;

import java.util.HashMap;

public class WordSearch {
    private boolean dfs(char[][] board, boolean[][] isVisited, String word, int index, int i, int j) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || isVisited[i][j] || board[i][j] != word.charAt(index))
            return false;
        isVisited[i][j] = true;
        boolean result = dfs(board, isVisited, word, index + 1, i + 1, j)
                || dfs(board, isVisited, word, index + 1, i - 1, j)
                || dfs(board, isVisited, word, index + 1, i, j + 1)
                || dfs(board, isVisited, word, index + 1, i, j - 1);
        isVisited[i][j] = false;
        return result;
    }

    public boolean exist(char[][] board, String word) {
        // sort by count char to optimize time dfs
        HashMap<Character, Integer> countFreq = new HashMap<>();
        for (char c : word.toCharArray()) {
            countFreq.put(c, countFreq.getOrDefault(c, 0) + 1);
        }
        if (countFreq.getOrDefault(word.charAt(0), 0) > countFreq.getOrDefault(word.charAt(word.length() - 1), 0)) {
            word = new StringBuilder(word).reverse().toString();
        }

        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, isVisited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
