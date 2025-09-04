package medium;

import java.util.Hashtable;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class StringPalindrome {
    public static void main(String[] args) {
        PalindromeSolution ss = new PalindromeSolution();

        String[] checkPalindromes = {"  23\"f6??6f\"32LL", "A man, a plan, a canal: Panama", "Was it a car or a cat I saw?", "Able, was I saw Elba", "rac4car", "race a car", "a", "aa", "aaa", "No, it is opposition"};

        for (String str : checkPalindromes) {
            boolean b = ss.isPalindromeTwoPointers(str);
            System.out.println(" --> " + str + ", palindrome? : " + b);
        }
        System.out.println(" ****** ");
        for (String str : checkPalindromes) {
            boolean b = ss.isPalindromeCountChars(str.toLowerCase());
            System.out.println(" --> " + str + ", palindrome? : " + b);
        }

        System.out.println(" ****** ");
        for (String str : checkPalindromes) {
            boolean b = ss.isPalindromeTwoPointers(str.toLowerCase(), str.length());
            System.out.println(" --> " + str + ", palindrome? : " + b);
        }
    }
}

class PalindromeSolution {

    public boolean isPalindromeCountChars(String s) {
        // count the chars,
        // ex: bab, bbabb, bcacb, etc
        Hashtable<Character, Integer> charCountTable = new Hashtable<>();
        for (Character ch : s.toCharArray()) {
            // add only if character is alphanumeric
            if (Character.isAlphabetic(ch)) {
                charCountTable.put(ch, charCountTable.getOrDefault(ch, 0) + 1);
            }
        }
        // if only one char is present, its always a palindrome, length does not matter
        if (charCountTable.size() == 1) return true;

        // if there are more than one char, only one char can have odd number and all others have to be even.
        boolean oddCountFound = false;
        for (Character c : charCountTable.keySet()) {
            int count = charCountTable.get(c);
            if (count % 2 == 1) {
                if (oddCountFound) return false;
                oddCountFound = true;
            }
        }
        return true;
    }

    boolean isPalindromeTwoPointers(String s, int len) {
        int i = 0, j = len - 1;
        while (i < j) {
            char iChar = s.charAt(i);
            char jChar = s.charAt(j);
            boolean iCharAlphabet = Character.isAlphabetic(iChar);
            boolean jCharAlphabet = Character.isAlphabetic(jChar);

            if (!iCharAlphabet) {
                i++;
            }

            if (!jCharAlphabet) {
                j--;
            }

            if (iCharAlphabet && jCharAlphabet) {
                if (iChar == jChar) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isPalindromeTwoPointers(String s) {
        if (s == null || s.isEmpty()) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            boolean alphabetic = isAlphabetic(c1);
            if (!alphabetic) {
                i++;
            }

            if (!isAlphabetic(c2)) {
                j--;
            }

            if (alphabetic && isAlphabetic(c2)) {
                char lowerCaseC1 = toLowerCase(c1);
                char lowerCaseC2 = toLowerCase(c2);
                if (lowerCaseC1 != lowerCaseC2) return false;
                i++;
                j--;
            }

        }
        return true;
    }

    char toLowerCase(char c1) {
        char ret = c1;
        if (c1 - 'a' >= 0) return ret;

        if (c1 - 'A' >= 0) {
            ret = (char) (c1 + 32);
        }
        return ret;
    }

    boolean isAlphabetic(char c1) {
        return (c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z');
    }
}