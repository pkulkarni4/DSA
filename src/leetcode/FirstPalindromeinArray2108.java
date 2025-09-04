package leetcode;

public class FirstPalindromeinArray2108 {
    public static void main(String[] args) {
        Solution2108 s = new Solution2108();
        String[] str = {"abc","car","ada","racecar","cool"};
        String first = s.firstPalindrome(str);
        System.out.println("ans: " + first);
    }

}
class Solution2108 {
    public String firstPalindrome(String[] words) {
        for(String str: words){
            if(isPalindrome(str)) {
                return str;
            }
        }
        return "";
    }

    private boolean isPalindrome(String str) {
        int i=0, j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!= str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome2(String s) {
        int n = s.length();
        s = s.toLowerCase();
        for (int i = 0; i < (n / 2) + 1; ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
