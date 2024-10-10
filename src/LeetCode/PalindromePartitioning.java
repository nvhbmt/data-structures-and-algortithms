package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end)
            if (s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }

    private void backtracking(List<List<String>> list, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tempList.add(s.substring(start, i + 1));
                backtracking(list, tempList, s, i + 1);
                tempList.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), s, 0);
        return list;
    }
}
