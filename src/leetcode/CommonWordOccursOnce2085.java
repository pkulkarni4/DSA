package leetcode;

import java.util.HashMap;
//10 ms
public class CommonWordOccursOnce2085 {
    public static void main(String[] args) {
        Solution2085 s = new Solution2085();
        String[] words1 = {"leetcode","is","amazing","as","is"}, words2 = {"amazing","leetcode","is"};
        int count = s.countWords(words1, words2);
        System.out.println(count);
        String[] words3 = {"b","bb","bbb"}, words4 = {"a","aa","aaa"};
        count = s.countWords(words3, words4);
        System.out.println(count);
        String[] words5 = {"a","ab"}, words6 = {"a","a","a", "ab"};
        count = s.countWords(words5, words6);
        System.out.println(count);

    }
}

class Solution2085 {
    public int countWords(String[] words1, String[] words2) {
        if(words1 == null || words1.length == 0 || words2 == null || words2.length == 0) return 0;
        return countWordsOptimal(words1, words1.length, words2, words2.length);
    }

    private int countWords(String[] words1, int length1, String[] words2, int length2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        // use map to get distinct contents of array
        for(int i=0;i<length1; i++){
            String key = words1[i];
            if(!map1.containsKey(key)) {
                map1.put(key, 1);
            } else {
                int c = map1.get(key) ;
                map1.put(key, c+1);
            }
        }
        for(int i=0;i<length2; i++){
            String key = words2[i];
            if(!map2.containsKey(key)) {
                map2.put(key, 1);
            } else {
                int c = map2.get(key) ;
                map2.put(key, c+1);
            }
        }

        int count = 0;
        for(int i=0;i<length1; i++) {
            String key = words1[i];
            if(map1.containsKey(key) && map1.get(key) == 1 && map2.containsKey(key) && map2.get(key) == 1) {
                count++;
            }
        }
return count;
    }

    //--------- optimal - using only one map

    private int countWordsOptimal(String[] words1, int length1, String[] words2, int length2) {
        HashMap<String, Integer> map1 = new HashMap<>();
       // HashMap<String, Integer> map2 = new HashMap<>();
        // use map to get distinct contents of array
        for(int i=0;i<length1; i++){
            String key = words1[i];
            if(!map1.containsKey(key)) {
                map1.put(key, 1);
            } else {
                int c = map1.get(key) ;
                map1.put(key, c+1);
            }
        }

        int count = 0;
        for(int i=0;i<length2; i++) {
            String key = words2[i];

            int freq = map1.getOrDefault(key,0);
            if(freq<=1) {
                if (freq == 1) count++;
                else if (freq == 0) count--;

                map1.put(key, freq - 1);
            }
        }
        return count>=0?count:0;
    }
}
