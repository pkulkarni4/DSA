package linkedlist;

/*
Problem: Consider a singly linked list of integers and a given integer, n. Write a snippet of code that returns the value of the nth to last node.
Example:

 */
public class LinkedListNthToLastNode {
    public static void main(String[] args) {
        LinkedListNthToLastNodeSolution ss = new LinkedListNthToLastNodeSolution();
        LinkedListINode head = LinkedListINodeUtil.get5LinkedListINode();
        LinkedListINodeUtil.printLinkedListINode(head);
        int n = 3;
        int thirdFromLast = ss.nthToLastIterative(head, n);
        System.out.println(n + " from last: " + thirdFromLast);
    }
}

class LinkedListNthToLastNodeSolution {
    /*
    user two pointers - p1 and p2. move p2 to nth node from head.
    next start moving p1 until p2 is null, p1 will be nth node from tail.
     */
    public int nthToLastIterative(LinkedListINode head, int n) {
        LinkedListINode p1 = head;
        LinkedListINode p2 = head;

        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1.data;

    }
}
