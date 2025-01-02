package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowelStringsInRanges {
    private boolean isVowelString(String word) {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        return vowelSet.contains(word.charAt(0)) && vowelSet.contains(word.charAt(word.length() - 1));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] result = new int[queries.length];
        int[] prefixSum = new int[words.length];
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            if (isVowelString(words[i])) sum++;
            prefixSum[i] = sum;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = prefixSum[query[1]] - (query[0] == 0 ? 0 : prefixSum[query[0] - 1]);
        }
        return result;
    }
}
