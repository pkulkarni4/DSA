package arrays;

import java.util.*;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [-1]
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int[] res = topKFrequent(nums, 2);
        for(int i: res) {
            System.out.print(" " + i);
        }

        System.out.println();

        int[] nums2 = {1,1,1,2,2,3};
        int[] res2 = topKFrequent(nums, 2);
        for(int i: res2) {
            System.out.print(" " + i);
        }
    }

    static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        int length = nums.length;

        List<Integer>[] bucket = new List[length + 1];

        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        for (int key : countMap.keySet()) {
            int frequency = countMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;
        for (int i = bucket.length - 1; i >= 0 && counter<k; i--) {
            if (bucket[i] != null) {
                for (int f : bucket[i]) {
                    res[counter++] = f;
                }
            }

        }
        return res;
    }
}


class TestTopKElementsSolution<E> {

    public List<E> topKFrequent(List<E> nums, int k) {
        int len = nums.size();
        HashMap<E,Integer> hmap=new HashMap<>();
        for(int i=0;i<nums.size();i++)
        {
            if(hmap.containsKey(nums.get(i)))
                hmap.put(nums.get(i),hmap.get(nums.get(i))+1);
            else
                hmap.put(nums.get(i),1);
        }
        PriorityQueue<Element<E>> pq = new PriorityQueue(len, new Comparator<Element>() {
            @Override
            public int compare(Element e1,Element e2){
                if(e1.freq<e2.freq)
                    return 1;
                else if(e1.freq>e2.freq)
                    return -1;
                else
                    return 0;
            }
        });

        for(Map.Entry<E,Integer> item : hmap.entrySet()){
            Element x=new Element(item.getKey(),item.getValue());
            pq.add(x);
        }
        List<E> list=new ArrayList<>();
        for(int i=0;i<k;i++)
            list.add(pq.poll().val);

        return list;
    }
    class Element<E>{
        E val;
        int freq;
        Element(E a,int b) {
            val=a;
            freq=b;
        }
    }
}


