package leetcode;

// 5ms
public class ConsistentStringsCount1684 {
    public static void main(String[] args){
        String allowed = "amne";
        String[] words = {"man", "name", ""};
        Solution1684 s = new Solution1684();
        int count = s.countConsistentStrings(allowed, words);
        System.out.println(count);
    }
}

class Solution1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        if (allowed == null || words == null || words.length == 0) return 0;

        return countConsistentStrings2(allowed, words);
    }

    int countConsistentStrings1(String allowed, String[] words) {
        char[] chr = new char[26];
        int count = 0;
        for(char c = 'a'; c <= 'z'; ++c) {
            chr[c - 'a'] = 0;
        }
        for(int i=0;i<allowed.length();i++) {
            chr[allowed.charAt(i) - 'a'] = 1;
        }

        for(String str: words) {
           if(isConsistent(str, chr))
               count++;
        }
        return count;
    }

 int countConsistentStrings2(String allowed, String[] words) {
        boolean[] chr = new boolean[26];
        int count = 0;

        for(int i=0;i<allowed.length();i++) {
            chr[allowed.charAt(i) - 'a'] = true;
        }

        for(String str: words) {
           if(isConsistent1(str, chr))
               count++;
        }
        return count;
    }

    private boolean isConsistent(String str, char[] chr) {
        if(str == null || str.length() == 0) return false;
        for (int i = 0; i < str.length(); i++) {
            if (chr[str.charAt(i) - 'a'] !=1) return false;
        }
        return true;
    }
    private boolean isConsistent1(String str, boolean[] chr) {
        if(str == null || str.length() == 0) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!chr[str.charAt(i) - 'a'] ) return false;
        }
        return true;
    }
}
