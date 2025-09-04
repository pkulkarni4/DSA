package strings;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagrams = groupAnagrams(arr);

        for(List<String> anagram: anagrams) {
            System.out.print("[");
            for(String str: anagram){
                System.out.print(str +",");
            }
            System.out.print("]");
        }
    }

    static List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> anagramGrp = new HashMap<>();
        for(String str: arr) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String anagram = String.valueOf(ca);
            if(!anagramGrp.containsKey(anagram)) {
                anagramGrp.put(anagram, new ArrayList<>());
            }
            anagramGrp.get(anagram).add(str);
        }
        return new ArrayList<>(anagramGrp.values());
    }
}
