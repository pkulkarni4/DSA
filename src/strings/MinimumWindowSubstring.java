package strings;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every character in t (including duplicates) is included in the window.

If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {

    }
}

class MinimumWindowSubstringSolution {
    public String minWindow(String s, String t) {
        if("".equals(t)) return t;
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(Character c: t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0 )+1);
        }
        int have =0, need = countT.size();
        for(int r=0;r<s.length();r++) {
            Character c = s.charAt(r);
            window.put(c, countT.getOrDefault(c, 0 )+1);
            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }
            while(have == need) {

            }
        }
        return null;
    }
}
