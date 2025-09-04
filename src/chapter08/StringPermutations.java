package chapter08;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
    public static void main(String[] args) {

    }

    static Set<String> permute(String prefix, String str) {
        Set<String> permutations = new HashSet<>();
        int len = str.length();
        if(len == 0){
            permutations.add(prefix);
        } else {
            for(int i=0;i<len;i++){
               // permutations.addAll(permute(prefix + str.charAt(i), str.substring(i+1, len)+str.substring((0,i))));
            }
        }
        return permutations;
    }
}
