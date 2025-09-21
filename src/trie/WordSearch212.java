package trie;

import java.util.ArrayList;
import java.util.List;

/*
LC;212 Word search II
Given m x n board of characters and list of words. Return all the words found on the board.

 */
public class WordSearch212 {
    public static void main(String[] args) {
        char[][] example = {
                {'o', 'a', 'a', 'n' },
                {'e', 't', 'a', 'e' },
                {'i', 'h', 'k', 'r' },
                {'i', 'f', 'l', 'v' }
        };
        String[] wordsToFind = {"oath", "pea", "eat", "rain"};
        WordSearchSolution212 s = new WordSearchSolution212();
        List<String> wordsFound = s.findWords(example, wordsToFind);
        for (String str : wordsFound) {
            System.out.print(str + ",");
        }

        System.out.println();

        char[][] ex2 = {
                {'a', 't', 'b', 's' },
                {'c', 'r', 'b', 'e' },
                {'s', 'e', 'e', 'n' },
                {'d', 'n', 'a', 't' }
        };
        String[] words = {"seen", "seat", "seem", "tree", "been", "beat"};
        List<String> wordsFound1 = s.findWords(ex2, words);
        for (String str : wordsFound1) {
            System.out.print(str + ",");
        }

        System.out.println();

        char[][] ex3 = {
                {'a', 'a' }
        };
        String[] words3 = {"aaa"};
        List<String> wordsFound3 = s.findWords(ex3, words3);
        for (String str : wordsFound3) {
            System.out.print(str + ",");
        }
    }
}

class WordSearchSolution212 {
    /*
    1. create a trie from given list of words
    2. loop thru the board to find if there are matching words
    3. add the words found to a list.
     */
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int rows = board.length, cols = board[0].length;
        List<String> result = new ArrayList<>();
        // edge case
        int maxWordLen = getMaxWordLen(words);
        if (maxWordLen > rows * cols) return result;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (root.containsKey(board[row][col])) {
                    // do a dfs
                    dfs(board, root, row, col, rows, cols, "", result);
                }
            }
        }
        return result;
    }

    int getMaxWordLen(String[] words) {
        int max = 0;
        for (String word : words) {
            max = Math.max(max, word.length());
        }
        return max;
    }

    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }
        return root;
    }

    void dfs(char[][] board, TrieNode node, int row, int col, int rows, int cols, String path, List<String> result) {
        if (node == null) return;

        if (node.isEnd()) {
            result.add(path);
            node.isEndOfWord = false;
        }

        if ((row < 0 || row >= rows) || (col < 0 || col >= cols) || !node.containsKey(board[row][col])) {
            return;
        }

        char temp = board[row][col];
        // mark visited
        board[row][col] = '#';

        dfs(board, node.get(temp), row + 1, col, rows, cols, path + temp, result);
        dfs(board, node.get(temp), row - 1, col, rows, cols, path + temp, result);
        dfs(board, node.get(temp), row, col + 1, rows, cols, path + temp, result);
        dfs(board, node.get(temp), row, col - 1, rows, cols, path + temp, result);

        board[row][col] = temp;
    }
}