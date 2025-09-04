package arrays;

import java.util.Hashtable;

public class UniqueCharacters {
    public static void main(String[] args) {
        String text = "a b c d";
        String unicode = "豈 更 車 賈 滑 更"; // 更 is repeated
        String mixed = "a 豈 b 更 ￦";

        boolean resultText = StringUtils.areCharsUnique(text);
        boolean resultUnicode = StringUtils.areCharsUnique(unicode);
        boolean resultMixed = StringUtils.areCharsUnique(mixed);

        System.out.println("ASCII text has unique characters? " + resultText);
        System.out.println("Unicode text has unique characters? " + resultUnicode);
        System.out.println("Mixed text has unique characters? " + resultMixed);

        String text1 = "abcdefhzqoc";
        String text2 = "abcdefhzqow";

        boolean resultText1 = StringUtils.areAlphabetsUnique(text1);
        boolean resultText2 = StringUtils.areAlphabetsUnique(text2);

        System.out.println("Text1: " + resultText1 + " has unique characters? " + resultText1);
        System.out.println("Text2: " + resultText2 + "  has unique characters? " + resultText2);

        boolean alphabetsUnique = StringUtils.areAlphabetsUnique(text);
        System.out.println("alphabets text: " + text + " has unique characters? " + alphabetsUnique);

        alphabetsUnique = StringUtils.areAlphabetsUnique("text");
        System.out.println("alphabets text: text has unique characters? " + alphabetsUnique);
    }
}

class StringUtils {
    /**
     * return true if chars in the str are unique (ignoring white spaces)
     * chars are unicode/ascii
     */
    public static boolean areCharsUnique(String str) {
        Hashtable<Character, Character> uniq = new Hashtable<>();
        for (Character ch : str.toCharArray()) {
            if (!Character.isWhitespace(ch) && uniq.contains(ch)) {
                return false;
            }
            uniq.put(ch, ch);
        }
        return true;
    }

    /**
     * uses bit mask
     * for ex : a will have mask of 0001, b will have 0010, c 0100 and d 1000
     * if the masks are &'d with a marker (zero initially) returns > 0, then the char already exists,
     * marker is updated by | with mask.
     * <p>
     * marker = 0000
     * mask for a = 0001
     * <p>
     * marker & mask = 0
     * <p>
     * marker = 0000 | 00001 = 0001
     * Next:
     * marker =     0001
     * mask for b = 0010
     * marker & mask = 0011
     * marker = 0001 | 00011 = 0011
     * ***
     * Lets say a occurs again in the string,
     * marker = 0011
     * mask for a = 0001
     * marker & mask for a = 0011 & 0001 = 0001 > 0
     */
    public static boolean areAlphabetsUnique(String str) {
        int marker = 0;
        for(char c: str.toCharArray()) {
            int s = c -'a';
            int mask = 1 << s;
            if( (marker & mask) > 0) {
                return false;
            }
            marker = marker | mask;
        }
        return true;
    }
}