package LeetCode;

public class ValidSudoku {
    public boolean isValidRow(char[][] board, int row) {
        boolean[] appeared = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == '.') continue;
            int number = board[row][i] - '0';
            if (appeared[number]) return false;
            appeared[number] = true;
        }
        return true;
    }

    public boolean isValidColumn(char[][] board, int column) {
        boolean[] appeared = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == '.') continue;
            int number = board[i][column] - '0';
            if (appeared[number]) return false;
            appeared[number] = true;
        }
        return true;
    }

    public boolean isValidBlock(char[][] board, int i, int j) {
        boolean[] appeared = new boolean[10];
        for (int r = i; r < 9; r++) {
            for (int c = j; c < 9; c++) {
                if (board[i][j] == '.') continue;
                int number = board[i][j] - '0';
                if (appeared[number]) return false;
                appeared[number] = true;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) && !isValidColumn(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidBlock(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
