package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubstrings {
    public static void main(String[] args) {
        String s = "aabaaca";
        AllSubstringsSolution m = new AllSubstringsSolution();
        HashSet<String> set = new HashSet<>();
        List<String> res = m.findSubstrings(s); // O(n^2)
        for (String str : res) { // O(n^2)
            // check if string is a palindrome
            if (isPalindrome(str)) {
                set.add(str);
            }
        }

        for (String str : set) { //  // O(n)
            System.out.println(str);
        }
    }

    static boolean isPalindrome(String str) {
        int len = str.length() - 1;
        for (int i = 0; i <= len / 2; i++) {
            if (str.charAt(len - i) != str.charAt(i))
                return false;
        }
        return true;
    }
}

// Function to find all substrings

class AllSubstringsSolution {
    public List<String> findSubstrings(String s) {
        // to store all substrings
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                // substring function takes starting index
                // and ending index + 1 as parameters
                res.add(s.substring(i, j + 1));
            }
        }
        return res;
    }
}
class AllPalindromicSubstringsSolution {
    public Set<String> findPalindromicSubstrings() {
        return null;
    }
}