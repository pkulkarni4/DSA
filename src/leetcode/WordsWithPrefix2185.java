package leetcode;
//1ms
public class WordsWithPrefix2185 {
    public static void main(String[] args) {
        Solution2185 s = new Solution2185();
        String[] words = {"pay","pattention","practice","attend"};
        String prefix = "p";
        int c = s.prefixCount(words, prefix);
        System.out.println(c);
    }
}
class Solution2185 {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(String str: words) {
            if(isPrefix(str, pref)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrefix(String str, String pref) {
        return str.startsWith(pref);
    }
}
