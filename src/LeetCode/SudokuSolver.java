package LeetCode;

public class SudokuSolver {
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
        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++) {
                if (board[r][c] == '.') continue;
                int number = board[r][c] - '0';
                if (appeared[number]) return false;
                appeared[number] = true;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i)) {
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

    public boolean isValidValue(char[][] board, int i, int j, char value) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == value || board[k][j] == value) return false;
        }

        int iStart = (i / 3) * 3;
        int jStart = (j / 3) * 3;

        for (int k = iStart; k < iStart + 3; k++) {
            for (int l = jStart; l < jStart + 3; l++) {
                if (board[k][l] == value) return false;
            }
        }

        return true;
    }

    private boolean isFound = false;
    private char[][] result = new char[9][9];

    private void copyTo(char[][] a, char[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                b[i][j] = a[i][j];
            }
        }
    }

    public void backtrackingToNext(char[][] board, int i, int j) {
        if (j == 8) {
            i += 1;
            j = 0;
        } else {
            j++;
        }
        backtracking(board, i, j);
    }

    public void backtracking(char[][] board, int i, int j) {
        if (i > 8 || isFound) return;
        if (board[i][j] == '.') {
            for (char c = '1'; c <= '9' && !isFound; c++) {
                if (!isValidValue(board, i, j, c)) continue;
                board[i][j] = c;
                if (i == 8 && j == 8) {
                    if (isValidSudoku(board)) {
                        copyTo(board, this.result);
                        isFound = true;
                        return;
                    }
                } else {
                    backtrackingToNext(board, i, j);
                }

            }
            board[i][j] = '.';
        } else {
            if (i == 8 && j == 8) {
                if (isValidSudoku(board)) {
                    copyTo(board, this.result);
                    isFound = true;
                    return;
                }
            } else if (!isFound) {
                backtrackingToNext(board, i, j);
            }
        }

    }


    public void solveSudoku(char[][] board) {
        backtracking(board, 0, 0);
        copyTo(this.result, board);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board);
    }
}

