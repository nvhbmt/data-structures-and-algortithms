package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0) return "0";
        Map<Integer, String> hexMap = new HashMap<>();
        hexMap.put(0, "0");
        hexMap.put(1, "1");
        hexMap.put(2, "2");
        hexMap.put(3, "3");
        hexMap.put(4, "4");
        hexMap.put(5, "5");
        hexMap.put(6, "6");
        hexMap.put(7, "7");
        hexMap.put(8, "8");
        hexMap.put(9, "9");
        hexMap.put(10, "a");
        hexMap.put(11, "b");
        hexMap.put(12, "c");
        hexMap.put(13, "d");
        hexMap.put(14, "e");
        hexMap.put(15, "f");
        long val = num >= 0 ? num : (long) (Math.pow(2, 32) + num);
        StringBuilder sb = new StringBuilder();
        while (val > 0) {
            int remainder = (int) (val % 16);
            sb.insert(0, hexMap.get(remainder));
            val /= 16;
        }
        return sb.toString();
    }
}
