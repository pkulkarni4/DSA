package linkedlist;

/*
Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes in the list so that the newly formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 ...

You are required to do this in place without altering the nodes' values.

Examples:

Input:  1 -> 2 -> 3 -> 4
Output: 1 -> 4 -> 2 -> 3
Explanation: Here n = 4, so the correct order is L0->L3->L1->L2

Input:  1 -> 2 -> 3 -> 4 -> 5
Output: 1 -> 5 -> 2 -> 4 -> 3
Explanation: Here n = 4, so the correct order is L0->L4->L1->L3->L2
 */
public class ReorderLinkedList143 {
    public static void main(String[] args) {

        LinkedListINode head = LinkedListINodeUtil.getLinkedListINode();
        ReorderLinkedList143Solution ss = new ReorderLinkedList143Solution();
        ss.reorderList(head);
    }
}

class ReorderLinkedList143Solution{
    /*
    Solution is to divide the linkedlist into two halves.
    Reverse the 2nd half
    Then join starting from first node.
    Ex:
    1->2->3->4->5->6->7->8->null
    divide into two halves
    LL1: 1->2->3->4->null
    LL2: 5->6->7->8->null
    reverse LL2: 8->7->6->5->null
    Merge:
    1->8->2->7->3->6->4->5->null
     */
    public void reorderList(LinkedListINode head) {
        if(head == null || head.next == null) return;

        // first half
        LinkedListINode ll = head;
        // second half
        LinkedListINode slow = head;
        LinkedListINode fast = head;
        LinkedListINode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

      /*
        System.out.println("first half");
        LinkedListINodeUtil.printLinkedListINode(ll);
        System.out.println("second half");
        LinkedListINodeUtil.printLinkedListINode(slow);
        */
        LinkedListINode rev = reverse(slow);

        // merge:
        mergeLL(ll, rev);

        LinkedListINodeUtil.printLinkedListINode(ll);
    }

    void mergeLL(LinkedListINode firstHalf, LinkedListINode secondHalf) {
        while(firstHalf!= null) {
            LinkedListINode l1 = firstHalf.next;
            LinkedListINode l2 = secondHalf.next;

            firstHalf.next = secondHalf;
            if(l1 == null) {
                break;
            }
            secondHalf.next = l1;
            // move to next node
            firstHalf = l1;
            secondHalf = l2;
        }
    }

    LinkedListINode reverse(LinkedListINode head) {
        LinkedListINode prev = null;
        LinkedListINode curr = head;
        while(curr != null) {
            LinkedListINode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr=nextNode;
        }
       // System.out.println("reverse 2nd half: ");
       // LinkedListINodeUtil.printLinkedListINode(prev);
        return prev;
    }
}