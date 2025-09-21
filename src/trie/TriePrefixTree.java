package trie;

public interface TriePrefixTree {
    void insert(String word);

    boolean search(String word);

    boolean startsWith(String prefix);

    void print();
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    TriePrintHelper printHelper;

    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];
        printHelper = new TriePrintHelper();
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

    public void print() {
        for (char c = 'a'; c < 'z'; c++) {
            if (children[c - 'a'] != null) {
                System.out.println(" c = " + printHelper.getChar(c - 'a'));
            }
        }
    }
}
