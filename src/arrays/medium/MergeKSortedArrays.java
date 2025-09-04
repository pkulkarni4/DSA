package arrays.medium;

import java.util.*;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        Solution s = new Solution();
//
        ListNode student1 = new ListNode(2);
        ListNode student1_1 = new ListNode(2);
        ListNode student2 = new ListNode(4);
        ListNode student3 = new ListNode(6);
        ListNode student4 = new ListNode(8);
        ListNode student4_1 = new ListNode(9);
        ListNode student4_2 = new ListNode(10);
        student1.next=student1_1;
        student1_1.next=student2;
        student2.next=student3;
        student3.next=student4;
        student4.next=student4_1;
        student4_1.next=student4_2;
        //
        ListNode student5 = new ListNode(1);
        ListNode student6 = new ListNode(3);
        ListNode student7 = new ListNode(5);
        ListNode student8 = new ListNode(7);
        student5.next=student6;
        student6.next=student7;
        student7.next=student8;
        //
        ListNode[] nodes =new ListNode[]{student1, student5};
        ListNode merged = s.merge(nodes);
        //s.print(merged);
    }
}

class ListNode implements Comparable{
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int getVal(){
          return this.val;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.val, ((ListNode)o).val);
    }
}

class Solution {
    public ListNode merge(ListNode[] lists){
        PriorityQueue<ListNode> p=new PriorityQueue<>((a,b)->b.val-a.val);
        for(int i=0;i<lists.length;i++)
        {
            ListNode x=lists[i];
            while(x!=null){
                p.add(x);
                x=x.next;
            }
        }
// print p
        printPQ(p);

        ListNode ans=p.poll();
        ListNode temp=ans;

        while(p.size() > 0) {
            temp.next = p.poll();
            temp = temp.next;
        }

        if(temp!=null)
            temp.next=null;
        return ans;
    }

    void printPQ(PriorityQueue<ListNode> p) {
        while(p.size() > 0){
            System.out.println(p.poll().val);
        }
    }

    public void print(ListNode merged) {
        while(merged!=null){
            System.out.println(merged.val);
            merged=merged.next;
        }
    }

}
