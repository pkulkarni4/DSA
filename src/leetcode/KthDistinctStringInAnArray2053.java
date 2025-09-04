package leetcode;

import java.util.HashMap;

// 4 ms
public class KthDistinctStringInAnArray2053 {
    public static void main(String[] args) {
        Solution2053 s = new Solution2053();
        String[] arr = {"d","b","c","b","c","a"};
        int k = 2;
        String distinctKthString = s.kthDistinct(arr, k);
        System.out.println(distinctKthString);
        k=1;
distinctKthString = s.kthDistinct(arr, k);
        System.out.println(distinctKthString);
        k=3;
distinctKthString = s.kthDistinct(arr, k);
        System.out.println(distinctKthString);

    }
}
class Solution2053 {
    public String kthDistinct(String[] arr, int k) {
        if(arr == null || arr.length == 0 || k ==0 )return "";
        return kthDistinct(arr, arr.length, k);
    }

    String kthDistinct(String[] arr, int length, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        // use map to get distinct contents of array
        for(int i=0;i<length; i++){
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], 2);
            }
        }
        for(int i=0;i<length; i++){
            if(map.get(arr[i]) != 2){
                k--;
                if(k==0) return arr[i];
            }
        }
        return "";
    }
}
