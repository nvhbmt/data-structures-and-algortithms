package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            if (i > 0) {
                for (int j = 1; j < i; j++) {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
                row.add(1);
            }
            result.add(row);
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascalTriangle = generate(rowIndex + 1);

        return pascalTriangle.get(rowIndex);
    }
}
