package chapter08;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "aca";
        PalindromicSubstringsSolution palindromicSubstrings = new PalindromicSubstringsSolution();
        int num = palindromicSubstrings.getPalindromicSubstrings(str);
        System.out.println("total palindromic substrings in " + str + " is : " + num);
        String max = palindromicSubstrings.getLongestPalindromicSubstrings(str);
        System.out.println("longest palindrome substring : " + max);
        max = palindromicSubstrings.getLongestPalindromicSubstring(str);
        System.out.println("longest palindrome substring : " + max);
    }
}

class PalindromicSubstringsSolution {
    void printArray(String str, boolean[][] dp) {
        for (char c : str.toCharArray()) {
            System.out.print(" " + c + " ");
        }
        System.out.println();
        int rows = dp.length;
        int cols = dp[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean b = dp[i][j];
                System.out.print(b ? " T " : " F ");
            }
            System.out.println();
        }
    }

    public int getPalindromicSubstrings(String str) {
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        return getPalindromicSubstrings(str, dp, len);
    }

    public String getLongestPalindromicSubstrings(String str) {
        int len = str.length(), maxR = 0, maxC = 0, maxDiff = -1;
        boolean[][] dp = new boolean[len][len];
        getPalindromicSubstrings(str, dp, len);

        // O(n^2), where n is string len
        for (int rows = 0; rows < len; rows++) {
            for (int cols = 0; cols < len; cols++) {
                if (dp[rows][cols] && rows != cols) {
                    if (maxDiff < (cols - rows)) {
                        maxR = rows;
                        maxC = cols;
                        maxDiff = (cols - rows);
                    }
                }
            }
        }
        //  System.out.println(" rows : "+ maxR +"  cols :  " + maxC + " max diff : "+  maxDiff +  "  substr:  "+ str.substring(maxR, maxC+1));
        return str.substring(maxR, maxC + 1);
    }

    public int getPalindromicSubstrings(String str, boolean[][] dp, int len) {
        int count = 0;

        // single characters in the string: fill true in diagonal
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            count++;
        }
        //  printArray("single char: " , dp);
        // two characters in the string: they have to be same to be palindrome
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        //   printArray("aabaaca", dp);
        // three to length of the string, check palindrome and update dp array
        for (int i = 3; i < len + 1; i++) {
            for (int j = 0; j < len - i + 1; j++) {
                int k = j + i - 1;
                if (str.charAt(j) == str.charAt(k) && dp[j + 1][k - 1]) {
                    // for 3 letter words, check first and last letters if they are same. if they are same, single letter is palindrome. update dp for 3 letter word
                    // for 4 letter words, check first and last letters if they are same. if they are same, dp will check for 2 letter word. update dp for 3 letter word
                    // and so on
                    dp[j][k] = true;
                    count++;
                }
            }
        }
        //printArray("aaa ", dp);
        // System.out.println("dp[0][4] == " + dp[0][4]);

        return count;
    }

    public String getLongestPalindromicSubstring(String str) {
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        return getLongestPalindromicSubstring(str, len, dp);
    }

    String getLongestPalindromicSubstring(String str, int len, boolean[][] dp) {
        int start = 0, maxLen = 0;
        // single characters in the string: fill true in diagonal
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //  printArray("single char: " , dp);
        // two characters in the string: they have to be same to be palindrome
        for (int i = 0; i < len - 1; i++) {
            System.out.println("  i : "+str.charAt(i) + "i+1 :: "+ str.charAt(i + 1));
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        System.out.println(" start : " + start + " maxLen : " + maxLen);
        //   printArray("aabaaca", dp);
        // three to length of the string, check palindrome and update dp array
        for (int i = 3; i < len + 1; i++) {
            for (int j = 0; j < len - i + 1; j++) {
                int k = j + i - 1;
                if (str.charAt(j) == str.charAt(k) && dp[j + 1][k - 1]) {
                    // for 3 letter words, check first and last letters if they are same. if they are same, single letter is palindrome. update dp for 3 letter word
                    // for 4 letter words, check first and last letters if they are same. if they are same, dp will check for 2 letter word. update dp for 3 letter word
                    // and so on
                    dp[j][k] = true;
                    start = j;
                    maxLen = k;
                }
            }
        }
        //printArray("aaa ", dp);
        return str.substring(start, maxLen + 1);
    }
}