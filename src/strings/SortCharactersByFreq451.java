package strings;

import java.util.*;

/*
LC# 451: Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 */
public class SortCharactersByFreq451 {
    public static void main(String[] args) {
        SortCharactersByFreq451Solution s = new SortCharactersByFreq451Solution();
        String[] examples = {
                "tree",
                "cccaaa",
                "Aabb",
                "AaBb",
                "leetcode",
                "loveleetcode"
        };
        for (String e : examples) {
            String sorted = s.frequencySort(e);
            System.out.println(sorted);
        }
    }
}

class SortCharactersByFreq451Solution {

    public String frequencySort(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        Character[] chars = new Character[length];
        int i = 0;
        for (Character c : s.toCharArray()) {
            chars[i++] = c;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Arrays.sort(chars, (a, b) -> {
            int diff = map.get(b) - map.get(a);
            if (diff == 0) {
                return b.compareTo(a);
            }
            return diff;
        });

        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            System.out.println("count of " + c + " ==>" + map.get(c));
            sb.append(c);
        }

        return sb.toString();
    }
}
