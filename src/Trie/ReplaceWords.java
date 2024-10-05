package Trie;

import java.util.List;

public class ReplaceWords {
    private class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    private TrieNode root = new TrieNode();

    private void insertNode(TrieNode parent, int currentIndex, String word) {
        if (currentIndex == word.length()) return;
        int childIndex = word.charAt(currentIndex) - 'a';
        if (parent.children[childIndex] == null) {
            parent.children[childIndex] = new TrieNode();
        }

        if (currentIndex == word.length() - 1) {
            parent.children[childIndex].isWord = true;
        }

        insertNode(parent.children[childIndex], currentIndex + 1, word);
    }

    private String findPrefix(TrieNode parent, int currentIndex, String word) {
        if (currentIndex == word.length()) return null;
        int childIndex = word.charAt(currentIndex) - 'a';
        if (parent.children[childIndex] == null) return null;
        if (parent.children[childIndex].isWord) return word.substring(0, currentIndex);
        return findPrefix(parent.children[childIndex], currentIndex + 1, word);
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        for (String word : dictionary) {
            insertNode(root, 0, word);
        }
        for (String word : sentence.split(" ")) {
            String prefix = findPrefix(root, 0, word);
            if (prefix != null) word = prefix;
            if (!sb.isEmpty()) sb.append(" ");
            sb.append(word);
        }
        return sb.toString();
    }
}
