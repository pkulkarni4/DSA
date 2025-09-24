package chapter08;

import java.util.*;

/*
LC #139: Word Break
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
 */
public class WordBreak {
    public static void main(String[] args) {
        String[] examples = {
                "leetcode",
                "catsanddog",
                "applepenapple"
        };
        List<List<String>> wordDict = new ArrayList<>();

        wordDict.add(Arrays.asList(new String[]{"leet", "code"}));
        wordDict.add(Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"}));
        wordDict.add(Arrays.asList(new String[]{"apple", "pen"}));


        WordBreakSolution139 s = new WordBreakSolution139();
        for (int i = 0; i < examples.length; i++) {
            boolean b = s.wordBreak(examples[i], wordDict.get(i));
            System.out.println("word: " + examples[i] + " can be constructed using dict: " + wordDict.get(i) + " => " + b);
        }
    }
}

class WordBreakSolution139 {
    /*

     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int length = s.length();
        System.out.println("s => " + s + " len : " + length);
        boolean[] res = new boolean[length + 1];
        res[0] = true;

        for (int i = 0; i < length + 1; i++) {
            for (String word : wordSet) {
                int wordLen = word.length();
                if (res[i] && (i + wordLen) <= length) {
                    String substring = s.substring(i, i + wordLen);
                    System.out.println("substring ==> " + substring);
                    if (wordSet.contains(substring)) {
                        res[i + wordLen] = true;
                    }
                }
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.print(s.charAt(i) + " ");
        }
        System.out.println();
        for (int i = 1; i < res.length; i++) {
            if (res[i]) {
                System.out.print("t ");
            } else {
                System.out.print("f ");
            }
        }
        return res[length];
    }
}
