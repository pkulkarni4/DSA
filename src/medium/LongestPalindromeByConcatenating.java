package medium;

public class LongestPalindromeByConcatenating {
    public static void main(String[] args) {
        String[] arr = new String[] {"lc", "cl", "gg"};
        SolutionLongestPalindromeByConcatenating sol = new SolutionLongestPalindromeByConcatenating();
        int maxP = sol.longestPalindrome(arr);
        System.out.println(maxP);
    }
}
class SolutionLongestPalindromeByConcatenating {
    public int longestPalindrome(String[] words) {
        int maxPalind = 0, count = 0;
        for(int i=0;i<words.length;i++) {
            for(int j=i+1;j<words.length;j++) {
                String str = words[i] + words[j];
                if(isPalindrome(str)) {
                    count++;
                }
            }
            maxPalind = Math.max(maxPalind, count);
            System.out.println(count + " max : " + maxPalind);
        }
        return maxPalind;
    }

    private boolean isPalindrome(String str) {
        System.out.println(str);
        int len = str.length()-1;
        for(int i = 0; i<=len/2; i++) {
            if(str.charAt(len-i) != str.charAt(i))
                return false;
        }
        return true;
    }

}