package LeetCode;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, needle.length() + i).equals(needle)) {
                    return i;
                }
//                boolean isFound = true;
//                for (int j = i + 1; j < needle.length(); j++) {
//                    if (haystack.charAt(j) != needle.charAt(j)) {
//                        isFound = false;
//                        break;
//                    }
//                }
//                if (isFound) return i;
            }
        }
        return -1;
    }
}
