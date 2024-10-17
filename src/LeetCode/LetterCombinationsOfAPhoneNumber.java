package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private char[][] mapping = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    private List<String> result;

    private void backtracking(String digits, int currentIndex, StringBuilder currentString) {
        if (currentString.length() == digits.length()) {
            result.add(currentString.toString());
            return;
        }
        
        int currentNumber = digits.charAt(currentIndex) - '0';
        for (char number : mapping[currentNumber]) {
            currentString.append(number);
            backtracking(digits, currentIndex + 1, currentString);
            currentString.deleteCharAt(currentIndex);
        }
    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        backtracking(digits, 0, new StringBuilder());
        return result;
    }
}
