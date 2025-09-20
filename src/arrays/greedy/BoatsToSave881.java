package arrays.greedy;

import java.util.Arrays;

/*
LC: 881: Boats to save people.
Can take as many boats, at most two people on the boat and weight <= limit
out put should be minimum boats required to haul ppl
*/
public class BoatsToSave881 {
    public static void main(String[] args) {
        int[][] people = {
                {1, 2},
                {3, 2, 2, 1},
                {3, 5, 3, 4},
                {1, 10, 2, 4, 3, 7, 8, 5}
        };
        int[] limit = {3, 3, 5, 10};
        Solution881 s = new Solution881();
        for (int i = 0; i < people.length; i++) {
            int boats = s.numRescueBoats(people[i], limit[i]);
            System.out.println("boats needed: " + boats);
        }
    }
}

class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        Arrays.sort(people);
        int i = 0, boats = 0, j = len - 1;
        while (i <= j) {
            boats++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return boats;
    }
}