package trie;

public interface TriePrefixTree {
    void insert(String word);

    boolean search(String word);

    boolean startsWith(String prefix);
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void setEnd() {
        isEndOfWord = true;
    }

    public boolean isEnd() {
        return isEndOfWord;
    }
}
