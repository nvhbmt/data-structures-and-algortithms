package Trie;

public class MapSumPairs {
    private class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public int value = 0;
    }

    private TrieNode root = new TrieNode();

    private void insert(TrieNode parent, int currentIndex, String word, int value) {
        if (currentIndex == word.length()) return;
        int childIndex = word.charAt(currentIndex) - 'a';
        if (parent.children[childIndex] == null) {
            parent.children[childIndex] = new TrieNode();
        }
        if (currentIndex == word.length() - 1) {
            parent.children[childIndex].value = value;
        } else {
            insert(parent.children[childIndex], currentIndex + 1, word, value);
        }
    }

    public void insert(String key, int val) {
        insert(root, 0, key, val);
    }

    private int travelSum(TrieNode parent) {
        if (parent == null) return 0;
        int currentSum = parent.value;
        for (int i = 0; i < 26; i++) {
            currentSum += travelSum(parent.children[i]);
        }
        return currentSum;
    }


    public int travelSumPrefix(TrieNode parent, int currentIndex, String prefix) {
        if (currentIndex == prefix.length()) return 0;

        int childIndex = prefix.charAt(currentIndex) - 'a';
        if (parent.children[childIndex] == null) return 0;

        if (currentIndex == prefix.length() - 1) {
            return travelSum(parent.children[childIndex]);
        }

        return travelSumPrefix(parent.children[childIndex], currentIndex + 1, prefix);
    }

    public int sum(String prefix) {
        return travelSumPrefix(root, 0, prefix);
    }
}
