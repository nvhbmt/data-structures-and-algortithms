package LeetCode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            int j = n - i - 1;
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}
