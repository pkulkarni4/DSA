package trie;

import java.util.Stack;

public class Trie implements TriePrefixTree {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                curr.put(c, newNode);
            }
            curr = curr.get(c);
        }
        curr.setEnd();
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.containsKey(c)) {
                return false;
            }
            curr = curr.get(c);
        }
        return curr.isEnd();
    }

    @Override
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}
