package leetcode;

// 1ms
public class CheckIfTwoStringArraysAreSame1662 {
    public static void main(String[] args){
        Solution1662 s = new Solution1662();
        String[] word1 = {"ab", "c"}, word2 = {"a", "bc"};
        boolean same = s.arrayStringsAreEqual(word1, word2);
        System.out.println(same);

        String[] word3 = {"abd", "c"}, word4 = {"a", "bc"};
        same = s.arrayStringsAreEqual(word3, word4);
        System.out.println(same);

        String[] word5 = {"abc", "d", "defg"}, word6 = {"abcddefg"};
        same = s.arrayStringsAreEqual(word5, word6);
        System.out.println(same);

        same = s.arrayStringsAreEqual(word1, word6);
        System.out.println(same);

    }
}

class Solution1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = getWord(word1);
        String s2 = getWord(word2);
        return s1.equals(s2);
    }

    String getWord(String[] word) {
        StringBuilder sb = new StringBuilder();
        for(String s: word)
            sb.append(s);

        return sb.toString();
    }
}
