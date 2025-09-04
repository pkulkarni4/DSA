package strings;

/*
 You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

-----

Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

*/

public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharReplacementSolution s = new LongestRepeatingCharReplacementSolution();
        String[] input = {"ABAB", "AABABBA"};
        int[] k = {2, 1};
        for (int i = 0; i < input.length; i++) {
            int max = s.characterReplacement(input[i], k[i]);
            System.out.println("for string: " + input[i] + ", k = " + k[i] + ", max : " + max);
        }
    }
}

class LongestRepeatingCharReplacementSolution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int i = 0, j = 0, maxLen = 0, maxCount = 0;
        int[] charCounts = new int[26];
        for (i = 0; i < len; i++) {
            charCounts[s.charAt(i) - 'A']++;
            int charCount = charCounts[s.charAt(i) - 'A'];
            maxCount = Math.max(maxCount, charCount);

            int window = i - j - maxCount + 1;

            if (window > k) {
                // remove the char from the front:
                charCounts[s.charAt(j) - 'A']--;
                j++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}