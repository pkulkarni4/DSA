package leetcode;

//1 ms
public class TruncateSentence1816 {
    public static void main(String[] args){
        Solution1816 s = new Solution1816();
        String str = "Hello how are you Contestant";
       String ans = s.truncateSentence(str, 1);
        System.out.println(ans);
         ans = s.truncateSentence(str, 2);
                System.out.println(ans);

        ans = s.truncateSentence(str, 3);
                System.out.println(ans);
        ans = s.truncateSentence(str, 4);
                System.out.println(ans);
        ans = s.truncateSentence(str, 5);
                System.out.println(ans);

    }
}

class Solution1816 {
    private static final char WORD_BREAK = ' ';

    public String truncateSentence(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return "";
        return wc_parse_k(s, s.length(), k);
    }

    String wc_parse_k(String str, int len, int k) {
        int charCount=0, wc=0, subs=0;
        StringBuilder sb = new StringBuilder();

        while(charCount < len)
        {
            if(str.charAt(charCount) == WORD_BREAK) {
                ++wc;
                sb.append(str.substring(subs,charCount));
                subs = charCount;
            }
            charCount++;
            if(wc == k) {
                break;
            }
        }
        // append last word if k is same as number of words in the sentence
        if(wc+1 == k) {
            sb.append(str.substring(subs,charCount));
        }
        return sb.toString();
    }

    public String truncateSentence2(String s, int k) {
        String[] strArr = s.split(" ",k+1);
        String result = "";
        for(int i = 0; i < k; i++)  result+=strArr[i]+" ";

        return result.substring(0,result.length()-1);
    }

}
