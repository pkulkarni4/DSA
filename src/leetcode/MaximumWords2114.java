package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumWords2114 {
    private static final char WORD_BREAK = ' ';

    public static void main(String[] args){
        String[] sentences1 = new String[] {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        String[] sentences2 = new String[] {"please wait", "continue to fight", "continue to win"};
        String[] sentences3 = new String[] {"a", "aa", "aaa"};
        int maxWords = mostWordsFound(sentences1);
        System.out.println("max words 1:  " + maxWords);
        maxWords = mostWordsFound(sentences2);
        System.out.println("max words 2:  " + maxWords);
        maxWords = mostWordsFound(sentences3);
        System.out.println("max words 3:  " + maxWords);
        String str = "Hello how are you Contestant";
        wc_parse_k(str, str.length(), 2);

    }
     static int mostWordsFound(String[] sentences) {
        if(sentences == null || sentences.length == 0) return 0;
        return extracted2(sentences);
    }

    private static int extracted2(String[] sentences) { // 5ms
        int maxVal =0;
        for(String s: sentences){
            maxVal = Math.max( maxVal, s.split(" ").length);
        }

        return maxVal;
    }

    static int extracted1(String[] sentences) { // 2ms
        int max = 0;
        for(String str: sentences) {
            int c = wc_parse(str.trim(), str.length());
            if( c > max) {
                max = c;
            }
        }
        return max;
    }

    static int wc_parse(String str, int len) {
        int charCount=0, wc=1;

        while(charCount < len)
        {
            if(str.charAt(charCount) == WORD_BREAK) {
                ++wc;
            }
            charCount++;
        }
        //System.out.println(str + " contains words : " + wc +" has len: " + len);
        return wc;
    }

    static int wc_Split(String str) {
        return str.split(" ").length;
    }

   static int wc_parse_k(String str, int len, int k) {
        int charCount=0, wc=0;
       List<String> list = new ArrayList<>();

        while(charCount < len)
        {
            if(str.charAt(charCount) == WORD_BREAK) {
                ++wc;
                list.add(str.substring(0,charCount));
            }
            charCount++;
            if(wc == k) {
                break;
            }
        }
       for(String s: list) {
           System.out.println(s+" ");
       }
        //System.out.println(str + " contains words : " + wc +" has len: " + len);
        return wc+1;
    }
}
