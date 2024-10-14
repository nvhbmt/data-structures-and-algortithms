package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        int[][] nextStep = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int step = 0;
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (!visited[i][j]) {
            int[] currentStep = nextStep[step];
            visited[i][j] = true;
            result.add(matrix[i][j]);
            int newI = i + currentStep[0];
            int newJ = j + currentStep[1];

            if (newI < 0 || newI == n || newJ < 0 || newJ == m || visited[newI][newJ]) {
                step = step + 1 > 3 ? 0 : step + 1;
                currentStep = nextStep[step];
            }

            i += currentStep[0];
            j += currentStep[1];
            if (i >= m || j >= n || i < 0 || j < 0) break;
        }
        return result;
    }
}
