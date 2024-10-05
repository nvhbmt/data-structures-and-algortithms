package Trie;

public class Trie {

    private class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    private final TrieNode root = new TrieNode();

    private void insertWord(TrieNode parent, int currentIndex, String word) {
        if (currentIndex < word.length()) {
            int childIndex = word.charAt(currentIndex) - 'a';
            if (parent.children[childIndex] == null) {
                parent.children[childIndex] = new TrieNode();
            }

            if (currentIndex == word.length() - 1) {
                parent.children[childIndex].isWord = true;
            } else {
                insertWord(parent.children[childIndex], currentIndex + 1, word);
            }
        }
    }

    public void insert(String word) {
        insertWord(root, 0, word);
    }

    private boolean searchWord(TrieNode parent, int currentIndex, String word) {
        if (currentIndex >= word.length()) return false;
        int childIndex = word.charAt(currentIndex) - 'a';
        if (parent.children[childIndex] == null) {
            return false;
        }
        if (currentIndex == word.length() - 1) {
            return parent.children[childIndex].isWord;
        }
        return searchWord(parent.children[childIndex], currentIndex + 1, word);
    }

    public boolean search(String word) {
        return searchWord(root, 0, word);
    }

    private boolean searchPrefix(TrieNode parent, int currentIndex, String prefix) {
        if (currentIndex >= prefix.length()) return false;

        int childIndex = prefix.charAt(currentIndex) - 'a';
        if (parent.children[childIndex] == null) {
            return false;
        }
        if (currentIndex == prefix.length() - 1) {
            return true;
        }
        return searchPrefix(parent.children[childIndex], currentIndex + 1, prefix);
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(root, 0, prefix);
    }

}
