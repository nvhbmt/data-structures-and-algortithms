package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch {
    public List<String> result = new ArrayList<>();
    public int[] values = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    public void backtracking(int index, int currentCountBitOne, int turnedOn, int h, int m) {
        for (int i = 0; i <= 1; i++) {
            if (i == 1) {
                currentCountBitOne++;
                if (index <= 3) {
                    h += values[index];
                } else {
                    m += values[index];
                }
            }

            if (index == values.length) {
                if (currentCountBitOne == turnedOn && h < 12 && m < 60) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(h);
                    sb.append(":");
                    if (m < 10) {
                        sb.append("0");
                    }
                    sb.append(m);
                    result.add(sb.toString());
                }
            } else {
                backtracking(index + 1, currentCountBitOne, turnedOn, h, m);
            }
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        backtracking(0, 0, turnedOn, 0, 0);
        return result;
    }
}
