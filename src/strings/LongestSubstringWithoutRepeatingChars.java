package strings;

/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] input = {"abcabcbb", "bbbbb","pwwkew"};
        for(String str : input) {
            System.out.println(" " + s.lengthOfLongestSubstring(str));
        }
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), maxLongestSubstr = 0, currentLongestSubstr=0;
        int[] chars = new int[26];
        for (int i = 0; i < len; i++) {
            if(chars[s.charAt(i) - 'a'] != 0){
                // we found a repeated char, pop the starting and reduce the count
                chars[s.charAt(i) -'a']--;
                currentLongestSubstr = 0;
            } else {
                chars[s.charAt(i) - 'a']++;
                currentLongestSubstr++;
            }
            maxLongestSubstr = Math.max(currentLongestSubstr, maxLongestSubstr);
        }
        return maxLongestSubstr;
    }
}