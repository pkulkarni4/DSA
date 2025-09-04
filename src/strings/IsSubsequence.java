package strings;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

 */
public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequenceSolution s = new IsSubsequenceSolution();
        boolean b = s.isSubsequence("abc", "ahbgdc");
        System.out.println(b);

        b = s.isSubsequence("axc", "ahbgdc");
        System.out.println(b);
    }
}
class IsSubsequenceSolution {
    public boolean isSubsequence(String s, String t) {

        int i =0, j=0;
        int sLen = s.length(), tLen=t.length();

        while(i<sLen && j<tLen) {
            if(s.charAt(i) == t.charAt(j)){
                // move both
                i++;j++;
            } else {
                j++;
            }
        }
        return i == sLen;
    }
}