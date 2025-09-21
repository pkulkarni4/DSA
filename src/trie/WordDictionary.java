package trie;

/*
LC: 211: design add and search words data structure.
Support for . wild card
 */
public class WordDictionary extends Trie implements TriePrefixTree, SearchTrieWithWildCards {

    @Override
    public boolean searchWithWildCards(String word) {
        TrieNode curr = root;
        return dfs(curr, word, 0);
    }

    boolean dfs(TrieNode node, String word, int index) {
        if (node == null) return false;
        if (index == word.length()) {
            return node.isEnd();
        }
        if (word.charAt(index) == '.') {
            for (TrieNode child : node.children) {
                if (dfs(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
        return dfs(node.get(word.charAt(index)), word, index + 1);
    }
}
