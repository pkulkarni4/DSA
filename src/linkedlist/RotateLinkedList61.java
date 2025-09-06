package linkedlist;

/*
Given the head of a linked list, rotate the list to the right by k places.

Ex:

Input: head = [1,2,3,4,5], k = 4
Output: [2, 3, 4, 5, 1]

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Input: head = [0,1,2], k = 4
Output: [2,0,1]

 */
public class RotateLinkedList61 {
    public static void main(String[] args) {

        LinkedListINode head = LinkedListINodeUtil.get5LinkedListINode();
        RotateLinkedListSolution ss = new RotateLinkedListSolution();
        LinkedListINode res = ss.rotateRight(head, 2);
        LinkedListINodeUtil.printLinkedListINode(res);
        System.out.println("-----");
        LinkedListINode threeNodes = LinkedListINodeUtil.get3LinkedListINode();
        LinkedListINode res1 = ss.rotateRight(threeNodes, 4);
        LinkedListINodeUtil.printLinkedListINode(res1);
        System.out.println("-----");
        LinkedListINode res2 = ss.rotateRight(threeNodes, 4);
        LinkedListINodeUtil.printLinkedListINode(res2);
    }
}

class RotateLinkedListSolution {
    /*
    first find len
    k = k % len as k can be higher than len
    traverse until len - k == 0
     */
    public LinkedListINode rotateRight(LinkedListINode head, int k) {
        int len = 1; //findLen(head);
        LinkedListINode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;

        LinkedListINode curr = head;
        LinkedListINode prev = null;
        int pointer = len - k - 1;

        for (int i = 0; i < pointer; i++) {
            curr = curr.next;
        }
        prev = curr.next;
        curr.next = null;
        tail.next = head;

        return prev;
    }
}
