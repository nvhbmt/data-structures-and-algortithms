package LeetCode;

public class StringToInteger {
    public static int myAtoi(String s) {
        long n = 0;
        boolean isNegative = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && c == '+') continue;
            if (Character.isDigit(c)) {
                n = n * 10 + c - '0';
            } else {
                if (c == '-' && !isNegative && i == 0) {
                    isNegative = true;
                } else {
                    break;
                }
            }
            if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) {
                if (isNegative) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
        }

        return isNegative ? (int) -n : (int) n;
    }

    public static void main(String[] args) {
        String s = "18446744073709551617";
        System.out.println(myAtoi(s));
    }
}
