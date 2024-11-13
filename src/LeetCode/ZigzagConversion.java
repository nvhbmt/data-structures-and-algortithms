package LeetCode;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int i = 0;
        boolean isDown = false;
        for (char c : s.toCharArray()) {
            rows[i].append(c);
            if (i == 0 || i == numRows - 1) isDown = !isDown;
            i += isDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }

        return sb.toString();
    }
}
