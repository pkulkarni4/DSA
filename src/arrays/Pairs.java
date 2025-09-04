package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/*
Consider an array of integers (positive and negative), m.
Write a snippet of code that finds all the pairs of integers whose sum is equal to a given number, k.

Example:
array = [-5, -2, 5, 4, 3, 7, 2, 1, -1 ,-2, 15, 6, 12, -4, 3], target = 10
pairs : [ [15, -5], [12, -2], [7, 3], [6, 4] ]
*/
public class Pairs {
    public static void main(String[] args) {
        int[] arr = {-5, -2, 5, 4, 3, 7, 2, 1, -1, -2, 15, 6, 12, -4, 3};
        int len = arr.length;
        int target = 5;

        PairSolution ps = new PairSolution();
        List<Pair> result = ps.pairsTwoPointers(arr, target, len);
        for (Pair pair : result) {
            System.out.println(pair);
        }

        System.out.println("***** ");
        List<Pair> result1 = ps.pairsHashtable(arr, target, len);
        for (Pair pair : result1) {
            System.out.println(pair);
        }
    }
}

class Pair {
    int one;
    int two;

    public Pair(int one, int two) {
        this.one = one;
        this.two = two;
    }

    public int getOne() {
        return one;
    }

    public int getTwo() {
        return two;
    }

    public String toString() {
        return "[" + this.one + ", " + this.two + "]";
    }
}

class PairSolution {

    // loop thru arr, find out what needs to be a pair for each element and store in hash table - O(n), space O(n)
    // loop thru arr again, find if element needed to make a pair exists hash table..
    public List<Pair> pairsHashtable(int[] arr, int target, int len) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        List<Pair> result = new ArrayList<>();

        for(int i: arr) {
            int req = target - i;
            if(ht.containsKey(req)) {
                Pair p = new Pair(i, req);
                result.add(p);
            } else {
                ht.put(req, i);
            }
        }

        return result;
    }

    // sort the array, use two pointers O(n log n), space = O(1)
    // left = 0, right = len - 1
    // sum = arr[left] + arr[right] == target, then add both to result, left--, right++
    // if sum < k, then left++
    // if sum > k, then right--

    public List<Pair> pairsTwoPointers(int[] arr, int target, int len) {
        // sort
        Arrays.sort(arr);

        List<Pair> result = new ArrayList<>();
        int left = 0, right = len - 1;
        while (left <= right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                Pair p = new Pair(arr[left], arr[right]);
                result.add(p);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

}