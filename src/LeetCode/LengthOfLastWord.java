package LeetCode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (s.charAt(end) == ' ') end--;
        int length = 0;
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            length++;
        }
        return length;
    }
}
