package LeetCode;

public class CountPrefixAndSuffixPairsI {
    private boolean isPrefixAndSuffix(String str1, String str2) {
        if (str1.length() > str2.length()) return false;
        int length = str1.length();
        return str2.substring(0, length).equals(str1) && str2.substring(str2.length() - length).equals(str1);
    }

    public int countPrefixSuffixPairs(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (i != j && isPrefixAndSuffix(words[i], words[j])) {
                    result++;
                }
            }
        }
        return result;
    }
}
