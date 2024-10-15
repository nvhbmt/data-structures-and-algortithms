package LeetCode;

public class LongestPalindromicSubstring {
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public String longestPalindromeUseBruteForce(String s) {
        int maxLength = 1;
        String maxString = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLength; j <= s.length(); j++) {
                if (j - i > maxLength && isPalindrome(s.substring(i, j))) {
                    maxLength = j - i;
                    maxString = s.substring(i, j);
                }
            }
        }

        return maxString;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public String longestPalindromeUseExpandFromCenter(String s) {
        String maxString = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > maxString.length()) {
                maxString = odd;
            }

            if (even.length() > maxString.length()) {
                maxString = even;
            }
        }

        return maxString;
    }

    public String longestPalindrome(String s) {
        int maxLength = 1;
        int left = 0;
        int right = 1;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLength) {
                        maxLength = i - j + 1;
                        left = j;
                        right = i;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

}
