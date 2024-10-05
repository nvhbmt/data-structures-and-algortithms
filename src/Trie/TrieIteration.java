package Trie;

public class TrieIteration {

    private class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    private TrieNode root = new TrieNode();


    public void insert(String word) {
        TrieNode parent = root;
        for (char c : word.toCharArray()) {
            int currentIndex = c - 'a';
            if (parent.children[currentIndex] == null) {
                parent.children[currentIndex] = new TrieNode();
            }
            parent = parent.children[currentIndex];
        }
        parent.isWord = true;
    }

    public boolean search(String word) {
        TrieNode parent = root;
        for (char c : word.toCharArray()) {
            int currentIndex = c - 'a';
            if (parent.children[currentIndex] == null) {
                return false;
            }
            parent = parent.children[currentIndex];
        }
        return parent.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode parent = root;
        for (char c : prefix.toCharArray()) {
            int currentIndex = c - 'a';
            if (parent.children[currentIndex] == null) {
                return false;
            }
            parent = parent.children[currentIndex];
        }
        return true;
    }
}
